package Studentutil;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎进入学生管理系统");
        ArrayList<Student> students=new ArrayList<>();
        // 初始化学生数据
        Student stu1 = new Student();
        stu1.setUsername("shentang");
        stu1.setPassword("St123456");
        stu1.setId("110101199901011234");
        stu1.setPhonenumber("13800138001");

        Student stu2 = new Student();
        stu2.setUsername("qishan");
        stu2.setPassword("Qs123456");
        stu2.setId("110101199902022345");
        stu2.setPhonenumber("13800138002");

        Student stu3 = new Student();
        stu3.setUsername("gongxichou");
        stu3.setPassword("Gxc123456");
        stu3.setId("110101199903033456");
        stu3.setPhonenumber("13800138003");

        Student stu4 = new Student();
        stu4.setUsername("chuwuhui");
        stu4.setPassword("Cwh123456");
        stu4.setId("110101199904044567");
        stu4.setPhonenumber("13800138004");

        Student stu5 = new Student();
        stu5.setUsername("linfeng");
        stu5.setPassword("Lf123456");
        stu5.setId("110101199905055678");
        stu5.setPhonenumber("13800138005");

        // 将学生添加到列表
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        System.out.println("学生数据初始化完成！");
        AuthService authService = new AuthService();
        boolean isLoggedIn = false; // 登录状态

        while (true) {
            System.out.println("\n====== 主菜单 ======");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 忘记密码");
            System.out.println("4. 进入学生管理系统（需登录）");
            System.out.println("5. 退出");
            System.out.print("请选择：");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    boolean success = authService.login(students);
                    if (success) {
                        isLoggedIn = true;
                        System.out.println("✅ 登录成功！正在进入学生管理系统...\n");
                        // 登录成功直接自动进入，不返回菜单
                        studentManagerMenu(students, sc);
                    } else {
                        isLoggedIn = false;
                    }
                    break;
                case 2:
                    authService.register(students);
                    break;
                case 3:
                    authService.resetPassword(students);
                    break;
                case 4:
                    if (isLoggedIn) {
                        System.out.println("====== 欢迎进入学生管理系统 ======");
                        studentManagerMenu(students, sc);
                    } else {
                        System.out.println("请先登录！");
                    }
                    break;
                case 5:
                    System.out.println("谢谢使用！");
                    return;
                default:
                    System.out.println("输入无效！");
            }
        }
    }

    // 学生管理系统菜单（增删改查）
    private static void studentManagerMenu(ArrayList<Student> list, Scanner sc) {
        while (true) {
            System.out.println("\n1. 查看所有学生");
            System.out.println("2. 添加学生");
            System.out.println("3. 修改学生密码");
            System.out.println("4. 删除学生");
            System.out.println("5. 返回主菜单");
            System.out.print("请选择操作：");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("====== 学生列表 ======");
                    for (Student s : list) {
                        System.out.println("用户名：" + s.getUsername()
                                + " 手机号：" + s.getPhonenumber()
                                + " 身份证：" + s.getId());
                    }
                    break;
                case 2:
                    Student newStu = new Student();
                    System.out.print("输入用户名：");
                    newStu.setUsername(sc.nextLine());
                    System.out.print("输入密码：");
                    newStu.setPassword(sc.nextLine());
                    System.out.print("输入身份证：");
                    newStu.setId(sc.nextLine());
                    System.out.print("输入手机号：");
                    newStu.setPhonenumber(sc.nextLine());
                    list.add(newStu);
                    System.out.println("添加成功！");
                    break;
                case 3:
                    System.out.print("输入要修改的用户名：");
                    String name = sc.nextLine();
                    for (Student s : list) {
                        if (s.getUsername().equals(name)) {
                            System.out.print("输入新密码：");
                            s.setPassword(sc.nextLine());
                            System.out.println("修改成功！");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("输入要删除的用户名：");
                    String delName = sc.nextLine();
                    Student delStu = null;
                    for (Student s : list) {
                        if (s.getUsername().equals(delName)) {
                            delStu = s;
                            break;
                        }
                    }
                    if (delStu != null) {
                        list.remove(delStu);
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("用户不存在！");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入无效！");
            }
        }
    }
}

