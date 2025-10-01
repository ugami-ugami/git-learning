package crud.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Приложение для управления списком элементов (CRUD) через консоль.
 * Поддерживает добавление, просмотр, обновление и удаление элементов.
 */
public class CrudConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = new ArrayList<>();
        boolean isRunning = true;

        System.out.println("📦 Добро пожаловать в CRUD-менеджер!");

        while (isRunning) {
            printMenu();
            String userChoice = scanner.nextLine().trim();

            switch (userChoice) {
                case "1" -> addItem(scanner, items);
                case "2" -> displayItems(items);
                case "3" -> updateItem(scanner, items);
                case "4" -> deleteItem(scanner, items);
                case "0" -> {
                    isRunning = false;
                    System.out.println("👋 Завершение программы.");
                }
                default -> System.out.println("⚠️ Неизвестная команда.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - ➕ Добавить элемент");
        System.out.println("2 - 📋 Показать все элементы");
        System.out.println("3 - ✏️ Обновить элемент");
        System.out.println("4 - 🗑️ Удалить элемент");
        System.out.println("0 - 🚪 Выход");
        System.out.print("Введите команду: ");
    }

    private static void addItem(Scanner scanner, List<String> items) {
        System.out.print("Введите элемент: ");
        String item = scanner.nextLine();
        items.add(item);
        System.out.println("✅ Элемент добавлен.");
    }

    private static void displayItems(List<String> items) {
        System.out.println("📋 Текущий список:");
        if (items.isEmpty()) {
            System.out.println(" (список пуст)");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println(" " + i + ": " + items.get(i));
            }
        }
    }

    private static void updateItem(Scanner scanner, List<String> items) {
        System.out.print("Введите индекс элемента для обновления: ");
        int index = parseIndex(scanner);

        if (isValidIndex(index, items.size())) {
            System.out.print("Новый текст: ");
            String updatedItem = scanner.nextLine();
            items.set(index, updatedItem);
            System.out.println("♻️ Элемент обновлён.");
        } else {
            System.out.println("❌ Недопустимый индекс.");
        }
    }

    private static void deleteItem(Scanner scanner, List<String> items) {
        System.out.print("Введите индекс для удаления: ");
        int index = parseIndex(scanner);

        if (isValidIndex(index, items.size())) {
            items.remove(index);
            System.out.println("🗑️ Элемент удалён.");
        } else {
            System.out.println("❌ Недопустимый индекс.");
        }
    }

    private static int parseIndex(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}