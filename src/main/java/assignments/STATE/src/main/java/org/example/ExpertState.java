package org.example;

public class ExpertState extends CharacterState {

    public ExpertState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Experience increased.");
        character.increaseExperience(20);
        checkProgress();
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Health increased.");
        character.increaseHealth(10);
    }

    @Override
    public void fight() {
        System.out.println("Fighting... Experience increased, health decreased.");
        character.increaseExperience(30);
        character.decreaseHealth(15);
        checkProgress();
    }

    private void checkProgress() {
        if (character.getExperiencePoints() >= 200) {
            character.changeState(new MasterState(character));
            System.out.println("Advanced to Master level!");
        }
    }

    @Override
    public void displayStatusAndActions() {
        System.out.println("Available Actions:");
        System.out.println("1. Train - Gain experience points.");
        System.out.println("2. Meditate - Recover health points.");
        System.out.println("3. Fight - Increases experience but reduces health.");
        System.out.println("Press '1' to train, '2' to meditate, '3' to fight.");
        System.out.println("4. Exit Game");
    }

}

