package org.example;

// Source: https://www.geeksforgeeks.org/quick-sort/
public class QuickSortStrategy implements SortingStrategy {

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivots
    private int partition(int[] arr, int low, int high){
        // Choosing the pivot
        int pivot =arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low -1);

        for (int j= low; j<=high -1; j++){
            // If current element is smaller than the pivot
            if (arr[j] < pivot){

                // Increment index of smaller element
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr [i+1];
        arr[i+1]= arr[high];
        arr[high] = temp;
        return i+1;
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    private void quickSort(int[] arr, int low, int high){
        if(low< high){
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi -1);
            quickSort(arr, pi +1, high);
        }
    }

    @Override
    public boolean processSorting(int[] numbers) {
        quickSort(numbers, 0, numbers.length-1);
        return true;
    }


}
