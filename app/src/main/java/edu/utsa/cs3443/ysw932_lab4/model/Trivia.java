package edu.utsa.cs3443.ysw932_lab4.model;

import android.content.res.AssetManager;

import java.io.InputStream;
import java.util.*;
import java.io.*;
public class Trivia {

    private String question;
    private ArrayList<String> answerChoices;
    private String answer;

    public Trivia() {
        this.answerChoices = new ArrayList<>();
    }


    //method which takes in a file name and stores 1 piece of trivia from that file
    public void loadTrivia(AssetManager manager) {
        ArrayList<String> questionPool = new ArrayList<>();
        Scanner scan = null;
        InputStream inputStream;
        int randomNumber = new Random().nextInt(10);
//        ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"
        try {
            inputStream = manager.open("trivia.csv");
            scan = new Scanner(inputStream);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                questionPool.add(line);
            }

            String randomTrivia = questionPool.get(randomNumber);

            String[] tokens = randomTrivia.split(",");
            StringJoiner joined = new StringJoiner("");
            if(tokens.length > 5) {
                for(int i = 4; i < tokens.length; i++) {
                    joined.add(tokens[i]);
                }
                tokens[4] = joined.toString();
            }

            String question = tokens[0];
            String choice1 = tokens[1];
            String choice2 = tokens[2];
            String choice3 = tokens[3];
            String answer = tokens[4];

            String[] choices = {choice1, choice2, choice3};
            this.answerChoices = new ArrayList<String>(Arrays.asList(choices));
            setQuestion(question);
            setAnswer(answer);

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

    public ArrayList<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(ArrayList<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
