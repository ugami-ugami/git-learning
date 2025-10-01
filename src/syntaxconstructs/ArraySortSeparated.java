package Syntax_and_constructions;

public class ArraySortSeparated {
    public static void main(String[] args) {
        // Исходный массив
        int[] arr = {5, 3, 8, 1, 2, 4, 9, 7};

        // Вызов сортировки через вспомогательный класс
        ArrayUtils.sortAscending(arr);

        // Вывод результата
        System.out.print("Отсортированный массив: ");
        ArrayUtils.printArray(arr);
    }
}

// Класс с методами сортировки и печати
class ArrayUtils {

    // Метод сортировки по возрастанию (selection sort)
    public static void sortAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Обмен значений
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Метод для печати массива
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); // Перевод строки после вывода
    }
}