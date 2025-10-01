package comp.sciens.trianglecheck;

public class TriangleCheck {
    public static void main (String[] args) {

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        boolean result = (!(b + c <= a) || (c + a <= b) || (a + b <= c));

        System.out.println(result);
    }
}
