package edu.utsa.cs3443.ysw932_lab4.model;

import android.content.res.AssetManager;

import java.io.InputStream;
import java.util.*;
import java.io.*;
public class Trivia {

    private String question;
    private String[] answerChoices;
    private String answer;
    private ArrayList<Trivia> triviaFile;
    public Trivia(String question, String[] answerChoices, String answer) {
        this.question = question;
        this.answerChoices = answerChoices;
        this.answer = answer;

    }

    public Trivia() {
        this.triviaFile = new ArrayList<Trivia>();
    }

    public void addTrivia(String question, String[] answerChoices, String answer) {
        Trivia trivia = new Trivia(question, answerChoices, answer);
        triviaFile.add(trivia);
    }

    //method which takes in a file name and stores 1 piece of trivia from that file
    public void loadTrivia(AssetManager manager) {
        Scanner scan = null;
        InputStream inputStream;
//        ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"
        try {
            inputStream = manager.open("trivia.csv");
            scan = new Scanner(inputStream);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(",");

                String question = tokens[0];
                String choice1 = tokens[1];
                String choice2 = tokens[2];
                String choice3 = tokens[3];
                String answer = tokens[4];

                String[] answerChoices = {choice1, choice2, choice3};
                triviaFile.add(new Trivia(question, answerChoices, answer));

            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //close the file
            if (scan != null)
                scan.close();
        }

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<Trivia> getTriviaFile() {
        return triviaFile;
    }

    public void setTriviaFile(ArrayList<Trivia> triviaFile) {
       this.triviaFile = triviaFile;
    }
}
