package Homework0323;

public class doubleSelectionSort {
    public static void main(String[] args) {
        int[] data = new int[] { 46,74,53,14,26,36,86,65,27,34 };
        System.out.println("原始数组：");
        print(data);
        System.out.println("双向选择排序处理过程：");
        DoubleSelectSort(data);
        System.out.println("双向选择排序处理后的数组：");
        print(data);
    }

    public static void DoubleSelectSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        // [begin,end] 表示整个无序区间
        while (begin <= end) {
            int minIndex = begin;
            int maxIndex = end;//无序区间的最大值和最小值
            for (int i = begin ; i <= end; ++i) {
                if (array[i] < array[minIndex])
                    minIndex = i;
                if (array[i] > array[maxIndex])
                    maxIndex = i;
            }
            swap(array, minIndex, begin);
            print(array);
            //当首位为最大值时，需要单独处理
            if (maxIndex == begin) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, end);
            print(array);
            begin++;
            end--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void print(int[] data) {
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j] + "\t");
        }
        System.out.println();
    }
}
