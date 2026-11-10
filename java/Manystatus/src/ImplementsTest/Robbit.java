package ImplementsTest;

public class Robbit extends Animal{
    public Robbit(){}
    public Robbit(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("吃胡萝卜");
    }



}
