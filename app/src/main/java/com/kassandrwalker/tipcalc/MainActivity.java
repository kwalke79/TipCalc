package com.kassandrwalker.tipcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Fields for Tip Calculator
    EditText billText;
    RadioGroup tipSizeRadioGroup;
    RadioButton tipSizeRadioButton;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Import from content_main.xml
        tipSizeRadioGroup = (RadioGroup) findViewById(R.id.tipSizeRadioGroup);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        billText = (EditText) findViewById(R.id.billText);
        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float bill = Float.parseFloat(billText.getText().toString());

                int selectedID = tipSizeRadioGroup.getCheckedRadioButtonId();
                // find the radio button from the returned id
                tipSizeRadioButton = (RadioButton) findViewById(selectedID);
                //float percentage;
                float percentage = Float.parseFloat(tipSizeRadioButton.getText().toString());
               /* if (tipSizeRadioButton.getText().toString() == "Poor")
                    percentage = 10.0f;
                else if (tipSizeRadioButton.getText().toString() == "Great")
                    percentage = 20;
                else
                    percentage = 15;*/
                float total = bill * (percentage/100);

                resultTextView.setText(Float.toString(total));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
