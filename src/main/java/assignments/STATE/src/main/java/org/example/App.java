package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Hero");

        while (true) {
            character.displayStatusAndActions();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("ENTER YOUR CHOICE:");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    character.train();
                    break;
                case "2":
                    character.meditate();
                    break;
                case "3":
                    character.fight();
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
