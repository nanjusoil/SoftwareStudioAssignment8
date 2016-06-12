package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nanjusoil on 2016/6/12.
 */
public class ResultActivity extends Activity {
    private TextView resultText;
    private Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        resultText= (TextView) findViewById(R.id.resultText);
        Bundle bundle = this.getIntent().getExtras();
        Log.i("abc", bundle.getString("result"));
        resultText.setText(bundle.getString("result"));
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
