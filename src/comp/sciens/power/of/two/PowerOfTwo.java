package comp.sciens.power.of.two;

public class PowerOfTwo {
    public static void main (String[] args) {
         int n = Integer.parseInt(args[0]);
         int power = 1;
         int count = 1;
         while (power <= n/2) {
             power *= 2;
             System.out.println(count + " " + power);
             count++;
         }
    }
}
