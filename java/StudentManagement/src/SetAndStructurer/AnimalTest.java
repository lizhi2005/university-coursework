package SetAndStructurer;

import java.util.ArrayList;

public class AnimalTest {

    static void main() {

        ArrayList<Animal>animals=new ArrayList<>();

        keepAnimal(animals);
        System.out.println("-----------------");

        ArrayList<Dog>dogs=new ArrayList<>();

        keepDog(dogs);
        System.out.println("-----------------");


        ArrayList<Cat>cats=new ArrayList<>();
        keepCat(cats);
        System.out.println("-----------------");

        ArrayList<PersianCat>list1=new ArrayList<>();
        list1.add(new PersianCat("鸳鸯眼",1));
        ArrayList<LiHuaCat>list2=new ArrayList<>();
        list2.add(new LiHuaCat("丧彪",1));
        ArrayList<Husky>list3=new ArrayList<>();
        list3.add(new Husky("二哈",1));
        ArrayList<Teddy>list4=new ArrayList<>();
        list4.add(new Teddy("泰迪",1));
        keepDog(list3);
        keepDog(list4);
        keepCat(list1);
        keepCat(list2);
        System.out.println("-----------------");
    }
    public static void keepAnimal(ArrayList<? extends Animal> pets)
    {
        for(Animal pet:pets)
        {
            pet.eat();
        }
    }
    public static void keepDog(ArrayList<? extends Dog> pets)
    {

        for(Dog pet:pets)
        {
            pet.eat();
        }


    }
    public static void keepCat(ArrayList<? extends Cat> pets)
    {

        for(Cat pet:pets)
        {
            pet.eat();
        }

    }
}
