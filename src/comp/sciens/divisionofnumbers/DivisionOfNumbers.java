package comp.sciens.divisionofnumbers;

public class DivisionOfNumbers {
    public static void main (String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        boolean result = (b % a == 0) || (a % b == 0);
        System.out.println(result);
    }
}
