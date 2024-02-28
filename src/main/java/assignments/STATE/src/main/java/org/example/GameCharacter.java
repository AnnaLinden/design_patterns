package org.example;

public class GameCharacter {
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.state = new NoviceState(this);
    }

    public void changeState(CharacterState newState){
        this.state = newState;
    }

    // Actions
    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }
    // Experience and Health Management
    public void increaseExperience(int points) {
        this.experiencePoints += points;
        System.out.println("Current Experience: " + this.experiencePoints);
    }
    public void increaseLevel() {
        this.level ++;
    }

    public void increaseHealth(int points) {
        this.healthPoints += points;
        System.out.println("Current Health: " + this.healthPoints);
    }

    public void decreaseHealth(int points) {
        this.healthPoints -= points;
        if (this.healthPoints < 0) this.healthPoints = 0;
        System.out.println("Current Health: " + this.healthPoints);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public CharacterState getState() {
        return state;
    }
    public void displayStatusAndActions() {
        System.out.println("-------------------------");
        System.out.println("\nCharacter Status:");
        System.out.println("Name: " + this.name);
        System.out.println("Current State: " + this.state.getClass().getSimpleName().toUpperCase());
        System.out.println("Current level: " + this.level);
        System.out.println("Experience Points: " + this.experiencePoints);
        System.out.println("Health Points: " + this.healthPoints);

        this.state.displayStatusAndActions(); // Delegate to current state
        System.out.println("-------------------------");
    }
}
