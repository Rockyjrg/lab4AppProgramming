package edu.utsa.cs3443.ysw932_lab4.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.ysw932_lab4.MainActivity;
import edu.utsa.cs3443.ysw932_lab4.R;
import edu.utsa.cs3443.ysw932_lab4.TreatActivity;
import edu.utsa.cs3443.ysw932_lab4.TrickActivity;
import edu.utsa.cs3443.ysw932_lab4.model.Trivia;

public class MainController implements View.OnClickListener{

    MainActivity mainActivity;
    AssetManager manager;

    public MainController(MainActivity activity) {
        mainActivity = activity;
        manager = mainActivity.getAssets();
    }

    public void onClick(View v) {
        AssetManager manager;
        manager = v.getContext().getAssets();

        if(v.getId() == R.id.TrickButton) {
            Intent intent = new Intent(mainActivity, TrickActivity.class);
            mainActivity.startActivity(intent);
        } else if (v.getId() == R.id.TreatButton) {
            Intent intent = new Intent(mainActivity, TreatActivity.class);
            mainActivity.startActivity(intent);
        }

    }

}
