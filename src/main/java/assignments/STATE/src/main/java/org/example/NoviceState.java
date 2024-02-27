package org.example;

public class NoviceState extends CharacterState{

    public NoviceState(GameCharacter character){
        super(character);
    }
    @Override
    public void train() {
        System.out.println("Training as a Novice.");
        character.increaseExperience(10); // Assuming 10 points are gained per training session

        // Assuming the threshold to move from Novice to Intermediate is 50 points
        if (character.getExperiencePoints() >= 50) {
            System.out.println("Congratulations! You've advanced to the Intermediate level.");
            character.changeState(new IntermediateState(character));
        }

    }

    @Override
    public void meditate() {
        // Not available at this level
        System.out.println("Meditation is not available at the NoviceState level.");
    }

    @Override
    public void fight() {
        // Not available at this level
        System.out.println("Fighting is not available at the NoviceState level.");
    }

    @Override
    public void displayStatusAndActions() {
        System.out.println("Available Actions:");
        System.out.println("As a novice you can train. Upgrade to next level to be able to fight or meditate");
        // Specific instruction for NoviceState
        System.out.println("Press '1' to train.");
        System.out.println("2. Exit Game");
    }
}
