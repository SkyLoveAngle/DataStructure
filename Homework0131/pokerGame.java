package Homework0131;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class pokerGame {
        //使用数组把四种花色提前准备好
        public static final String[] suits ={"❤","♦","♣","♠"};

        //一副牌中有许多张单牌组成，所以用一个List线性表来“装载”。
        private static List<Card> creatPoker(){
            List<Card> poker = new ArrayList<>();
            //用这层循环处理四种花色。
            for (int i=0;i<4;i++){
                //这层循环处理每种花色的13张牌，J，Q，K，A,大小王单独处理。
                for (int j=2;j<=10;j++){
                    poker.add(new Card(suits[i],""+j));
                    //String.valueOf(j)可以用 ""+j 替换。将int类型转换成字符串类型。
                }
                poker.add(new Card(suits[i],"J"));
                poker.add(new Card(suits[i],"Q"));
                poker.add(new Card(suits[i],"K"));
                poker.add(new Card(suits[i],"A"));
            }
            poker.add(new Card("","big Joker"));
            poker.add(new Card("","small Joker"));
            return poker;
        }

        //list自身是可变对象，直接修改poker的内容就会对List本身造成影响，就不需要额外返回list<Card>了。
        // 洗牌思路：从后往前遍历List，取到当前位置元素和前面随机位置元素进行交换。
        private static void shuffle(List<Card> poker) {
            Random random = new Random();
            for (int i = poker.size() - 1; i > 0; i--) {
                // 产生 [0, i) 的随机数, 要和哪个位置的元素交换
                int pos = random.nextInt(i);
                swap(poker, i, pos);
            }
        }

        private static void swap(List<Card> poker, int i, int j) {
            Card tmp = poker.get(i);
            poker.set(i, poker.get(j));
            poker.set(j, tmp);
        }

    public static void main(String[] args) {
        //1.需要先创建出一副牌。
        List<Card> poker = creatPoker();

        //2.洗牌。
        shuffle(poker);

        //3. 发牌, 假设有三个玩家, 每个玩家, 给发 5 张牌
       /*
        //每个玩家手里有 5 张牌, 这 5 张牌就使用另外一个 ArrayList 表示.
        //此时可以把这三个玩家也放到一个 List 中.
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
         */
        // players 类型仍然是 List, 泛型参数, 是一个 List<Card> , 每个元素就是一个 List<Card>
        List<List<Card>> players = new ArrayList<>();
        // 每次 add 的元素都是一个 ArrayList<Card> 类型
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Card top = poker.remove(0);
                List<Card> player = players.get(j);
                player.add(top);
            }
        }

        // 4. 展示手牌
        for (int i = 0; i < players.size(); i++) {
            List<Card> player = players.get(i);
            System.out.println("玩家" + i + " 的手牌是: " + player);
        }
    }
}
