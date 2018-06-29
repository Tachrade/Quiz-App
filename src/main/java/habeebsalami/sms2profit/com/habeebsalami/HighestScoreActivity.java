package habeebsalami.sms2profit.com.habeebsalami;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = findViewById(R.id.txt_Score);
        TextView txtHighScore = findViewById(R.id.txt_HighScore);
        TextView txtStatus = findViewById(R.id.txt_status);


        //recieve the score from last activity by intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        score = score * 5;
        txtScore.setText("Your Score is  :" + score);

        //Use Shared Prefrences to give the best score
        SharedPreferences scPref = getPreferences(MODE_PRIVATE);
        int hScore = scPref.getInt("hScore", 0);
        if (hScore >= score) {
            txtHighScore.setText("High Score is :" + hScore);
        } else {
            txtHighScore.setText("New highscore:" + score);
            SharedPreferences.Editor editor = scPref.edit();
            editor.putInt("hScore", score);
            editor.commit();
        }
        if (score == 50) {
            txtStatus.setText("Excellent, you are awesome");
        }
         else if (score >= 30 ) {
            txtStatus.setText("Very Good ,you can do better");
        }
         else if ( score == 25 ) {
            txtStatus.setText("Average ,try again");
        }
        else {
            txtStatus.setText("Please try again");
        }


    }

    public void onClick(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);

    }

    /*public void exit(View view) {
        System.exit(0);
    }*/


}
