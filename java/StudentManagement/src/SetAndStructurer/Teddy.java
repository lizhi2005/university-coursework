package SetAndStructurer;

public class Teddy extends Dog{
    public Teddy(){}
    public Teddy(String name,int age)
    {
        super(name,age);
    }
    @Override
    public  void eat() {
        System.out.println("一直叫作"+getName()+"的，"+getAge()+"岁的泰迪正在吃骨头，边吃边蹭");
    }
}
