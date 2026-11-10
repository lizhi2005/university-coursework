package manystatus;

public class Person {
    private String name;
    private int age;


    public Person(){}
    public Person(String n,int a)
    {
        this.name=n;
        this.age=a;
    }

    public void setName(String name) {
            this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void keepPet(Anamial a,String sth){
        if(a instanceof  Dog d)
        {
            System.out.printf("年龄为%d的%s养了一只%s的狗",getAge(),getName(),d.getColor());
            System.out.println();
            d.eat(sth);

        }else if(a instanceof Cat c){
            System.out.printf("年龄为%d的%s养了一只%s的猫",getAge(),getName(),c.getColor());
            System.out.println();
            c.eat(sth);
        }
        else{
            System.out.println("没有这个类型，无法转换");
        }
    }


}
