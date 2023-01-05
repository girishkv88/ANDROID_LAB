package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity2 extends AppCompatActivity {

    EditText ac2texts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Toast.makeText(this,"WELCOME TO PAGE 2",Toast.LENGTH_SHORT).show();
//        Intent intent=getIntent();
//        String v1=intent.getStringExtra("name");   getting values with intent

        // for getting values with bundle
        Bundle extras= getIntent().getExtras(); //fetching values into the bundle
        String v1=extras.getString("name");  //extracting the String with id val1
        ac2texts=findViewById(R.id.ac2texts);
        ac2texts.setText(v1+"");
    }

    public void Activ1(View view) {
        Intent i2 = new Intent(SecondActivity2.this,MainActivity.class);
        startActivity(i2);
    }
}