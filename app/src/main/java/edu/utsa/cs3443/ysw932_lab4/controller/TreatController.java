package edu.utsa.cs3443.ysw932_lab4.controller;

import android.content.res.AssetManager;
import android.widget.ImageView;

import java.util.Random;

import edu.utsa.cs3443.ysw932_lab4.R;
import edu.utsa.cs3443.ysw932_lab4.TreatActivity;

public class TreatController {

    TreatActivity treatActivity;
    AssetManager manager;

    public TreatController(TreatActivity activity) {
        treatActivity = activity;
        manager = treatActivity.getAssets();
    }

    public void loadRandomImage() {
        int [] imageResources = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
        };

        Random random = new Random();
        int randomIndex = random.nextInt(imageResources.length);

        ImageView treatImageView = treatActivity.findViewById(R.id.treatImageView);
        treatImageView.setImageResource(imageResources[randomIndex]);
    }

}
