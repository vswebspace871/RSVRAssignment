package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView readMore, tvCast;
    CardView cardView, cardViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readMore = findViewById(R.id.readMore);
        tvCast = findViewById(R.id.tvCast);
        cardView = findViewById(R.id.myCard);
        cardViewMain = findViewById(R.id.cardViewMain);

        // transparent status bar
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(readMore.getText()) && TextUtils.equals(readMore.getText(), "Read More")) {

                    readMore.setText("Read Less");
                    // expandable cardview animation
                    TransitionManager.beginDelayedTransition(cardViewMain, new AutoTransition());
                    cardView.setVisibility(View.VISIBLE);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewMain, new AutoTransition());
                    cardView.setVisibility(View.GONE);
                    readMore.setText("Read More");
                }
            }
        });
    }
}