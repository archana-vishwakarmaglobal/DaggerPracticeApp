package com.firebase.daggerpractceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.daggerpractceapp.model.APIURL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // APIURL.Companion.getBASE_URL() without const
        //APIURL.BASE_URL ;//with const
    }
}
