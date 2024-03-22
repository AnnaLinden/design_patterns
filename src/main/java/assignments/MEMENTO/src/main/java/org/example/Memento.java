package org.example;

import java.time.LocalDateTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getDescription() {
        // Generate a description based on the state, like a timestamp
        return "State at " + LocalDateTime.now().toString();
    }
}
