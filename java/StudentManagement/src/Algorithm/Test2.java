package Algorithm;

public class Test2 {
    static void main() {
        System.out.println(robbit(12));


    }

    public static int robbit(int month) {

        if(month==1){
            return 1;
        }
        if(month==2){
            return 1;}
        if(month==3){
            return 2;
        }
        return robbit(month-1)+robbit(month-2);
    }
}
