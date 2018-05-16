package com.londonappbrewery.destini;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button answer1Btn;
    Button answer2Btn;

    int storyProgress = 1;
    String storyChain;


    public void AnswerSelected(int answer){
        if (storyProgress == 1) {
            if (answer == 1) {
                storyText.setText(getText(R.string.A1_Ans1_Story));
                answer1Btn.setText(getText(R.string.A1a_Ans1));
                answer2Btn.setText(getText(R.string.A1a_Ans2));
                storyChain = "a";
            } else {
                storyText.setText(getText(R.string.A1_Ans2_Story));
                answer1Btn.setText(getText(R.string.A1b_Ans1));
                answer2Btn.setText(getText(R.string.A1b_Ans2));
                storyChain = "b";
            }
        }
        if (storyProgress == 2) {
            if (answer == 1) {
                if (storyChain == "a") {
                    storyText.setText(getText(R.string.A1a_Ans1_End));
                    answer1Btn.setEnabled(false);
                    answer1Btn.setVisibility(View.INVISIBLE);
                    answer2Btn.setEnabled(false);
                    answer2Btn.setVisibility(View.INVISIBLE);
                }
                if (storyChain == "b") {
                    storyProgress = 0;
                }
                storyChain = "a";
            } else {
                if (storyChain == "a") {
                    storyText.setText(getText(R.string.A1a_Ans2_End));
                }
                if (storyChain == "b") {
                    storyText.setText(getText(R.string.A1b_Ans2_End));
                }
                answer1Btn.setEnabled(false);
                answer1Btn.setVisibility(View.INVISIBLE);
                answer2Btn.setEnabled(false);
                answer2Btn.setVisibility(View.INVISIBLE);
                storyChain = "b";
            }
        }
        storyProgress++;
        if(storyProgress == 1){AnswerSelected(1);}

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyText = findViewById(R.id.storyTextView);
        answer1Btn = findViewById(R.id.buttonTop);
        answer2Btn = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        answer1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnswerSelected(1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        answer2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnswerSelected(2);
            }
        });

    }
}
