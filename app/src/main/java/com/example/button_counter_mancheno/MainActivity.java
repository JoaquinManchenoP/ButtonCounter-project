package com.example.button_counter_mancheno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag = "message";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button incrementButton;
        incrementButton = findViewById(R.id.increment);

        final Button decrementButton;
        decrementButton = findViewById(R.id.decrement);

        final Button resetButton;
        resetButton = findViewById(R.id.reset);






        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("hello", "The increment button got clicked");


               incrementCounter();



            }

            private void incrementCounter(){
                TextView myTextView = findViewById(R.id.counterNumber);
                int screenValue = Integer.valueOf(myTextView.getText().toString());
                screenValue++;

                myTextView.setText(String.valueOf(screenValue));


            }


        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(tag, "The decrement button got clicked");
                decrementCounter();
            }

            private void decrementCounter(){
                TextView myTextView = findViewById(R.id.counterNumber);
                int screenValue = Integer.valueOf(myTextView.getText().toString());
                screenValue--;

                myTextView.setText(String.valueOf(screenValue));


            }



        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("hello", "The reset button got clicked");
                resetCounter();
            }

            private void resetCounter(){
                TextView myTextView = findViewById(R.id.counterNumber);
                int screenValue = Integer.valueOf(myTextView.getText().toString());
                screenValue = 0;

                myTextView.setText(String.valueOf(screenValue));


            }
        });







    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        TextView myTextView = findViewById(R.id.counterNumber);

        String counterValue = myTextView.getText().toString();
        outState.putString("counterNumber", counterValue);




    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TextView myTextView = findViewById(R.id.counterNumber);
        String counterValue = savedInstanceState.getString("counterNumber");

        myTextView.setText(counterValue);






    }
}







