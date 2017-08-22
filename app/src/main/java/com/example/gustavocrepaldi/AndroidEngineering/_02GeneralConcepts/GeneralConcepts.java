package com.example.gustavocrepaldi.AndroidEngineering._02GeneralConcepts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gustavocrepaldi.AndroidEngineering.R;

/**
 * Created by Gustavo Crepaldi on 31/05/2017.
 */

public class GeneralConcepts extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalconcepts_main);

        Button btGeneralConceptToast = (Button) findViewById(R.id.btGeneralConceptToast);
        btGeneralConceptToast.setOnClickListener(onClickToast());
    }

    private View.OnClickListener onClickToast() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "General Concepts is about File System, AndroidManifest, Resources Folder, " +
                        "R Class (Dynamic and Static Assignment), Gradle and LogCat ",Toast.LENGTH_LONG).show();
            }
        };
    }

    private Context getContext() {
        return this;
    }

}
