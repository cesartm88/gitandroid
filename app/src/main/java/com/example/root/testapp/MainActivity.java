package com.example.root.testapp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btn2;
    private TextView txt;
    // Set your Image URL into a string
    String URL = "https://vignette.wikia.nocookie.net/toontown/images/2/29/Penny6.png/revision/latest/scale-to-width-down/153?cb=20111115234958";
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;

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

        // Locate the ImageView in activity_main.xml
        image = (ImageView) findViewById(R.id.image);

        // Locate the Button in activity_main.xml
        button = (Button) findViewById(R.id.button3);

        // Capture button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Execute DownloadImage AsyncTask
                new DownloadImage().execute(URL);
            }
        });
    }

    // DownloadImage AsyncTask
    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            image.setImageBitmap(result);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}
