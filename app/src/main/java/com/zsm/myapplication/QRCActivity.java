package com.zsm.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QRCActivity extends AppCompatActivity {
    Button bt_QRC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrc);
        //去除ActionBar
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        bt_QRC =(Button)findViewById(R.id.bt_QRC_QRC);
        bt_QRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(QRCActivity.this,PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
