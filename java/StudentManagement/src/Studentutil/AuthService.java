package Studentutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AuthService {
    private List<Student> students;

    public AuthService() {
        students = new ArrayList<>();
    }
    public boolean register(ArrayList<Student> students) {
        Student student=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        student.setUsername(sc.nextLine());
        System.out.println("请输入密码：");
        student.setPassword(sc.nextLine());
        System.out.println("请输入确认密码：");
        student.setPassword2(sc.nextLine());
        System.out.println("请输入身份证号：");
        student.setId(sc.nextLine());
        System.out.println("请输入手机号：");
        student.setPhonenumber(sc.nextLine());
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getUsername().equals(student.getUsername())) {
                System.out.println("Username already exists");
                return false;
            }
        }
        String pwd=student.getPassword();
        if(pwd.length()>15||pwd.length()<3) {
            System.out.println("Password length must be between 3 and 15 characters");
            return false;
        }
        int countnum=0;
        int countalpht=0;
        for (int i = 0; i <pwd.length() ; i++) {
            char c=pwd.charAt(i);
            if(c>='0'&&c<='9'||c>='a'&&c<='z'||c>='A'&&c<='Z') {
                if(c>='a'&&c<='z'||c>='A'&&c<='Z') {
                    countalpht++;
                } else if(c>='0'&&c<='9'){
                    countnum++;
                }
            }
        }
        if(countnum==0||countalpht==0) {
            System.out.println("Password must contain both letters and numbers");
            return false;
        }
        if(!student.getPassword2().equals(pwd)) {
            System.out.println("Password and confirm password must be the same");
            return false;
        }
        String userid=student.getId();
        if(userid.length()!=18) {
            System.out.println("ID must be 18 characters long");
            return false;
        }
        if(userid.charAt(0)=='0')
        {
            System.out.println("ID must start with not 0");
            return false;
        }
        for (int i = 0; i <userid.length() ; i++) {
            char c=userid.charAt(i);
            if(i<17){
                if(c<'0'||c>'9'){
                    System.out.println("ID must contain only numbers");
                    return false;
                }
            }
            if(i==17){
                if(c<'0'||c>'9'&&c!='X'&&c!='x'){
                    System.out.println("ID must contain only numbers or X at the end");
                    return false;
                }
            }

        }
        String phonenum=student.getPhonenumber();
        if(phonenum.length()!=11) {
            System.out.println("Phone number must be 11 characters long");
            return false;
        }
        for (int i = 0; i <phonenum.length() ; i++) {
            char c=phonenum.charAt(i);
            if(c<'0'||c>'9'){
                System.out.println("Phone number must contain only numbers");
                return false;
            }
            if(i==0){
                if(c=='0'){
                    System.out.println("Phone number must start with not 0");
                    return false;
                }
            }

        }
        students.add(student);
        return true;
    }
    private String generateVerificationCode() {
        char[]arr=new char[52];
        for (int i = 0; i <arr.length ; i++) {
            if(i<26){
                arr[i]=(char)('A' + i) ;
            }
            else {
                arr[i]=(char)('a'+i-26);
            }
        }
        Random r=new Random();
        String S1="";
        for (int i = 0; i <4 ; i++) {
            S1=S1+arr[r.nextInt(arr.length)];
        }
        S1=S1+r.nextInt(10);
        String S2="";
        char[] c=S1.toCharArray();
        int num=r.nextInt(S1.length());
        for (int i = 0; i < c.length; i++) {
            char temp=c[num];
            c[num]=c[i];
            c[i]=temp;
        }
        for (int i = 0; i < c.length; i++) {
            S2=S2+c[i];
        }
        return S2;
    }


    public  boolean login(ArrayList<Student> students) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean flag=true;
        //未注册
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getUsername().equals(username)) {
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("Username not found");
            System.out.println("用户名未注册，请先注册");
            return false;
        }
        int attempts = 3; // 3次密码输入机会
        while (attempts > 0) {
            // 生成并显示验证码
            String verificationCode = generateVerificationCode();
            System.out.println("验证码：" + verificationCode);
            System.out.print("请输入验证码：");
            String inputCode = sc.nextLine();
            // 验证验证码
            if (!inputCode.equalsIgnoreCase(verificationCode)) {
                System.out.println("验证码不正确，请重新输入");
                attempts--;
                continue; // 重新输入验证码
            }
            // 验证用户名和密码
            boolean loginSuccess = false;
            for (Student s : students) {
                if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                    System.out.println("Login successful");
                    loginSuccess = true;
                    return true;
                }

                if (!loginSuccess) {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("密码错误，剩余尝试次数：" + attempts);
                    } else {
                        System.out.println("密码错误，登录失败");
                    }
                }

            }

        }
        return false;
    }

    public void resetPassword(ArrayList<Student> students) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        student.setUsername(sc.nextLine());

        // 先判断用户名是否存在
        boolean userExists = false;
        Student target = null;
        for (Student s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                userExists = true;
                target = s; // 找到这个用户
                break;
            }
        }

        if (!userExists) {
            System.out.println("Username not found");
            System.out.println("用户名未注册，请先注册");
            return;
        }

        // 验证手机号和身份证
        System.out.println("请输入手机号：");
        student.setPhonenumber(sc.nextLine());
        System.out.println("请输入身份证号：");
        student.setId(sc.nextLine());

        if (!target.getPhonenumber().equals(student.getPhonenumber()) ||
                !target.getId().equals(student.getId())) {
            System.out.println("Phone number or ID card not found");
            System.out.println("手机号或身份证号不正确");
            return;
        }

        // 重置密码
        System.out.println("请输入新密码：");
        String newPwd = sc.nextLine();
        System.out.println("请输入确认新密码：");
        String confirmPwd = sc.nextLine();

        if (!newPwd.equals(confirmPwd)) {
            System.out.println("New password and confirm password do not match");
            System.out.println("新密码和确认新密码不一致");
            return;
        }

        target.setPassword(newPwd);
        System.out.println("Reset password successful");
        System.out.println("密码重置成功");
    }


    }











