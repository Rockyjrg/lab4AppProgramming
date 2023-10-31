//package edu.utsa.cs3443.ysw932_lab4.controller;
//
//import android.content.res.AssetManager;
//import android.view.View;
//import android.widget.*;
//
//import edu.utsa.cs3443.ysw932_lab4.TrickActivity;
//import edu.utsa.cs3443.ysw932_lab4.R;
//import edu.utsa.cs3443.ysw932_lab4.model.Trivia;

//public class TrickController implements View.OnClickListener {
//
//    TrickActivity trickActivity;
//    AssetManager manager;
//
//    public TrickController(TrickActivity activity) {
//        trickActivity = activity;
//        manager = trickActivity.getAssets();
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        AssetManager manager;
//        manager = v.getContext().getAssets();
//        Trivia trivia = new Trivia();
//
//        trivia.loadTrivia(manager);
//
//    }
//}
package edu.utsa.cs3443.ysw932_lab4.controller;

import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import edu.utsa.cs3443.ysw932_lab4.R;
import edu.utsa.cs3443.ysw932_lab4.model.Trivia;
public class TrickController implements View.OnClickListener {

    private AppCompatActivity activity;
    private Trivia trivia;
    private TextView questionText;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;

    public TrickController(AppCompatActivity activity) {
        this.activity = activity;
        this.trivia = new Trivia();

        // Initialize your UI elements
        questionText = activity.findViewById(R.id.questionText);
        answerButton1 = activity.findViewById(R.id.AnswerButton1);
        answerButton2 = activity.findViewById(R.id.AnswerButton2);
        answerButton3 = activity.findViewById(R.id.AnswerButton3);

        // Set click listeners for answer buttons
        answerButton1.setOnClickListener(this);
        answerButton2.setOnClickListener(this);
        answerButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button selectedAnswerButton = (Button) v;
            String selectedAnswer = selectedAnswerButton.getText().toString().replace(" ","");
            String correctAnswer = trivia.getAnswer().replace(" ", "");
            boolean isCorrect = correctAnswer.contains(selectedAnswer);

            String message = isCorrect ? "Correct" : "Incorrect";
            String finalMessage = message + " " + this.trivia.getAnswer();
            //displayToastMessage(Boolean.toString(isCorrect));
            displayToastMessage(finalMessage);
        }
    }

    private void displayToastMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public void loadQuestionAndAnswerChoices() {
        // Load a random trivia question and its answer choices
        trivia.loadTrivia(activity.getAssets());

        // Set the question text
        questionText.setText(trivia.getQuestion());

        // Set answer choices on buttons
        ArrayList<String> answerChoices = trivia.getAnswerChoices();
        answerButton1.setText(answerChoices.get(0));
        answerButton2.setText(answerChoices.get(1));
        answerButton3.setText(answerChoices.get(2));
    }
}