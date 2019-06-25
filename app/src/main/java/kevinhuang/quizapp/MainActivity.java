package kevinhuang.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private Button mTrueButton;
    private Button mFalsebutton;
    private Button mNextButton;

    private Question[] mQuestions;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalsebutton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(this);
        mFalsebutton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        //Init an array of questions
        mQuestions = new Question[5];
        mIndex = 0;
        //Init each slot of the array
        mQuestions[0] = new Question(R.string.question_1, true);
        mQuestions[1] = new Question(R.string.question_2, true);
        mQuestions[2] = new Question(R.string.question_3, false);
        mQuestions[3] = new Question(R.string.question_4, true);
        mQuestions[4] = new Question(R.string.question_5, false);

        //go to whichever question is represented by mIndex
        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
        } else if (view.getId() == R.id.false_button ) {
            checkAnswer(false);
        } else if (view.getId() == R.id.next_button) {
            //change to the next question
            //increment the index by 1
            mIndex++;

            //do if statement here
            // if the mIndex is greater than equal 
            //change text in view
            mTextView.setText(mQuestions[mIndex].getTextResId());

        }
    }
        public boolean checkAnswer(boolean userInput){
            if(mQuestions[mIndex].getAnswer() == userInput){
                Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
                myToast.show();
                return true;
            }
            else{
                Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
                myToast.show();
                return false;
            }


    }
}
