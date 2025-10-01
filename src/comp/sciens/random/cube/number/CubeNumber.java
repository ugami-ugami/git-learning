package comp.sciens.random.cube.number;

public class CubeNumber {
    public static void main (String[] args) {

        int random1 = 1 + (int) (Math.random() * 6);
        int random2 = 1 + (int) (Math.random() * 6);
        int result = random1 + random2;

        System.out.println(result);
    }
}
