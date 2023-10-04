package com.example.japrog3210a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    //Declaring variables
    private TextView header; // Declare the TextView as a class member
    private TextView numberDisplay;
    private Button btn;
    private int number;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        number = intent.getIntExtra("number", 0);
        name = intent.getStringExtra("name");
        header = findViewById(R.id.textViewHeader);
        numberDisplay = findViewById(R.id.numberDisplay);
        header.setText("Your Lucky Number is:");
        numberDisplay.setText(String.valueOf(number));
        btn = findViewById(R.id.share);
        btn.setOnClickListener(new Click());
    }

    public class Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareText = name + "'s lucky number is: " + number; // Use the generated number
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareText);

            startActivity(Intent.createChooser(sharingIntent, null));
        }
    }
}