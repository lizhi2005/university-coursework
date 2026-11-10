package Algorithm;

import java.util.ArrayList;

public class AlgorithmTest1 {
    static void main() {
        int[] arr={1,2,3,9,4,5,6,7,8,9,10};
        ArrayList<Integer> list=sort(arr,0);

        System.out.println(list);

    }
    public static ArrayList<Integer> sort(int[] arr,int num) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]==num){
                list.add(i);
            }
        }
        return list;
    }
}
