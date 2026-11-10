package ExceptionTest;

import java.util.Scanner;

public class Test1 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("输入名字");
            String name = sc.nextLine();
            System.out.println("输入年龄");
            int age = sc.nextInt();
            Friend f = new Friend(name, age);
            System.out.println(f);
            break;

        }
        
       
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
