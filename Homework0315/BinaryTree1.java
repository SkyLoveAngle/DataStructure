package Homework0315;

//二叉搜索树
//对二叉搜索树进行中序遍历，就可以得到一个有序序列！！！

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
含义是把二叉搜索树进行中序遍历，按照中序遍历的结果构造双向链表，
使用left指向前一个节点，使用right指向后一个节点
 */

public class BinaryTree1 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            // 空树, 就直接返回空链表
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            // 只有一个根节点的树, 直接返回该节点.
            return pRootOfTree;
        }
        // 递归处理左子树, 得到左子树的链表的头结点
        TreeNode leftHead = Convert(pRootOfTree.left);
        // 把当前节点尾插到左侧链表的末尾
        // 需要先找到左侧链表的末尾节点, 才能进行尾插
        TreeNode leftTail = leftHead;
        while (leftTail != null && leftTail.right != null)  {
            leftTail = leftTail.right;
        }
        // 进行尾插操作
        if (leftHead != null) {
            // 如果 根节点的左子树是 null,
            // 就不能进行下列代码了.
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 递归处理右子树
        TreeNode rightHead = Convert(pRootOfTree.right);
        // 把当前节点插入到右侧链表的头部
        if (rightHead != null) {
            rightHead.left = pRootOfTree;
            pRootOfTree.right = rightHead;
        }
        // 最终返回当前这个组装好的链表的头结点.
        return leftHead != null ? leftHead : pRootOfTree;
    }
}






