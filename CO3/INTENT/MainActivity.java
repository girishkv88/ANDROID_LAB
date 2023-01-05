package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ac1text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"WELCOME TO PAGE 1",Toast.LENGTH_SHORT).show();

        ac1text=findViewById(R.id.ac1texts);
    }

    // to go to first activity
    public void Activ2(View view) {
        Intent i = new Intent(MainActivity.this,SecondActivity2.class);

        String val1=ac1text.getText().toString();
        //i.putExtra("name",val1); for passing single valus using intent

        //for passing multiple values using bundle

        Bundle b=new Bundle();
        b.putString("name",val1);
        i.putExtras(b);
        startActivity(i);
    }
}