package Homework0313;
                       //二叉树的遍历（递归法 和 迭代法）
import java.util.*;

public class BinaryTree2 {
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

    //前序遍历（递归法）
    public static List<Integer> preorder_Recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  //这里当root为null需要返回的是result，尽量不要用null!
        }
        //访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        //递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(preorder_Recursion(root.left));
        //递归处理右子树, 此时会得到一个右子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(preorder_Recursion(root.right));
        return result;
    }

    //前序遍历（迭代法）
    /*
    创建一个Stack用来存放节点，首先我们想要打印根节点的数据，
    此时Stack里面的内容为空，所以我们优先将头结点加入Stack，然后打印。
    之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
     */
    public static List<Integer> preorder_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    //中序遍历（递归法）
    public static List<Integer> inorder_Recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  //这里当root为null需要返回的是result，尽量不要用null!
        }
        //递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(inorder_Recursion(root.left));
        //访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        //递归处理右子树, 此时会得到一个右子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(inorder_Recursion(root.right));
        return result;
    }

    //中序遍历（迭代法）
    /*
    先创建一个Stack，然后按 左 中 右的顺序输出节点。
    尽可能的将祖宗节点的左子树压入Stack，此时栈顶的元素是最左侧的元素，
    其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，并且在寻找的过程中记录了来源，
    才能返回上层,同时在返回上层的时候已经处理完毕左子树了。。
    当处理完最小单位的子树时，返回到上层处理了中间节点。
    处理流程就是： 左子树->中间(祖宗节点)->右子树）
    如果有右节点，其也要进行中序遍历。当整个左子树退栈的时候这个时候输出了该二叉树的根节点，
    之后输出中间祖宗节点 。然后处理右子树。
     */
    public static List<Integer> inorder_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return res;
    }

    //后序遍历（递归法）
    public static List<Integer> postorder_Recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  //这里当root为null需要返回的是result，尽量不要用null!
        }
        //递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(postorder_Recursion(root.left));
        //递归处理右子树, 此时会得到一个右子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(postorder_Recursion(root.right));
        //访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        return result;
    }

    //后续遍历（迭代法）
    /*
    前序遍历的过程 是 中左右。后续遍历就是将其转化成 中右左。
    也就是压栈的过程中优先压入左子树，在压入右子树。
    然后将这个结果返回来，这里是利用栈的先进后出倒序打印。
     */
    public static List<Integer> postorder_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
            return res;
    }


    public static void main(String[] args) {
        TreeNode root = build();

        System.out.print("前序遍历二叉树（递归法）："+preorder_Recursion(root));
        System.out.print("\n"+"前序遍历二叉树（迭代法）："+preorder_Iteration(root));

        System.out.print("\n"+"中序遍历二叉树（递归法）："+inorder_Recursion(root));
        System.out.print("\n"+"中序遍历二叉树（迭代法）："+inorder_Iteration(root));

        System.out.print("\n"+"后序遍历二叉树（递归法）："+postorder_Recursion(root));
        System.out.print("\n"+"后序遍历二叉树（迭代法）："+postorder_Iteration(root));

    }
}
