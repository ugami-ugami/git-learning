package two.function.practice;

public class TwoFileForAmend {

    public static boolean tOf (int a, int b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }

    public static void sayHello (String name) {
        System.out.println(name + " го ебанем по баночке");
    }

    public static void main (String[] args) {

       System.out.println(tOf(4, 3));

       sayHello("Андрюха, хуй те в ухо,");
    }
}
