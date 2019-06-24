package kevinhuang.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTrueButton;
    private Button mFalsebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalsebutton = (Button) findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(this);
        mFalsebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView myTextView = (TextView) view;
        Toast myToast = Toast.makeText(this, "You just clicked"+ myTextView.getText(), Toast.LENGTH_SHORT);
        myToast.show();
        myToast.setGravity(Gravity.TOP,0,0);

    }
}
