package manystatus;

public class Dog extends Anamial{
    public Dog(int age, String color) {
        super(age, color);
    }
    public Dog(){}
    @Override
    public void eat(String sth) {
        System.out.printf("%d岁的%s的狗两只前腿死死的抱住%s猛吃",getAge(),getColor(),sth);
        System.out.println();
        System.out.println("小狗爱吃肉");
        System.out.println();
    }
    public void lookHome(){
        System.out.println("看家");
    }
}
