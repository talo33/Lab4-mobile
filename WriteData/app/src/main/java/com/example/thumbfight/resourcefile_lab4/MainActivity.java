package com.example.thumbfight.resourcefile_lab4;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity implements OnClickListener{
        Button button,button2;
        EditText editdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        editdata=(EditText) findViewById(R.id.editdata);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }
        public void onClick(View v) {
            if(v.getId()==R.id.button)
            {
                readData();
            }
            else if(v.getId()==R.id.button2)
            {
                writeData();
            }
        }

        public void readData()
        {
            try {
                FileInputStream in= openFileInput("myfile.txt");
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                String data="";
                StringBuilder builder=new StringBuilder();
                while((data=reader.readLine())!=null)
                {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                editdata.setText(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void writeData()
        {
            try {
                FileOutputStream out= openFileOutput("myfile.txt",0);
                OutputStreamWriter writer= new OutputStreamWriter(out);
                writer.write(editdata.getText().toString());
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }