package edu.utsa.cs3443.ysw932_lab4;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.ysw932_lab4.controller.TrickController;
import edu.utsa.cs3443.ysw932_lab4.model.Trivia;
public class TrickActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show new layout to user
        setContentView(R.layout.activity_trick);

        AssetManager manager = getAssets();

        TrickController trickController = new TrickController(this);

        TextView questionText = findViewById(R.id.questionText);
        questionText.setOnClickListener(trickController);
        Button AnswerButton1 = findViewById(R.id.AnswerButton1);
        AnswerButton1.setOnClickListener(trickController);
        Button AnswerButton2 = findViewById(R.id.AnswerButton2);
        AnswerButton2.setOnClickListener(trickController);
        Button AnswerButton3 = findViewById(R.id.AnswerButton3);
        AnswerButton3.setOnClickListener(trickController);

        trickController.loadQuestionAndAnswerChoices();
    }

}
