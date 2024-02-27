package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DesignPatternsGame extends Game {
    private List<Question> questions;
    private int score;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers != 1) {
            throw new IllegalArgumentException("This game is designed for one player.");
        }
        questions = loadQuestionsFromJson("design_patterns_questions.json");
        score = 0;
    }

    @Override
    public boolean endOfGame() {
        return questions.isEmpty();
    }

    @Override
    public void playSingleTurn(int player) {
        Question question = questions.remove(random.nextInt(questions.size()));
        System.out.println(question.getQuestionText());
        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println((char)('A' + i) + ": " + question.getOptions()[i]);
        }
        char answer = getUserAnswer();
        if (answer == question.getCorrectAnswer()) {
            System.out.println("CORRECT!");
            System.out.println("___________________________________________________________");
            score++;
        } else {
            System.out.println("WRONG! Correct answer was " + question.getCorrectAnswer());
            System.out.println("___________________________________________________________");
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Game over. Your score: " + score);
    }

    private List<Question> loadQuestionsFromJson(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Change the way to read the file using the class loader
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + filename);
            } else {
                return objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    private char getUserAnswer (){
        Scanner scanner = new Scanner (System.in);
        String input;
        do{ System.out.print("Enter your answer (A, B, C, D): ");
            input = scanner.nextLine().toUpperCase(); // Read user input and convert to uppercase
            // Check if the input is one of the valid options
            if (input.matches("[ABCD]")) {
                break; // Exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }

        }while (true);
        return input.charAt(0);
    }
}
