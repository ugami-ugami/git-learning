package Syntax_and_constructions;

import java.util.Arrays;

public class ArrayOperationsStructured {
    public static void main(String[] args) {
        ArrayTools.printSimple();
        ArrayTools.sortArray();
        ArrayTools.binarySearch();
        ArrayTools.compareArrays();
        ArrayTools.copyArray();
        ArrayTools.fillArray();
    }
}

class ArrayTools {

    // Печать массива
    public static void printSimple() {
        int[] arr = {1, 2, 3};
        System.out.println("Простой массив: " + Arrays.toString(arr));
    }

    // Сортировка
    public static void sortArray() {
        int[] arr = {5, 6, 2, 25, 100};
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    // Поиск по значению в массиве
    public static void binarySearch() {
        int[] arr = {2, 5, 235, 2, 12, 26, 66, 5, 6, 7, 9};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 2);
        if (index < 0) {
            System.out.println("Вашего числа нет в массиве");
        } else {
            System.out.println("Индекс вашего числа = " + index);
        }
    }

    // Сравнение массивов
    public static void compareArrays() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("Массивы равны: " + Arrays.equals(a, b));
    }

    // Копирование массива
    public static void copyArray() {
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, 5);
        System.out.println("Копия массива: " + Arrays.toString(copy));
    }

    // Заполнение массива
    public static void fillArray() {
        int[] arr = new int[5];
        Arrays.fill(arr, 7);
        System.out.println("Массив, заполненный 7: " + Arrays.toString(arr));
    }
}