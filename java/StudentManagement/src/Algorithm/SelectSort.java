package Algorithm;

public class SelectSort {
    public static void main(String[] args){
        int[] arr = {56, 23, 9, 78, 45, 12, 89, 34, 67, 10};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        
    }
    
    
    
    
}
