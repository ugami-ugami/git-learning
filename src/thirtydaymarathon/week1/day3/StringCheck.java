package thirtydaymarathon.week1.day3;

import java.util.Scanner;

public class StringCheck {

    // Метод main — точка входа в программу, JVM начинает выполнение отсюда.
    // public — доступен JVM извне, static — вызывается без создания объекта, void — ничего не возвращает.
    public static void main(String[] args) {
        // Инициализация сканера — System.in это стандартный поток ввода с клавиатуры.
        Scanner scanner = new Scanner(System.in);

        // Вывод текста в консоль без переноса строки. Курсор останется на этой же строке.
        System.out.print("Введите команду (start/stop/status): ");

        // Считываем строку, сразу нормализуем:
        // .trim() — убирает пробелы по краям, .toLowerCase() — делаем ввод нечувствительным к регистру.
        String command = scanner.nextLine().trim().toLowerCase();

        // Обработка команды с помощью if-else логики.
        System.out.println("Проверка через if:");
        // Вызываем статический метод run() из класса IfLogic, передаём строку command как аргумент.
        IfLogic.run(command);

        // Обработка той же команды, но через конструкцию switch-case.
        System.out.println("Проверка через switch:");
        SwitchLogic.run(command);
    }
}

// Вспомогательный класс для обработки команд через if-else.
// Не public, так как в одном .java-файле может быть только один public-класс.
class IfLogic {

    // Статический метод, который проверяет строку и выполняет нужное действие.
    public static void run(String command) {
        // Метод equals() используется для сравнения строк по содержимому, а не по ссылке (в отличие от ==).
        if (command.equals("start")) {
            System.out.println("Запуск процесса...");
        } else if (command.equals("stop")) {
            System.out.println("Остановка процесса...");
        } else if (command.equals("status")) {
            System.out.println("Процесс в ожидании.");
        } else {
            System.out.println("Неизвестная команда");
        }
    }
}

// Ещё один вспомогательный класс — обрабатывает команды через switch-case.
// Подходит, когда есть фиксированный набор значений (как здесь).
class SwitchLogic {

    public static void run(String command) {
        // В каждом case сравнивается значение переменной command с константами.
        // break обязателен, чтобы не пошёл "провал" в следующие блоки.
        switch (command) {
            case "start":
                System.out.println("Запуск процесса...");
                break;
            case "stop":
                System.out.println("Остановка процесса...");
                break;
            case "status":
                System.out.println("Процесс в ожидании.");
                break;
            default:
                // default выполняется, если ни один case не подошёл.
                System.out.println("Неизвестная команда");
        }
    }
}