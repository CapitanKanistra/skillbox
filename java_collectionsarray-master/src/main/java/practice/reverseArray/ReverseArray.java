package practice.reverseArray;


public class ReverseArray {

    public static <T> void reverse1(T[] arr) {
        for (int i = 0, n = arr.length, m = n-- / 2; i < m; i++) {
            T tmp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = tmp;
        }
    }

    public static String[] reverse(String... arr) {
        for (int i = 0, n = arr.length, m = n-- / 2; i < m; i++) {
            String tmp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = tmp;
        }
        return arr;
    }
}


