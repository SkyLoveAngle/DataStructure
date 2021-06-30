package Homework0323;

public class BinaryInsertSortTest {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        System.out.println("原始数组：");
        print(data);
        System.out.println("折半插入排序处理过程：");
        binaryInsertSort(data);
        System.out.println("折半插入排序处理后的数组：");
        print(data);
    }

    public static void binaryInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int left = 0;
            int right = i;
            //[left,right)表示搜索区间，该区域是有序的。
            while (left < right) {
                int mid = (left + right) / 2;//记录搜索区域中间位置
                if (val >= arr[mid]) {
                    left = mid + 1;  //此处用到了二分查找的思想
                } else {
                    right = mid;
                }
            }
            //接下来将left-i处的数据整体后移一位
            for (int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            arr[left] = val;
            print(arr);
        }
    }

    public static void print(int[] data) {
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j] + "\t");
        }
        System.out.println();
    }
}
