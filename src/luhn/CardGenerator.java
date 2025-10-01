package luhn;

import java.util.Random;

public class CardGenerator {

    public static void main(String[] args) {
        String binMask = "531344"; // начальная маска (BIN)
        int totalLength = 16; // длина карты
        int quantity = 5000; // сколько карт сгенерировать

        for (int i = 0; i < quantity; i++) {
            String cardNumber = generateCardNumber(binMask, totalLength);
            System.out.println(cardNumber);
        }
    }

    public static String generateCardNumber(String bin, int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(bin);

        // Генерируем случайные цифры до предпоследней
        while (builder.length() < length - 1) {
            builder.append(random.nextInt(10));
        }

        // Вычисляем контрольную цифру по Луну
        int checkDigit = getLuhnCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();
    }

    public static int getLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = true; // начинаем удваивать с последней цифры справа

        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (10 - (sum % 10)) % 10;
    }
}