package com.example.gustavocrepaldi.AndroidEngineering._03Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

    protected static final String TAG = "ActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] mStrings = new String[] {
                "00 - Exemplo Activity - LifeCicle",
                "01 - Exemplo ListActivity - ArrayAdapter",
                "02 - Exemplo ListActivity - SimpleAdapter",
                "03 - Exemplo ListActivity - SimpleAdapter CustomLayout",
                "04 - Exemplo ListActivity - SimpleAdapter CustomLayoutImage",
                "Sair"};

        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                Intent intent = new Intent(this,Activity_MainActivityActivity.class);
                Log.i(TAG, "00");
                startActivity(intent);
                break;
            case 1:
                Log.i(TAG, "01");
                startActivity(new Intent(this,ListActivity_ArrayAdapter.class));
                break;
            case 2:
                Log.i(TAG, "02");
                startActivity(new Intent(this,ListActivity_SimpleAdapter.class));
                break;
            case 3:
                Log.i(TAG, "02");
                startActivity(new Intent(this,ListActivity_SimpleAdapter_LayoutCustom.class));
                break;
            case 4:
                Log.i(TAG, "02");
                startActivity(new Intent(this,ListActivity_BaseAdapter_LayoutCustomImage1.class));
                break;
            default:
                finish();
        }
    }

}