package com.bobo.homework4sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.b_sayhello);
        button.setOnClickListener(listener);
        editText = (EditText) findViewById(R.id.et_name);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction("NOTIFICATION");
            String message = editText.getEditableText().toString();
            intent.putExtra("KEY_MSG", message);
            sendBroadcast(intent);
        }
    };
}
