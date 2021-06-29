package Homework0320;

public class MyPriorityQueue {

   /*
     向下调整是创建堆的一个核心操作
     前提条件, 要求当前被调整节点的左右子树都已经是堆了！
     方法参数给出了一个 size 表示当前数组的有效元素大小.
     虽然可以通过 arr.length 取到大小, 这个大小是数组的总的大小
     index 表示从这个位置开始进行向下调整，
     还是按照大堆的方式来实现.
     时间复杂度 O(logN)
     如果数据是依次 (* 2 )(/ 2) 的方式变化的时候, 时间复杂度基本都和 logN 相关
    */

    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;//此处得到的是左子树
        while (child < size) {
            // 需要找到左右子树中较大的值
            // 左右子树下标差 1，child+1得到的是右子树
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            // 当上述条件执行完后, 就能保证 child 指向左右子树较大的元素。
            // 拿父节点和刚才找出的这个较大的节点再去比较, 看是否符合大堆的要求！
            if (arr[parent] < arr[child]) {
                // 不满足大堆的要求, 交换两个元素。
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
            } else {
                // 调整完毕了, 已经把父元素放到了合适的位置上
                break;
            }
            // 更新 parent 和 child 以备下次循环
            parent = child;
            child = 2 * parent + 1;
        }
    }


    /*
    向上调整只需要保证该节点比父节点大即可！！！
     */

    public static void shiftUp(int[] arr, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        // 如果 child 为 0, 说明已经调整到最上面了
        while (child > 0) {
            if (arr[parent] < arr[child]) {
                // 不符合大堆的要求
                // 交换两个元素
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 建堆操作
    public static void createHeap(int[] array) {
        /*
         基于向下调整的建堆:
         从后往前遍历数组, 针对每个下标都去进行向下调整即可~~
         此处的循环不必从 length - 1 开始.从叶子节点往下进行查找是不合适的~~
         从第一个非叶子节点开始进行向下调整,
         实际向下调整的时候不一定非得从最后一个元素的下标开始.
         可以从最后一个非叶子节点开始即可.就可以通过最后一个节点再找到父节点即可~~
         直观上看, 建堆的时间复杂度 O(NlogN)
         但是实际上, 不是, 实际上是 O(N) (数学推导出来的)
         */
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    // 往堆中插入元素
    // 这就表示当前存储堆的数组
    private int[] arr = new int[100];
    private int size = 0;
    public void offer(int val) {
        if (size >= arr.length) {
            // 插入失败, 已经满了.
            // 也可以实现扩容逻辑.
            return;
        }
        // 先是把这个元素给尾插到数组末尾
        arr[size] = val;
        size++;
        // 把最后的这个元素进行向上调整
        shiftUp(arr, size, size - 1);
    }


    // 类似的, 也可以使用向上调整(基于 offer) 的方式来建堆
    public void createHeap2(int[] arr) {
        // 循环遍历数组, 把元素通过 offer 方法插入即可
        for (int x : arr) {
            offer(x);
        }
    }

    // 获取堆顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[0];
    }

    // 删除操作(一定是删除堆顶的元素)
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int result = arr[0];

        // 交换 0 号元素和 size - 1 号元素
        int tmp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = tmp;

        // size--, 把最后的元素干掉
        size--;

        // 从 0 号元素开始, 往下进行向下调整
        shiftDown(arr, size, 0);
        return result;
    }
}
