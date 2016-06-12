package com.csclab.softwarestudiopractice11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText edt;
    public BufferedReader in;
    public PrintWriter out;
    public Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.button);
        edt = (EditText)findViewById(R.id.editText);
        /** To Do:
         * (1) Find the UI element on xml file
         * **/


        send.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                connectServer();
            }
        });

    }

    public void connectServer(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Activity2.class);
        Bundle bundle = new Bundle();

        bundle.putString("name", String.valueOf(edt.getText()));
        intent.putExtras(bundle);
        startActivity(intent);



    }



}
