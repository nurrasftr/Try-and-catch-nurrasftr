package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void randomNumberGenerator()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt();
    }
    public void onGuess(View view){

        try {
            String message = "";
            EditText editText = (EditText) findViewById(R.id.editText);
            int guessedNumber = Integer.parseInt(editText.getText().toString());
            if (guessedNumber < randomNumber)
                message="Lebih tinggi !!";
            else if (guessedNumber > randomNumber)
                message="Ketinggian !!";
            else if (guessedNumber == randomNumber)
            {
                message="Yeay, kamu benar !!  " + randomNumber;
                randomNumberGenerator();
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setError("Wajib masukkan angka !!");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}