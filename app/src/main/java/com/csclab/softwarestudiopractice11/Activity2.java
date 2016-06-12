package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by mei on 5/24/16.
 */

public class Activity2 extends Activity{

    private TextView nameText;
    private Button plusButton;
    private Button minusButton;
    private Button multButton;
    private Button divButton;
    private EditText firstText;
    private EditText secondText;

    public Socket socket;
    public BufferedReader in;
    public PrintWriter out;
    private String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        setContentView(R.layout.activity_2);
        nameText = (TextView)findViewById(R.id.nameTextView);
        plusButton = (Button)findViewById(R.id.button2);
        minusButton = (Button)findViewById(R.id.button3);
        multButton = (Button)findViewById(R.id.button4);
        divButton = (Button)findViewById(R.id.button5);

        firstText= (EditText)findViewById(R.id.editText2);
        secondText= (EditText)findViewById(R.id.editText3);

        nameText.setText(bundle.getString("name"));
        ip = bundle.getString("name");
        plusButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            socket = new Socket(ip, 2000);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                            // in的部分給另外一個執行緒去弄
                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "BIG5")), true);
                            out.write(String.valueOf(firstText.getText()) + "+" + String.valueOf(secondText.getText()) + "=" + String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) + Integer.valueOf(String.valueOf(secondText.getText()))));
                            out.flush();
                            Log.i("sac", "sacascsc");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                t1.start();
                Intent intent = new Intent();
                intent.setClass(Activity2.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("result", String.valueOf(firstText.getText()) + "+" + String.valueOf(secondText.getText()) + "=" + String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) + Integer.valueOf(String.valueOf(secondText.getText()))));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        minusButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            socket = new Socket(ip, 2000);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                            // in的部分給另外一個執行緒去弄
                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"BIG5")), true);
                            out.write( String.valueOf(firstText.getText())+"-"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) - Integer.valueOf(String.valueOf(secondText.getText()))));
                            out.flush();
                            Log.i("sac","sacascsc");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
                Intent intent = new Intent();
                intent.setClass(Activity2.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("result", String.valueOf(firstText.getText())+"-"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) - Integer.valueOf(String.valueOf(secondText.getText()))));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        multButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            socket = new Socket(ip, 2000);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                            // in的部分給另外一個執行緒去弄
                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"BIG5")), true);
                            out.write(String.valueOf(firstText.getText())+"*"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) * Integer.valueOf(String.valueOf(secondText.getText()))));
                            out.flush();
                            Log.i("sac","sacascsc");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
                Intent intent = new Intent();
                intent.setClass(Activity2.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("result", String.valueOf(firstText.getText())+"*"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) * Integer.valueOf(String.valueOf(secondText.getText()))));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        divButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            socket = new Socket(ip, 2000);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                            // in的部分給另外一個執行緒去弄
                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"BIG5")), true);
                            out.write(String.valueOf(firstText.getText())+"/"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) / Integer.valueOf(String.valueOf(secondText.getText()))));
                            out.flush();
                            Log.i("sac","sacascsc");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
                Intent intent = new Intent();
                intent.setClass(Activity2.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("result", String.valueOf(firstText.getText())+"/"+String.valueOf(secondText.getText())+"="+String.valueOf(Integer.valueOf(String.valueOf(firstText.getText())) / Integer.valueOf(String.valueOf(secondText.getText()))));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
