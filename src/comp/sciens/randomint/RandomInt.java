package comp.sciens.randomint;

public class RandomInt {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        double r = Math.random();
        System.out.println(r);

        int value = (int) (r * n);
        System.out.println(value);

        System.out.println("123" + 123);

        if (0.1 + 0.1 == 0.2) {
            System.out.println("dada");
        }

        if (0.1 + 0.1 + 0.1 == 0.3) {
            System.out.println("dada");
        }

        double nan = Double.NaN;
        double posInf = Double.POSITIVE_INFINITY;
        double negInf = Double.NEGATIVE_INFINITY;
    }
}
