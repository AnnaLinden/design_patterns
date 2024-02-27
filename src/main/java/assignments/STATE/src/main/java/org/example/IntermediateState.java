package org.example;

public class IntermediateState extends CharacterState {

    public IntermediateState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Experience increased.");
        character.increaseExperience(10);
        checkProgress();
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Health increased.");
        character.increaseHealth(5);
    }

    @Override
    public void fight() {
        System.out.println("Cannot fight in Intermediate level.");
    }

    private void checkProgress() {
        if (character.getExperiencePoints() >= 100) {
            character.changeState(new ExpertState(character));
            System.out.println("Advanced to Expert level!");
        }
    }

    @Override
    public void displayStatusAndActions() {
        System.out.println("Available Actions:");
        System.out.println("1. Train - Gain experience points.");
        System.out.println("2. Meditate - Recover health points.");
        System.out.println("Press '1' to train, '2' to meditate.");
        System.out.println("4. Exit Game");
    }
}

