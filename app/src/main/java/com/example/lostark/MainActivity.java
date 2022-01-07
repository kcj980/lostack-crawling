package com.example.lostark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.nickname);
        Button button_ok = (Button) findViewById(R.id.button1);
        button_ok.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatsActivity.class);
                intent.putExtra("name", edit.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void EndLostark(View v){
        ActivityCompat.finishAffinity(MainActivity.this);
    }
}