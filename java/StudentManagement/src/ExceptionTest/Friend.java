package ExceptionTest;

public class Friend {

    String name;
    int age;


    public Friend() {
    }

    public Friend(String name, int age) {
        if(name.length()<3||name.length()>10||age<18||age>40)
        {
            System.out.println("年龄或者名字出错了");
            throw new RuntimeException();
        }
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Friend{name = " + name + ", age = " + age + "}";
    }
}
