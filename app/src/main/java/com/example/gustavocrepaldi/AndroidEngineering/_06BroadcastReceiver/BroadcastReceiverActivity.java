package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BroadcastReceiverActivity extends Activity{

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        TextView textView = new TextView(this);
        textView.setText("Acitivity inicializada por meio de um broadcastreceiver");
        setContentView(textView);

    }

}
