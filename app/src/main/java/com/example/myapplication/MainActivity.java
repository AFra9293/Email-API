package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextSubject, editTextContent, editTextToEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnSend);
        editTextSubject = findViewById(R.id.subject);
        editTextContent = findViewById(R.id.content);
        editTextToEmail = findViewById(R.id.to_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject, content, to_email;
                subject = editTextSubject.getText().toString();
                content = editTextContent.getText().toString();
                to_email = editTextToEmail.getText().toString();
                if (subject.equals("") && content.equals("") && to_email.equals("")) {
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail(subject, content, to_email);
                }
            }
        });
    }

    public void sendEmail(String subject, String content, String to_email) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to_email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose email client:"));

    }

}