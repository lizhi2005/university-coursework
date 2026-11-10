package Algorithm;

public class BubbleTest {

    static void main() {
        int[] arr = {56, 23, 9, 78, 45, 12, 89, 34, 67, 10};
        for (int i = 0; i < arr.length-1; i++) {
            for (int i1 = 0; i1 < arr.length-i-1; i1++) {
                if(arr[i1]>arr[i1+1]){
                    int temp=arr[i1];
                    arr[i1]=arr[i1+1];
                    arr[i1+1]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }











    }


}
