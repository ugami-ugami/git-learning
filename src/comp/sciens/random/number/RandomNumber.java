package comp.sciens.random.number;

public class RandomNumber {
    public static void main (String[] args) {
       int a = Integer.parseInt(args[0]);
       int b = Integer.parseInt(args[1]);

       int min = Math.min(a, b);
       int max = Math.max(a, b);

       int random = min + (int) (Math.random() * (max - min + 1));

       System.out.println(random);
    }
}
