package com.example.root.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btn2;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        txt=findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"Se cambio el texto del textView",Toast.LENGTH_LONG).show();
                txt.setText("Hola");
            }
        });



        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"Se cambio el texto del textView",Toast.LENGTH_LONG).show();
                txt.setText("Adios");
            }
        });


    }
}
