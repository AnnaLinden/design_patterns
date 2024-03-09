package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30); // Implement this method to generate a random array
        int[] largeArray = generateRandomArray(100000); // Adjust size as needed

        SortingContext context = new SortingContext(new QuickSortStrategy());
        // Sort using QuickSort
        long startTime = System.nanoTime();
        context.processSorting(smallArray);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("QuickSort took: " + duration + " nanoseconds");
        System.out.println("Which is approximately: " + (duration / 1_000_000) + " milliseconds");
        // Switch to HeapSort
        context.setStrategy(new HeapSortStrategy());
        context.processSorting(largeArray);
        // Switch to InsertionSort
        context.setStrategy(new InsertionSortStrategy());
        context.processSorting(smallArray);
        // Add your timing code around these calls to measure performance
    }

    // Utility method to generate an array of random integers
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}
