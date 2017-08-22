package com.example.gustavocrepaldi.AndroidEngineering;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gustavocrepaldi.AndroidEngineering._02GeneralConcepts.GeneralConcepts;
import com.example.gustavocrepaldi.AndroidEngineering._03Activity.MenuActivity;
import com.example.gustavocrepaldi.AndroidEngineering._04Intent.MenuIntent;
import com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter.MenuIntentFilter;
import com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver.MenuBroadcastReceiver;
import com.example.gustavocrepaldi.AndroidEngineering._07Notification.MenuNotification;


/**
 * Created by Gustavo Crepaldi on 13/05/2017.
 */

public class MenuGeral extends ListActivity {


    protected static final String TAG = "MenuGeralLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] mStrings = new String[] {
                "00 - GENERAL CONCEPTS",
                "01 - ACTIVITY",
                "02 - INTENT",
                "03 - INTENT FILTER",
                "04 - BROADCASTRECEIVER",
                "05 - NOTIFICATION",
                "Sair"};

        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                startActivity(new Intent(this, GeneralConcepts.class));
                break;
            case 1:
                Log.i(TAG, "01");
                startActivity(new Intent(this,MenuActivity.class));
                break;
            case 2:
                Log.i(TAG, "02");
                startActivity(new Intent(this, MenuIntent.class));
                break;
            case 3:
                Log.i(TAG, "03");
                startActivity(new Intent(this, MenuIntentFilter.class));
                break;
            case 4:
                Log.i(TAG, "04");
                startActivity(new Intent(this, MenuBroadcastReceiver.class));
                break;
            case 5:
                Log.i(TAG, "05");
                startActivity(new Intent(this, MenuNotification.class));
                break;
            default:
                finish();
        }
    }
}
