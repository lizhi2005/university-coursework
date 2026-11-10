package HeritClass;

public class Manager extends Person {
    private double bonus;

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    @Override
    public void work(){
        System.out.println("管理其他人");
    }

}
