package comp.sciens.coin.flip;

public class CoinFlip {
    public static void main (String[] args) {
        if (Math.random() > 0.5) {
            System.out.println("Head");
        } else {
            System.out.println("Tails");
        }
    }
}
