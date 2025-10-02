package array.sort.again;

public class ArraySort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 7, 1, 2, 3, 5, 4, 10, 5, 2, 5, 1, 7, 56, 19, 16, -1, -6, -54, 0};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}