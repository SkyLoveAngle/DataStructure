package Homework0327;
/*
二叉搜索树的基本操作
 */

class  BinarySearchNode {
    public int key;
    public int value;
    public BinarySearchNode left;
    public BinarySearchNode right;

    public BinarySearchNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class BinarySearchTree {

    // 通过 root 表示树的根节点，空树就使用 null 来表示
    private BinarySearchNode root = null;

    //1.get()方法，用于根据 key 来找 value
    public Integer get(int key) {
        BinarySearchNode cur = root;
        while (cur != null) {
            if (key < cur.key) {
                //从左子树开始找。
                cur = cur.left;
            } else if (key > cur.key) {
                //从右子树开始找。
                cur = cur.right;
            } else {
                // key 相等, 找到了value。
                return cur.value;
            }
        }
        //遍历整棵树都没找到value。
        return null;
    }



    //2.put( )方法，用于插入新节点
    public void put(int key, int value) {
        // a. 如果当前树是空树, 就把这个新节点作为根节点即可
        if (root == null) {
            root = new BinarySearchNode(key, value);
            return;
        }
        // b. 树不为空的情况, 就需要找到该节点要放到哪个位置上
        //首先，在查找所放未知的过程中，我们需要时刻记录父节点的位置.
        BinarySearchNode cur = root;
        BinarySearchNode parent = null;
        while (cur != null) {
            if (key < cur.key) {
                // 往左子树找位置
                cur = cur.left;
                parent = cur; //保证 parent 时刻指向 cur 的父节点
            } else if (key > cur.key) {
                // 往右子树找位置
                cur = cur.right;
                parent = cur;
            } else {
                // 当key值相等时，意味着在这个树上找到了一个重复的 key
                // 此时，只需要修改 value的值即可~~
                cur.value = value;
                return;
            }
        }
        // 当 while 循环结束的时候, 说明 cur 已经是 null（到达某个叶子节点的下面）
        // 也就找到合适的插入位置了. 就是把当前节点插入到 parent这个节点（叶子节点）的子树上即可~~
        // 先判断新节点应该是 parent 的左子树还是右子树~~
        // 拿着新节点的 key 和 parent 的 key 再比较一次即可
        BinarySearchNode newNode = new BinarySearchNode(key, value);
        if (newNode.key < parent.key) {
            // 插入到 parent 的左边
            parent.left = newNode;
        } else {
            // 插入到 parent 的右边
            parent.right = newNode;
        }
    }


    //3.remove( )方法,用于删除节点
    public void remove(int key) {
        //先查找这个 key 对应的节点是哪个，这里的查找也需要记录 parent 的位置
        BinarySearchNode cur = root;
        BinarySearchNode parent = null;
        while (cur != null) {
            if (key < cur.key) {
                // 往左子树中找
                cur = cur.left;
                parent = cur;
            } else if (key > cur.key) {
                // 往右子树中找
                cur = cur.right;
                parent = cur;
            } else {
                // key值相等, cur节点就是待删除的节点~~
                // 此处使用 removeNode() 方法来完成具体的删除节点的过程
                removeNode(parent, cur);
                return;
            }
        }
    }

    // removeNode()方法只应该由 remove()方法来使用,故用private来修饰~~
    private void removeNode(BinarySearchNode parent, BinarySearchNode cur) {

            // 1. 要删除的节点没有左子树
        if (cur.left == null) {
            // 1.1 待删除节点是根节点
            if (cur == root) {
                root = cur.right;
            }
            // 1.2 cur 不是根节点, 并且是父亲的右子树
            else if (cur == parent.right) {
                parent.right = cur.right;
            }
            // 1.3 cur 不是根节点, 并且是父亲的左子树
            else if (cur == parent.left) {
                parent.left = cur.right;
            }

            // 2. 要删除的节点没有右子树
        } else if (cur.right == null) {
            // 2.1 要删除的节点是根节点
            if (cur == root) {
                root = cur.left;
            }
            // 2.2 要删除的节点不是根节点, 且是父亲的右子树
            else if (cur == parent.right) {
                parent.right = cur.left;
            }
            // 2.3 要删除的节点不是根节点, 且是父亲的左子树
            else if (cur == parent.left) {
                parent.left = cur.left;
            }
        }

        // 3. 要删除的节点左右子树都有
        else {
            //3.1 先在右子树中, 找到最小值, 并且记录这个最小值的父节点
                  //或者在左子树中找最大值，两个方法都可以~~
            BinarySearchNode goat = cur.right;
            BinarySearchNode goatParent = cur;
            while (goat.left != null) {
                goat = goat.left;
                goatParent = goat;
            }
            // 当上面while循环结束的时候, goat节点就指向了右子树中的最小值
            // 最小值这个节点的特点就是： left 为 null

            // 3.2 就把goat节点的值赋给待删除节点
            cur.key = goat.key;
            cur.value = goat.value;
            // 赋值操作完成后, 原来的待删除节点的内容就没了~~
            // 同时 goat 节点也就失去了利用价值, 可以删除掉了~~
            // 删除 goat 的时候需要知道 goat 是父亲的左子树还是右子树
            if (goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }
}
