package com.example.sqlprogram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,name,place;
    Button binsert,bselect,bupdate,bdelete,bclear;
    TextView tid,tname,tplace;
    SQLiteDatabase db;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.idfield);
        name=findViewById(R.id.namefield);
        place=findViewById(R.id.placefield);
        binsert=findViewById(R.id.insertbutton);
        bselect=findViewById(R.id.selectbutton);
        bupdate=findViewById(R.id.updatebutton);
        bdelete=findViewById(R.id.deletebutton);
        bclear=findViewById(R.id.clearbutton);
        builder=new AlertDialog.Builder(this);

        try {
            db=openOrCreateDatabase("empdb",MODE_PRIVATE,null);
            db.execSQL("create table employee(id integer primary key,name Text,place Text)");
            Toast.makeText(getApplicationContext(), "CREATED SUCCESFULLY", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {

        }

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.execSQL("Insert into employee values ("+id.getText().toString()+",'"+name.getText().toString()+"','"+place.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(), "RECORD INSERTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "ERROR OCCURED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bclear.callOnClick();

        bselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=db.rawQuery("select * from employee",null);
                if(c.getCount()==0){
                    Toast.makeText(getApplicationContext(), "NO SUCH RECORD", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer b=new StringBuffer();
                    while (c.moveToNext()){
                        b.append("id:"+c.getString(0)+"\n");
                        b.append("name:"+c.getString(1)+"\n");
                        b.append("place:"+c.getString(2)+"\n");
                    }
                    Toast.makeText(getApplicationContext(), b.toString(), Toast.LENGTH_SHORT).show();
                    builder.setMessage(b.toString());
                    AlertDialog alert=builder.create();
                    alert.setTitle("EMPLOYEE DATA");
                    alert.show();

                }
            }
        });

        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("update employee set name='"+name.getText().toString()+"',place='"+place.getText().toString()+"' where id="+id.getText().toString()+"");
                Toast.makeText(getApplicationContext(), "UPDATED", Toast.LENGTH_SHORT).show();
            }
        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("delete from employee where id="+id.getText().toString());
                Toast.makeText(getApplicationContext(), "ITEM DELETED", Toast.LENGTH_SHORT).show();
            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id.setText("");
                name.setText("");
                place.setText("");
            }
        });
        bclear.callOnClick();

    }
}