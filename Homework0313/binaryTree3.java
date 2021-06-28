package Homework0313;
                         /*二叉搜索树与双向链表（中序遍历）*/
public class binaryTree3 {
    //创建一棵树（手动写死的方式）
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    TreeNode head, pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;
        }
        dfs(root);
        //进行头节点和尾节点的相互指向
        pre.right = head;
        head.left =pre;
        return head;
    }

    public void dfs(TreeNode cur){
        if(cur==null){
            return ;
        }
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,
        // 当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if(pre==null) {
            head = cur;
        }//反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        else{
            pre.right = cur;
        }
        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }


    public static void main(String[] args) {

    }
}
