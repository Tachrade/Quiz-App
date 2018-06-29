package habeebsalami.sms2profit.com.habeebsalami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.button);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start MainActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        QuizActivity.class);
                startActivity(myIntent);
            }
        });
    }

}

