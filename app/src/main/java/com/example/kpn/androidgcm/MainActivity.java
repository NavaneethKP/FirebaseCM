package com.example.kpn.androidgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private TextView tv_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_token=(TextView) findViewById(R.id.tv_token);
        broadcastReceiver= new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                tv_token.setText(SharedPrefManager.getInstance(getApplicationContext()).getToken());
            }
        };

        registerReceiver(broadcastReceiver,new IntentFilter(MyFirebaseInstanceIdService.TOKEN_BROADCAST));


    }
}
