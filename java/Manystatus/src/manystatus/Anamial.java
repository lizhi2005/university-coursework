package manystatus;

public class Anamial {

private int age;
private String color;

    public Anamial(int age, String color) {
        this.age = age;
        this.color = color;
    }
    public Anamial(){}

    public void setAge(int age) {
        this.age = age;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getAge() {
        return age;
    }
    public  String getColor() {
        return color;
    }

    public void eat(String sth) {
        System.out.println("I like eating"+sth);
    }

}
