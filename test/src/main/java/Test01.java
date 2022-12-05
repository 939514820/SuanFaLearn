import java.util.Arrays;

public class Test01 {

    public static int[] sort(int[] a) {
        if (a.length < 1) {
            return a;
        }

        for (int i = 0; i < a.length; i++) {
            int index = i;
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    index = j;
                }
                min = Math.min(min, a[j]);

            }
            System.out.println(a[index]);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{10, 4, 5, 67, 3, 2, 3})));
    }
}
