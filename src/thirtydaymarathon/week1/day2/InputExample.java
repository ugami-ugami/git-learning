
// Переменные, типы данных, Scanner – int, String, ввод – Парсинг строки

package thirtydaymarathon.week1.day2;

import java.util.Scanner;

public class InputExample {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: "); // System.out.print - печатает без перехода на новую строку
        String name = scanner.nextLine(); // Считывает всю строку, возвращает String

        System.out.print("Введите ваш возраст: ");
        int age = Integer.parseInt(scanner.nextLine()); // Integer.parseInt - Преобразует String → int. Можно получить NumberFormatException

        System.out.println("Привет " + name + "! Тебе " + age + " лет."); // Печатает с переходом на новую строку
    }
}
// ВАЖНО: nextInt() считывает только число, но оставляет \n в потоке.
// Если сразу после него вызвать nextLine(), она вернёт пустую строку.
// Решение: либо читай всё через nextLine() и парси вручную,
// либо добавь лишний nextLine() после nextInt(), чтобы "съесть" \n.
// nextInt() → nextInt() работает нормально, потому что они оба пропускают \n.