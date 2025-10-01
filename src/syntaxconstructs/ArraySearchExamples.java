package thirtydaymarathon.week1.day4;

// Главный класс — запускает оба сценария поиска
public class ArraySearchExamples {
    public static void main(String[] args) {

        // Поиск первого вхождения символа 'a'
        System.out.println("=== Поиск первого вхождения ===");
        FirstMatchFinder.findFirstMatch(new char[] {'a', 'b', 'c', 'd', 'e', 'a', 'a'}, 'a');

        System.out.println();

        // Поиск последнего вхождения символа 'e'
        System.out.println("=== Поиск последнего вхождения ===");
        LastMatchFinder.findLastMatch(new char[] {'a', 'e', 'b', 'e', 'c', 'e', 'd', 'e', 'f', 'e'}, 'e');
    }
}

// Поиск ПЕРВОГО вхождения target в массиве
class FirstMatchFinder {
    public static void findFirstMatch(char[] arr, char target) {
        boolean isFound = false; // флаг — найдено ли совпадение

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                isFound = true;
                System.out.println("Элемент '" + target + "' впервые найден на индексе " + i);
                break; // после первого совпадения останавливаем цикл
            }
        }

        if (!isFound) {
            System.out.println("Элемент '" + target + "' не найден в массиве.");
        }
    }
}

// Поиск ПОСЛЕДНЕГО вхождения target в массиве (поиск с конца)
class LastMatchFinder {
    public static void findLastMatch(char[] arr, char target) {
        boolean isFound = false; // флаг — найдено ли совпадение

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                System.out.println("Элемент '" + target + "' с конца впервые найден на индексе " + i);
                isFound = true;
                break; // находим первое вхождение с конца — выходим
            }
        }

        if (!isFound) {
            System.out.println("Элемент '" + target + "' не найден в массиве.");
        }
    }
}