package com.example.socsho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        TextView top=findViewById(R.id.top);
        TextView bottom=findViewById(R.id.bottom);


        Thread thread=new Thread() {

            @Override
            public void run() {
                //super.run();
                try{
                    sleep(3000);
                }
                catch (Exception e){

                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();



    }
}