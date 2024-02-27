package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question() {
    }

    @JsonCreator
    public Question(@JsonProperty("questionText") String questionText,
                    @JsonProperty("options") String[] options,
                    @JsonProperty("correctAnswer") char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
