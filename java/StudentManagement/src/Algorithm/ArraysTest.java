package Algorithm;

import java.util.Arrays;

public class ArraysTest {
    static void main() {
        int[] arr = {1,5,9,11,23,56,78,89,110,116,456};
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr,9));

        int []newArr=Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(newArr));


        int []newArr2=Arrays.copyOfRange(arr,0,arr.length);
        System.out.println(Arrays.toString(newArr2));


        Arrays.fill(arr,100);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {56, 23, 9, 78, 45, 12, 89, 34, 67, 10};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));








    }
}
