package array.sort;

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

public class duiSort {

    private static void heapSort(int[] arr) {
        int temp = 0;
        //堆排序
        for (int i = arr.length / 2 - 1; i >= 0; i--) {// 父亲节点
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * 将以i对应的非叶子节点的树调整成一个大顶堆
     * 举例 int[] arr = {4,6,8,5,9};=>i=1 =>{4,9,8,5,6} => i=0 =>{9,6,8,5,4}
     *
     * @param arr
     * @param i      表示非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //a[i]>a[2i+1]&&a[i]>a[2i+2]
        int temp = arr[i];
        // 0 1 2
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //先比较左子节点和右子节点的大小，最大的那个和temp进行交换
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//k指向右子节点
            }
            //如果非子节点的值小于左子节点和右子节点的值
            if (arr[k] > temp) {
                //temp和arr[k]进行交换
                arr[i] = arr[k];
                i = k;//继续循环比较，假设k是左子节点，k+1是右子节点，然后引出公式
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上（局部）
        arr[i] = temp;// 相當於arr【k】=arr【i】
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23, 4, 11, 3, 10, 34, 21};

        System.out.println();
        heapSort(arr);
        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.offer(1);
        queue.poll();
    }

}
