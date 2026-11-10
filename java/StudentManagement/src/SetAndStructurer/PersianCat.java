package SetAndStructurer;

public class PersianCat extends Cat{
    public PersianCat(){}
    public PersianCat(String name,int age)
    {
        super(name,age);
    }
    @Override
    public  void eat() {
        System.out.println("一直叫作"+getName()+"的，"+getAge()+"岁的波斯猫正在吃小饼干");
    }
}
