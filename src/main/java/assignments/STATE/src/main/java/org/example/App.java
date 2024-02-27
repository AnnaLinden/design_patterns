package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Hero");

        while (true) {
            character.displayStatusAndActions();
            System.out.println("Enter your choice:");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    character.train();
                    break;
                case "2":
                    if (character.getState() instanceof IntermediateState || character.getState() instanceof ExpertState) {
                        character.meditate();
                    } else if (character.getState() instanceof MasterState) {
                        System.out.println("Action not available. Please choose a valid action.");
                    }
                    break;
                case "3":
                    if (character.getState() instanceof ExpertState) {
                        character.fight();
                    } else {
                        System.out.println("Action not available. Please choose a valid action.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting game...");
                    return; // Exit the game
                default:
                    System.out.println("Invalid choice. Please select a valid action.");
                    break;
            }
        }
    }
}
