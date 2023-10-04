package com.example.japrog3210a1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    // Declare variables
    private TextView header;
    private TextView name;
    private TextView numberDisplay;
    private Button btn;
    public Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.generateButton);
        header = findViewById(R.id.textViewHeader);
        numberDisplay = findViewById(R.id.numberDisplay);
        name = findViewById(R.id.nameInput);
        btn.setOnClickListener(new Click());
    }

    public class Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String nameInput = name.getText().toString();
            if (nameInput.isEmpty()){
                header.setText("Please enter your name");
            }
            else{
                int number = random.nextInt(999);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("number", number);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
            }
        }
    }
}