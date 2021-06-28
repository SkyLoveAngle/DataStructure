package Homework0313;
    class BinaryTree {
        //创建一棵树（手动写死的方式）
        public static Node build() {
            Node a = new Node("A");
            Node b = new Node("B");
            Node c = new Node("C");
            Node d = new Node("D");
            Node e = new Node("E");
            Node f = new Node("F");
            Node g = new Node("G");

            a.left = b;
            a.right = c;
            b.left = d;
            b.right = e;
            e.left = g;
            c.right = f;
            return a;
        }

//        //前序遍历（普通法）
//        public static void preOrder(Node root) {
//            if (root ==null){
//                return;
//            }
//            //访问根节点（此处定义的访问就是打印）
//            System.out.print(root.val);
//            //递归遍历左子树
//            preOrder(root.left);
//            //递归遍历右子树
//            preOrder(root.right);
//        }
//
//        //中序遍历（普通法）
//        public static void inOrder(Node root){
//            if(root ==null){
//                return;
//            }
//            //先递归处理左子树
//            inOrder(root.left);
//            //在访问根节点
//            System.out.print(root.val);
//            //最后递归处理右子树
//            inOrder(root.right);
//        }
//
//        //后序遍历（普通法）
//        public static void postOrder(Node root){
//            if(root ==null){
//                return;
//            }
//            //先递归处理左子树
//            inOrder(root.left);
//            //再递归处理右子树
//            inOrder(root.right);
//            //最后访问根节点
//            System.out.print(root.val);
//        }

        //求节点个数
        // 方法1
        //使用这个成员变量count，来记录元素个数
        public static int count = 0;
        public static void length1(Node root){
            if (root == null){
                return;
            }
            //访问根节点，此时的访问操作就是count++
            count++;
            //递归处理左子树
            length1(root.left);
            //递归处理右子树
            length1(root.right);
        }

        //方法2：(通过方法的返回值记录元素)
        public static int length2(Node root){
            if (root == null){
                return 0;
            }
            //当前树的节点个数=根结点的个数+左子树的结点数+右子树的节点数
            return 1 + length2(root.left) + length2(root.right);
        }

        //求叶子节点的个数
        //方法1
        public static int leafsize = 0;
        public static void getleafSize1(Node root){
            //针对二叉树边遍历，判断当前节点是否为叶子节点，如果是就size++
            if (root == null){
                return;
            }
            //判断当前节点是否是叶子节点
            if (root.left == null && root.right == null){
                leafsize++;
            }
            getleafSize1(root.left);
            getleafSize1(root.right);
        }

        //方法2：
        public static int getleafSize2(Node root){
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return 1;
            }
            return getleafSize2(root.left) + getleafSize2(root.right);
        }

        //求第K层节点的个数
        public static int getKLevelSize(Node root,int k){
            if (root == null || k<1){
                return 0;
            }
            if (k == 1){
                //当前树只有一个根节点时
                return 1;
            }
            return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
        }

        //获取二叉树的高度
        public static int getHeight(Node root){
            if (root == null){
                return 0;
            }
            int LeftHeight = getHeight(root.left);
            int RightHeight = getHeight(root.right);
            return 1+(LeftHeight > RightHeight ? LeftHeight : RightHeight);
        }

        // 查找 val 所在结点，没有找到返回 null，按照 根 -> 左子树 -> 右子树的顺序进行查找
        // 一旦找到，立即返回，不需要继续在其他位置查找
        public static Node find(Node root,String toFind){
            if (root == null){
                return null;
            }
            if (root.val.equals(toFind)){
                return root;
            }
            Node result = find(root.left,toFind);
            if (result != null){
                return result;
            }
            return find(root.right,toFind);
        }


        public static void main(String[] args) {
            Node root = build();

//            System.out.print("前序遍历二叉树（普通法）：");
//            preOrder(root);
//
//            System.out.print("\n"+"中序遍历二叉树（普通法）：");
//            inOrder(root);
//
//            System.out.print("\n"+"后序遍历二叉树（普通法）：");
//            preOrder(root);

            length1(root);
            System.out.print("\n"+"方法1求二叉树节点的个数："+count);

            System.out.print("\n"+"方法2求二叉树节点的个数："+length2(root));

            getleafSize1(root);
            System.out.print("\n"+"方法1求该二叉树叶子节点个数："+leafsize);

            System.out.print("\n"+"方法2求该二叉树叶子节点个数："+getleafSize2(root));

            System.out.print("\n"+"求二叉树第2层节点的个数："+getKLevelSize(root,2));

            System.out.print("\n"+"求二叉树的高度："+getHeight(root));

            System.out.print("\n"+"查找节点值为“E”的节点是二叉树中的第几节点？："+find(root,"E"));


        }
    }

