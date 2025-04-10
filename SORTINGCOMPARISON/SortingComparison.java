/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SORTINGCOMPARISON;

/**
 *
 * @author CHI KIEN
 */
public class SortingComparison {
  // Tạo mảng số ngẫu nhiên
    public static int[] generateRandomArray(int size) {
        Random rand = new Random(int size);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // giá trị ngẫu nhiên từ 0 đến 9999
        }
        return array;
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int size = 10000; // số phần tử của mảng
        int[] array1 = generateRandomArray(size);
        int[] array2 = Arrays.copyOf(array1, array1.length);

        // Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(array1);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) / 1e6 + " ms");

        // Quick Sort
        long startQuick = System.nanoTime();
        quickSort(array2, 0, array2.length - 1);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) / 1e6 + " ms");
    }
}
