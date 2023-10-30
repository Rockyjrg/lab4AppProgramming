package edu.utsa.cs3443.ysw932_lab4;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.ysw932_lab4.controller.MainController;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainController mainController = new MainController(this);
        Button trickButton = findViewById(R.id.TrickButton);
        trickButton.setOnClickListener(mainController);
        Button treatButton = findViewById(R.id.TreatButton);
        treatButton.setOnClickListener(mainController);
    }
}