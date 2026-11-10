package com.tang.demo1;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students=new Student[3];
        Student[] newarr = null;
        Student student1=new Student(1,"张三",18);
        Student student2=new Student(2,"李四",19);
        Student student3=new Student(3,"王五",19);
        students[0]=student1;
        students[1]=student2;
        students[2]=student3;
        Student student4=new Student(4,"王六",19);
        boolean flag=unique(students,4);
        if(flag){
            System.out.println("学号已存在");
        }
        else {
            int count = isFull(students);
            if (count == students.length) {
                System.out.println("数组已满");
                newarr = addStudent(students);
                newarr[count] = student4;
                Printstudents(newarr);

            } else {
                students[count] = student4;
                System.out.println("添加成功");
                Printstudents(students);
            }
        }
        if(newarr!=null){
            int index=indexStudent(newarr,4);
            if(index>0){
                System.out.println("学生存在");
                newarr[index]=null;
                Printstudents(newarr);
            }
            else {
                System.out.println("学生不存在,删除失败");


            }
        }
        else {    int index=indexStudent(students,4);
            if(index>0){
                System.out.println("学生存在");
                students[index]=null;
                Printstudents(students);
            }
            else {
                System.out.println("学生不存在,删除失败");

            }}


        int index1=indexStudent(students,2);
        if (index1>0){
           students[index1].setAge(students[index1].getAge()+1);
           System.out.println("年龄增加成功");
           Printstudents(students);
        }
        else {
            System.out.println("学生不存在");
        }



        }
public static Student[]  addStudent(Student []students){
        Student[] newArr=new Student[students.length+1];
        for (int i = 0; i < students.length; i++) {
            newArr[i] = students[i];
        }
            return newArr;

}

public static int indexStudent(Student[]arr,int id){
    for (int i = 0; i < arr.length; i++) {
        Student stu = arr[i];
        if (stu != null) {
            if (stu.getId() == id) {
                return i;
            }
        }

    }
    return -1;
}
 public static void Printstudents(Student []students) {
     for (int i = 0; i < students.length; i++) {
         Student stu = students[i];
         if (stu != null) {
             System.out.println("学号：" + students[i].getId() + "姓名：" +
                     students[i].getName() + "年龄：" + students[i].getAge());
         }
     }
 }


public static int  isFull(Student []students){
        int count=0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                count++;
                                     }
                                                 }
        return count;
}



public static boolean unique(Student []students,int id) {
        // 遍历学生数组
        for (int i = 0; i < students.length; i++) {
            // 只检查不为空的索引位置
            Student stu = students[i];
            int sid = stu.getId();
            if (sid == id) {
                return true;
            }

        }
        return false;
        }



    }







