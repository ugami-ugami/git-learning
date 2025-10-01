package syntaxconstructs;

import java.util.ArrayList;
import java.util.List;

// Главный класс с точкой входа
public class FactorialExamples {
    public static void main(String[] args) {
        int numberFor = 5;
        int numberWhile = 4;

        // Вызов метода из класса с реализацией через for
        System.out.println("=== Факториал через for ===");
        FactorialFor.printFactorial(numberFor);

        System.out.println();

        // Вызов метода из класса с реализацией через while
        System.out.println("=== Факториал через while ===");
        FactorialWhile.printFactorial(numberWhile);
    }
}

// Вспомогательный класс: реализация факториала через for
class FactorialFor {
    public static void printFactorial(int number) {
        int result = 1;
        int thirdStepValue = 0;
        List<String> output = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            result *= i;

            if (i == 3) {
                thirdStepValue = result;
            }

            output.add(i + " число = " + result);
        }

        System.out.println("Третье число = " + thirdStepValue);
        System.out.println("Факториал " + number + " = " + result);
        for (String line : output) {
            System.out.println(line);
        }
    }
}

// Вспомогательный класс: реализация факториала через while
class FactorialWhile {
    public static void printFactorial(int number) {
        int result = 1;
        int i = number;

        while (i > 0) {
            result *= i;
            i--;
        }

        System.out.println("Факториал " + number + " = " + result);
    }
}