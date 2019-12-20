package com.agadimi.imageviewer;

import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private ImageView sceneIv;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
        setContentView(R.layout.activity_main);

        bindViews();

        if (getIntent() != null && getIntent().getData() != null)
        {
            Uri uri = getIntent().getData();
            sceneIv.setImageURI(uri);

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.scene_enter);
            sceneIv.startAnimation(animation);
        }
        else
        {
            finish();
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
    }

    private void bindViews()
    {
        sceneIv = findViewById(R.id.scene_iv);
    }
}
