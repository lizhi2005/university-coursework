package Algorithm;

public class InsertSort {
    static void main() {
        int []arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int count =0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1])
            {
                count++;

            }else{break;}
        }
        System.out.println("开头有序个数count = " + count);


        for (int j = count+1; j < arr.length; j++) {
            int temp = arr[j];
            int k;
            for ( k = j - 1; k >= 0 && arr[k] > temp; k--) {
                arr[k + 1] = arr[k];
                }
            // 放入正确位置
            arr[k + 1] = temp;
            }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }







    }
}
