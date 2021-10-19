package com.fazemahn.financeportfolio;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.fazemahn.FinancePortfolio.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Called when user presses Calculate button.
    public void calculateActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        EditText editText2 = (EditText) findViewById(R.id.editTextNumber2);
        EditText editText3 = (EditText) findViewById(R.id.editTextNumber3);
        double p = Double.parseDouble(editText.getText().toString());
        double r = Double.parseDouble(editText2.getText().toString());
        r = r/1200;
        double n = Double.parseDouble(editText3.getText().toString());
        double M = p*((r*Math.pow((1+r),n))/(Math.pow((1 + r),n)-1));
        String message = Double.toString(M);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}