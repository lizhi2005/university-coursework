package Algorithm;

public class MonkeyPeach {
    static void main() {
        System.out.println(monkeyPeach(1));

    }

    public static int monkeyPeach(int day) {
        if (day==10){
            return 1;
        }
        if (day==9){
            return 4;
        }
        if (day==8){
            return 10;
        }
        return (monkeyPeach(day + 1) + 1) * 2;
    }
}
