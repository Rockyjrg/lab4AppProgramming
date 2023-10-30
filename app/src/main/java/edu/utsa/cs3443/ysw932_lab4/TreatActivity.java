package edu.utsa.cs3443.ysw932_lab4;

import android.widget.ImageView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.ysw932_lab4.controller.TreatController;

public class TreatActivity extends AppCompatActivity {

    ImageView treatImageView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);

        treatImageView = findViewById(R.id.treatImageView);

        TreatController treatController = new TreatController(this);
        treatController.loadRandomImage();
    }

}
