package Homework0315;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  //创建一颗二叉树
  public static TreeNode creat(){
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


  //二叉树的层序遍历（用队列来实现）
  public  static void Levelorder(TreeNode root){
    if (root == null){
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(true){
      TreeNode cur = queue.poll();
      if (cur == null){
        break;
      }
      //访问当前的节点，就用打印表示访问即可。
      System.out.print(cur.val);
      //把该节点的左子树入队列，右子树入队列
      if (root.left != null){
        queue.offer(cur.left);
      }
      if (root.right != null) {
        queue.offer(cur.right);
      }
    }
  }


  //判断一棵树是不是完全二叉树
  /*
  1.针对这个二叉树进行层序遍历
  2.遍历过程要分成两个部分
    a)首先，要求每个节点必须有两个子树，如果某个节点只有左子树或者没有子树
    （进入了最后一个分叉或者是叶子节点），则进入b，
    如果某个节点只有右子树，则直接判定不是完全二叉树。
    b)要求每个节点必须没有子树，如果发现某个节点有子树，就说明这个树不是完全二叉树。
   */
  public static boolean isCompleteTree(TreeNode root) {
    // 通过层序遍历的方式来实现
    if (root == null) {
      return true;
    }
    // 分成两个阶段来进行判定
    // 定义一个变量isLeve2,这个变量为false, 表示当前是第一阶段,
    // 变量为 true 表示进入第二阶段
    boolean isLevel2 = false;
    // 层序遍历, 需要有一个队列
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (true) {
      TreeNode cur = queue.poll();
      if (cur == null) {
        break;
      }
      // 针对当前节点进行访问.
      // 此处的访问是一系列的逻辑判断
      if (!isLevel2) {
        // 第一阶段的逻辑
        if (cur.left != null && cur.right != null) {
          // 这是一个符合要求的节点, 继续往下遍历即可.
          // 此时直接把左右子树入队列即可
          queue.offer(cur.left);
          queue.offer(cur.right);
        } else if (cur.left == null && cur.right != null) {
          // 第一阶段中发现只有右子树的节点!!
          // 说明这个树一定不是完全二叉树
          return false;
        } else if (cur.left != null && cur.right == null) {
          // 遇到了这个节点不符合第一阶段的条件,
          // 进入到第二阶段继续判定
          isLevel2 = true;
          queue.offer(cur.left);
        } else {
          // 这个节点没有子树
          // 也是进入到第二阶段继续判定
          isLevel2 = true;
        }
      } else {
        // 第二阶段的逻辑
        if (cur.left != null || cur.right != null) {
          // 发现第二阶段的某个节点的子树不为空, 此时就认为当前不是完全二叉树
          return false;
        }
      }
    }
    // 遍历了整个树, 也没找到 return false 的反例.
    return true;
  }


  public static void main(String[] args) {
    TreeNode root = creat();

    Levelorder(root);

    System.out.println(isCompleteTree(root));
  }
}
