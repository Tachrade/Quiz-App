package habeebsalami.sms2profit.com.habeebsalami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    private Question mQuestionLibrary = new Question();
    private TextView mscoreView; // View for current total score
    private TextView mQuestionView; // Curent question t answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer; // Current ans for ques in mquView
    private int mScore = 0; //current total score
    private int mQuestionNumber = 0; // current question


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.activity_quiz);
        ;

//setup Screen for the first Question with 4 alternative to answer
        mscoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        updateQuestion();
        //show current total score for the  user
        updateScore(mScore);

    }

    private void updateQuestion() {
        //check if were not outside array  bounds for question

        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            //set the text for new question, and new 4 aiternative to answer 4 buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(this, "It was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HighestScoreActivity.class);
            intent.putExtra("score", mScore);//pass the current score to the second screen
            startActivity(intent);// Starts Implicit Actvity
        }

    }

    //Show current total score for the User
    private void updateScore(int point) {
        mscoreView.setText("Your point is :" + mScore + "/" + mQuestionLibrary.getLength());
    }


    public void OnClick(View view) {
        //All logic for all answers buttons in method
        Button answer = (Button) view;
        // if the answer is Correct, increase the score
        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT).show();
            updateScore(mScore);
            updateQuestion();

        } else {
            Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show();
            //show curret total score for the user
            //updateScore(mScore);
            //once user answer the question, we move on to the next one, if any
            updateQuestion();
        }
    }


}
