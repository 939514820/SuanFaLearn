import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class Test11 {


    public static int[] sort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            sort(a, low, middle - 1);
            sort(a, middle + 1, high);
        }
        return a;
    }

    public static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && temp <= a[high]) {
                high--;
            }
            a[low] = a[high];
            a[high] = temp;
            while (low < high && a[low] <= temp) {
                low++;
            }
            int t = a[high];
            a[high] = a[low];
            a[low] = t;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 3,17, 21, 1};//4,9,3,21,1

        System.out.println(Arrays.toString(sort(a, 0, a.length - 1)));
//        String x = "acb" ;
//        String y = "acb" ;
//        String z = new String ( "acb" );
//        String z1 = new String ( "acb" );
//        System . out . println ( x == y ); // true
//        System . out . println ( x == z ); // false
//        System . out . println ( z1 == z ); // false
//        ConcurrentHashMap
//        ArraysyList
//        Arrays.sort(a);
//        HashMap map=new HashMap();
//        map.put(new Object(),1);

    }
}
