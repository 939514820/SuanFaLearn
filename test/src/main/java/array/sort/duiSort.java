package sort;

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

public class duiSort {
    public static void initHeap(int[] a, int i, int len) {
//        {23,4,11,3,10,34,21};
        //      23
        //   4    11
        // 3 10  34 21
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 构造大顶堆

            int maxIndex = i;
            if (a[i] < a[k]) {
                maxIndex = k;
            }
            if (k + 1 < len) {
                if (a[i] < a[k + 1]) {
                    maxIndex = k;
                }
            }
            if (maxIndex != i) {
                int temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp;
            }
        }

        // 换最后一个和第一个
        // 下浮操作
    }

    //    public int[] sort(int a[]){
//        for (int i = 0; i < (a.length-1)/2; i++) {
//            heap(a,i,i);
//        }
//    }
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
        int temp;
//        //堆排序
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            initHeap(arr, i, arr.length);
//        }
//
//        for (int j = arr.length - 1; j > 0; j--) {
//            System.out.print(arr[0] + ",");
//            temp = arr[j];
//            arr[j] = arr[0];
//            arr[0] = temp;
//            initHeap(arr, 0, j);
//        }
        System.out.println();
        heapSort(arr);
//        System.out.println(Arrays.toString());

        // 创建初始堆 0,1,2,3,4,5,6,
        // 从最后一个父节点开始 依次构建大顶堆 a[i]>a[1*2+1],a[i]>a[i*2+2]
        // for(int i=len-1/2,i>=0,i--){
//                for(int k=2*i+1;k<len;k=2*i+1){
//                    // 比较并交换
                      //
//                }
        //  }
        // 元素出堆
//        for(int j=len-1;j>0;j--){
//            // 交换第一个与最后一个
//            // swap(a,0,j)
//            // 下沉
//            // down();
//        }

//        while(k>0){
//            // k=2*p+1 -》 p=k-1 /2
//          int   parent=(k-1)>>>1;
//          if(a[k]>a[parent]){//
//              a[k]=a[parent];
//
//          }else{
//
//          }
//            k=parent;
//
//        }


        PriorityBlockingQueue queue=new PriorityBlockingQueue();
        queue.offer(1);
        queue.poll();
    }

}
