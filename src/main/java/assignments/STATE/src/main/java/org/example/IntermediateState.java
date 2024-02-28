package org.example;

public class IntermediateState extends CharacterState {

    public IntermediateState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Experience increased. Level increased.");
        character.increaseExperience(10);
        character.increaseLevel();
        checkProgress();
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Health increased. Level increased.");
        character.increaseHealth(5);
        character.increaseLevel();
    }

    @Override
    public void fight() {
        System.out.println("Cannot fight in Intermediate level. Get more experience to be able to fight");
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
        System.out.println("Press '1' to train, '2' to meditate or '4' to Exit the Game");
    }
}

