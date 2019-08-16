package com.coxtunes.listviewcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String s= getIntent().getStringExtra("data");
        if (s.contains("Cleaning Service"))
        {
            Toast.makeText(getApplicationContext(),"Cleaning Service", Toast.LENGTH_SHORT).show();
        }
        if (s.contains("Sofa Cleaning"))
        {
            Toast.makeText(getApplicationContext(),"Sofa Cleaning", Toast.LENGTH_SHORT).show();
        }
        if (s.contains("Furniture Cleaning"))
        {
            Toast.makeText(getApplicationContext(),"Furniture Cleaning", Toast.LENGTH_SHORT).show();
        }
    }
}
