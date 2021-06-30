package Homework0323;

public class test {
}

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BinaryTree {
        public static TreeNode createBinaryTree1(){
            TreeNode a=new TreeNode(1);
            TreeNode b=new TreeNode(1);

            a.left=b;
            return  a;

        }

        public static TreeNode createBinaryTree2(){
            TreeNode a=new TreeNode(1);
            return  a;

        }

        public static boolean isSameTree(TreeNode p,TreeNode q){
            //判断两个数是否相等
            if(p==null && q==null){
                return true;
            }
            if(p==null || q==null){
                // 进入这个条件意味着, 一定是 p 和 q 其中一个为空, 一个不为空
                return false;
            }
            if(p.val != q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        public static boolean isSubtree(TreeNode s, TreeNode t) {
            if(s==null){
                return false;
            }
            boolean ret=isSameTree(s,t);

            if(ret){
            return ret;
            }
            if(s.val==t.val){
                return ret;
            }
            return isSubtree(s.left,t) ||isSubtree(s.right,t);

        }

        public static void main(String[] args) {
            TreeNode s=createBinaryTree1();
            TreeNode t=createBinaryTree2();
            boolean ret= isSubtree(s,  t);
            System.out.println(ret);

        }

    }


