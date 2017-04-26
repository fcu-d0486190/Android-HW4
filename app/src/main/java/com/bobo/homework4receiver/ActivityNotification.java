package com.bobo.homework4receiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.bobo.homework4receiver.BR_Notification.KEY_MSG;

/**
 * Created by User on 2017/4/25.
 */

public class ActivityNotification extends AppCompatActivity{
    private TextView textView;
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_fake);
        textView = (TextView) findViewById(R.id.tv_hello);
        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_MSG);
        textView.setText("Hello "+message);
    }
}
