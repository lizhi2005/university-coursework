package Util;

public class ArrUtil {

    private ArrUtil(){}


    public static String printArr(int[]arr){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i <arr.length ; i++) {
            if(i== arr.length-1)
            {
                sb.append(arr[i]);
            }
            else{
                sb.append(arr[i]+",");
            }
                                             }
        sb.append("]");
        return sb.toString();
    }

    public static double getAerage(double[]arr){
        double count=0;
        for (int i = 0; i <arr.length ; i++) {
            count+=arr[i];
        }
        return count/arr.length;
    }



}
