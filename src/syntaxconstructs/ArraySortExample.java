package Syntax_and_constructions;

public class ArraySortExample {
    public static void main(String[] args) {
        // Исходный массив чисел
        int[] arr = {5, 3, 8, 1, 2, 4, 9, 7};

        // СОРТИРОВКА МАССИВА ПО ВОЗРАСТАНИЮ (СОРТИРОВКА ВЫБОРОМ)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // текущий минимальный индекс

            // ищем минимальный элемент в оставшейся части массива
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // если нашли меньший элемент — запоминаем его индекс
                }
            }

            // меняем местами текущий элемент и минимальный найденный
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // ВЫВОД ОТСОРТИРОВАННОГО МАССИВА
        System.out.print("Отсортированный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}