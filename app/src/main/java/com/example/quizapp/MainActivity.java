package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"The Java interpreter is used for the execution of the source code.", "The Java source code can be created in a Notepad editor.", "Java is a person.", "Java was introduced in 1233.", "Java has abstract classes.", "Java was introduced before C++."};
    private boolean[] answer = {true,true,false,false,true,false};
    private int score = 0;
    Button yes;
    Button no;
    TextView question;
    private  int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1){
                    if (answer[index]){
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1){
                        question.setText(questions[index]);
                    }
                    else Toast.makeText(MainActivity.this, "Your Score is: " + score, Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Quiz is Over!!!", Toast.LENGTH_SHORT).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index <= questions.length - 1){
                    if (!answer[index]){
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1){
                        question.setText(questions[index]);
                    }
                    else Toast.makeText(MainActivity.this, "Your Score is: " + score, Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Quiz is Over!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}