package manystatus;

public class Cat extends Anamial{

    public Cat(int age, String color) {
        super(age, color);
    }
    public Cat(){}
    @Override
    public void eat(String sth) {
        System.out.printf("%d岁的%s的猫眯着眼睛侧着头吃%s",getAge(),getColor(),sth);
    }
public void catchMouse(){
    System.out.println("抓老鼠");
}

}
