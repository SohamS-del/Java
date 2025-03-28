import java.util.Scanner;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String test1 = "pop";
        String test2 = "pope";
        String test3 = "popop";
        int[] arr = new int[5];
        System.out.println(arr.length );

        System.out.println(isPalim(test1));
        System.out.println(isPalim(test2));
        System.out.println(isPalim(test3));
    }

    public static boolean isPalim(String x) {
        int left = 0;
        int right = x.length() - 1;

        while (left < right) {
            if (x.charAt(left) != x.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
