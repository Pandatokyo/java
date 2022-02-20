public class HomeWork2 {
    public static void main(String[] args) {
        int a = 10;
        int b = -30;
        checkSum(a, b);
        checkDigit(a);
        checkDigit(b);
        printNumber(b, a);
        checkYear(1000);
        checkYear(100);
        checkYear(400);
    }
    public static void checkSum(int a, int b) {
        System.out.println(10 <= a + b && a + b >= 20);
    }
    public static void checkDigit(int a) {
        System.out.println(a < 0);
    }
    public static void printNumber(int a, int b) {
        for (int i = 0; i < a; i++) {
            System.out.println(b);
        }
    }
    public static void checkYear(int a) {
        System.out.println((a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0));
    }
}
