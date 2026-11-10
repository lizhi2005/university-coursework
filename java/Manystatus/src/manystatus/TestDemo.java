package manystatus;

public class TestDemo {

    static void main() {
        Person p=new Person("老褚",30);
        Person p1=new Person("老李",25);
        Dog d=new Dog(2,"黑色");
        Cat c=new Cat(3,"灰色");
        p.keepPet(d,"骨头");
        p1.keepPet(c,"鱼");
        
    }




}
