package org.example;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy ){
        this.sortingStrategy = sortingStrategy;
    }

    public void setStrategy (SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public boolean processSorting(int[] numbers){
        return sortingStrategy.processSorting(numbers);

    }

}
