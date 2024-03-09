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
        // QuickSort Timing for Small Array
        long startTime = System.nanoTime();
        context.processSorting(smallArray);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;
        System.out.println("QuickSort took of a small array: " + duration1 + " nanoseconds or approximately: " + (duration1 / 1_000_000) + " milliseconds");

        // QuickSort Timing for Large Array
        long startTime2 = System.nanoTime();
        context.processSorting(largeArray);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("QuickSort took of a large array: " + duration2 + " nanoseconds or approximately: " + (duration2 / 1_000_000) + " milliseconds");
        // Switch to HeapSort and reset arrays
        context.setStrategy(new HeapSortStrategy());
        smallArray = generateRandomArray(30);
        largeArray = generateRandomArray(100000);

        // HeapSort Timing for Small Array
        long startTime3 = System.nanoTime();
        context.processSorting(smallArray);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        System.out.println("HeapSort took for a small array: " + duration3 + " nanoseconds or approximately: " +(endTime3 - startTime3) / 1_000_000 + " milliseconds");

        // HeapSort Timing for Large Array
        long startTime4 = System.nanoTime();
        context.processSorting(largeArray);
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;
        System.out.println("HeapSort took for a large array: "+ duration4 + " nanoseconds or approximately: " + (endTime4 - startTime4) / 1_000_000 + " milliseconds");

        // Switch to InsertionSort and reset arrays
        context.setStrategy(new InsertionSortStrategy());

        smallArray = generateRandomArray(30);
        largeArray = generateRandomArray(100000);
        long startTime5 = System.nanoTime();
        context.processSorting(smallArray);
        long endTime5 = System.nanoTime();
        long duration5 = endTime5 - startTime5;
        System.out.println("InsertionSort took for a small array: "+ duration5 + " nanoseconds or approximately: " + (endTime5 - startTime5) / 1_000_000 + " milliseconds");


         long startTime6 = System.nanoTime();
         context.processSorting(largeArray);
         long endTime6 = System.nanoTime();
         long duration6 = endTime6 - startTime6;
         System.out.println("InsertionSort took for a large array: " + duration6 + " nanoseconds or approximately: "+ (endTime6 - startTime6) / 1_000_000 + " milliseconds");

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
