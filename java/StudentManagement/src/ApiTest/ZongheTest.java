package ApiTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ZongheTest {

    static void main() {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();

        while(true){
            System.out.println("请输入一个整数");
            String str=sc.nextLine();
            int num=Integer.parseInt(str);
            if(num<0||num>100){
                System.out.println("输入错误");
                continue;
            }
            list.add(num);
            if(sum(list)>=200){
                System.out.println("输入结束");
                System.out.println("输入的整数的和为"+sum(list));
                break;
            }
        }
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }

    }

    public static int sum(ArrayList<Integer> list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }

}
