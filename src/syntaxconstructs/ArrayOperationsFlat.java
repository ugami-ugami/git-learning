package Syntax_and_constructions;

import java.util.Arrays;

public class ArrayOperationsFlat {
    public static void main(String[] args) {

        // Печать обычного массива
        int[] arr = {1, 2, 3};
        System.out.println("Простой массив: " + Arrays.toString(arr));

        // Сортировка массива
        int[] arr1 = {5, 6, 2, 25, 100};
        Arrays.sort(arr1);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr1));

        // Поиск индекса элемента через binarySearch (массив должен быть отсортирован)
        int[] arr2 = {2, 5, 235, 2, 12, 26, 66, 5, 6, 7, 9};
        Arrays.sort(arr2);
        int index = Arrays.binarySearch(arr2, 2);
        if (index < 0) {
            System.out.println("Вашего числа нет в массиве");
        } else {
            System.out.println("Индекс вашего числа = " + index);
        }

        // Сравнение массивов
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("Массивы равны: " + Arrays.equals(a, b));

        // Копирование массива с новой длиной
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, 5);
        System.out.println("Копия массива: " + Arrays.toString(copy));

        // Заполнение массива значением
        int[] arr3 = new int[5];
        Arrays.fill(arr3, 7);
        System.out.println("Массив, заполненный 7: " + Arrays.toString(arr3));
    }
}