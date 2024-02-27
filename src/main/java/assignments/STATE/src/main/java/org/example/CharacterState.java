package org.example;

public abstract class CharacterState {
    protected GameCharacter character;

    public CharacterState(GameCharacter character) {
        this.character = character;
    }

    public abstract void train();
    public abstract void meditate();
    public abstract void fight();

    public abstract void displayStatusAndActions();


}

