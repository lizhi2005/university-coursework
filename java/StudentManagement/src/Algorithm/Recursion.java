package Algorithm;

public class Recursion {
    static void main() {


        int result =  sum(100);
        System.out.println(result);
        int result2 = factorial(5);
        System.out.println(result2);

    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
    }






