package com.example.menuoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.samplemenu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "YOU HAVE CLICKED ON COURSES", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem1p1:
                Toast.makeText(this, "YOU HAVE CLICKED MCA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem1p2:
                Toast.makeText(this, "YOU HAVE CLICKED MBA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem1p3:
                Toast.makeText(this, "YOU HAVE CLICKED BTECH", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "YOU HAVE CLICKED ON SEMESTER", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2p1:
                Toast.makeText(this, "YOU HAVE CLICKED SEMESTER 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2p2:
                Toast.makeText(this, "YOU HAVE CLICKED SEMESTER 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2p3:
                Toast.makeText(this, "YOU HAVE CLICKED SEMESTER 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2p4:
                Toast.makeText(this, "YOU HAVE CLICKED SEMESTER 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Intent i=new Intent(this,MainActivity2.class);
                startActivity(i);


            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return true;
    }
}