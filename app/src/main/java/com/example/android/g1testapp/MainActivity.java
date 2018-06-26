package com.example.android.g1testapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Set counter for right answer
    private int rightAnswer = 0;
    //Total question for quiz
    private int totalQuestion = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     * checking radio button for answer of Que 1
     */
    public void onRadioButtonClickedA1(View view) {

        RadioButton radioA2 = findViewById(R.id.radio_A2);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_A2:
                if (checked){
                    rightAnswer++;
                    radioA2.setBackgroundColor(Color.parseColor("#00C853"));
                }
                    break;
           default:
               radioA2.setBackgroundColor(Color.parseColor("#00C853"));
               break;
        }
    }

    /**
     *
     * @param view
     * checking radio button for answer of Que 1
     */
    public void onRadioButtonClickedA2(View view) {

        RadioButton radioA4 = findViewById(R.id.radio_A2_4);

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_A2_4:
                if (checked){
                    rightAnswer++;
                    radioA4.setBackgroundColor(Color.parseColor("#00C853"));
                }
                break;
            default:
                radioA4.setBackgroundColor(Color.parseColor("#00C853"));
                break;
        }
    }

    /**
     *
     * @param view
     * checking radio button for answer of Que 1
     */
    public void onRadioButtonClickedA3(View view) {


        RadioButton radioA1 = findViewById(R.id.radio_A3_1);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_A3_1:
                if (checked){
                    rightAnswer++;
                    radioA1.setBackgroundColor(Color.parseColor("#00C853"));
                }
                break;
            default:
                radioA1.setBackgroundColor(Color.parseColor("#00C853"));
                break;
        }
    }

    /**
     *
     * @param view
     * checking radio button for answer of Que 1
     */
    public void onRadioButtonClickedA4(View view) {

        RadioButton radioA3 = findViewById(R.id.radio_A4_3);

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_A4_3:
                if (checked){
                    rightAnswer++;
                    radioA3.setBackgroundColor(Color.parseColor("#00C853"));
                }
                break;
            default:
                radioA3.setBackgroundColor(Color.parseColor("#00C853"));
                break;
        }
    }

    /**
     * This method is used for getting result of test and showed on screen by toast
     * @param view
     */
   public void onClickSubmitButton(View view){
     String result = "Your score is " + rightAnswer + " out of " + totalQuestion;

       Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
   }

    /**
     * This method is used to close the app
     * @param view
     */
   public void onClickResetButton(View view){

       finish();
   }

    /**
     * This method is used to send a score of quiz through an email
     * @param view
     */

   public void onClickEmailButton(View view){

       EditText emailText = findViewById(R.id.email_text_view);
       String email = emailText.getText().toString();
       String subject = "G1 Test Score";
       String body = "Your G1 Test score is " + rightAnswer + " out of " + totalQuestion;

           Intent intent = new Intent(Intent.ACTION_SENDTO);
           intent.setData(Uri.parse("mailto:"+ email)); // only email apps should handle this
           intent.putExtra(Intent.EXTRA_SUBJECT, subject);
           intent.putExtra(Intent.EXTRA_TEXT, body);
           if (intent.resolveActivity(getPackageManager()) != null) {
               startActivity(intent);
           }

   }
}
