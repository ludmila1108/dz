package lessen2;

public class metod {

    public static void main(String[] args) {
        printNumber(331,3 );
        integer(5);
        doFive(-6);
        printLines(4);

    }


    //задание 1
    public static boolean printNumber(int a, int b ) {
        return 10 <= a + b && a + b <= 20;

    }

    //задание2
    public static void integer(int a) {
        if (a >= 0)
            System.out.println("Число " + a + " положительное");
        else
            System.out.println("Число " + a + " отрицательное");
    }
    // задание 3

    public static boolean doFive(int a) {
        return a < 0;
    }

    // Задание 4
    private static void printLines(int j) {
        for(int i = 0; i<j; i++)

            System.out.print("*");
    }

}

