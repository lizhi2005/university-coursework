package SetAndStructurer;

public class LiHuaCat extends Cat{
    public LiHuaCat(){}
    public LiHuaCat(String name,int age)
    {
        super(name,age);
    }
    @Override
    public  void eat() {
        System.out.println("一直叫作"+getName()+"的，"+getAge()+"岁的狸花猫正在吃鱼");
    }

}
