package org.example;

public class MasterState extends CharacterState {

    public MasterState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training is not required at Master level.");
    }

    @Override
    public void meditate() {
        System.out.println("Meditating for enlightenment.");
    }

    @Override
    public void fight() {
        System.out.println("Finding worthy opponents is rare at Master level.");
    }

    @Override
    public void displayStatusAndActions() {
        System.out.println("Congratulations! You've reached the Master level and completed your journey.");
        System.out.println("There are no further actions available as you have mastered all challenges.");
        System.out.println("Press '4' to exit the game and celebrate your mastery.");
    }

}
