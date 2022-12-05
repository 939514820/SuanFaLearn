package array;

public class DuiTest<E> {
    Object[] queue = new Object[]{};
    // 堆排序 上浮操作
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            //找到根节点
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }
    // 如果是大顶堆 当前元素大于堆顶元素,那么当前元素就是最大元素了
//    public void  siftUpComparable1(int k, E x) {
//        Comparable<? super E> key = (Comparable<? super E>) x;
//        int parent=k>>>1;
//        Object curroot=queue[parent];
//        while(k>0){
//            if(key.compareTo((E)curroot)>=0){
//                break;
//            }
//            //比较并交换
//            queue[k] = e;
//            k = parent;
//        }
//        queue[k]=key;
//    }
}
