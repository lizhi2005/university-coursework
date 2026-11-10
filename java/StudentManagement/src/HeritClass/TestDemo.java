package HeritClass;

public class TestDemo {
    public static void main(String[] args) {

        Cooker cooker = new Cooker("1001","张三",5000);
        cooker.work();
        cooker.eat();
        Manager manager = new Manager("1002","李四",8000,1000);
        manager.work();
        manager.eat();
    }









}
