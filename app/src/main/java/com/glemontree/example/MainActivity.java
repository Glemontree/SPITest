package com.glemontree.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private StringBuilder mStringBuilder;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStringBuilder = new StringBuilder();
        mButton = (Button) findViewById(R.id.id_btn);
        mTextView = (TextView) findViewById(R.id.id_textview);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadModule();
            }
        });
    }

    private void loadModule() {
        String display = "";
        mButton.setClickable(false);
        while (HelloFactory.newInstance().hasNextHello()) {
            display = HelloFactory.newInstance().getHello().hello();
            mStringBuilder.append(display).append("\n");
        }
        mTextView.setText(mStringBuilder.toString());
    }
}
