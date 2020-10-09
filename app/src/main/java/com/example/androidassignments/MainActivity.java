package com.example.androidassignments;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = (Button)findViewById(R.id.button);
//        button.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                ((TextView) findViewById(R.id.textView)).setText(R.string.buttonText);
//            }
//        });
    }


}