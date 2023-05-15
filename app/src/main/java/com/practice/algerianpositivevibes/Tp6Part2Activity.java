package com.practice.algerianpositivevibes;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.algerianpositivevibes.db.GestionBDD;

import java.util.ArrayList;

public class Tp6Part2Activity extends AppCompatActivity {
    ListView lvAffichage;
    GestionBDD control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp6_part2);
        control = new GestionBDD(Tp6Part2Activity.this);
        lvAffichage = (ListView) findViewById(R.id.listView);
        Button bout = (Button) findViewById(R.id.button);

        bout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = getDataFromBDD();
                displayGotData(cur);
            }
        });
    }

    private Cursor getDataFromBDD() {
        Cursor cur = control.obtenirTache();
        return cur;
    }


    private void displayGotData(Cursor cur) {
        ArrayList<String> lignesLues = new ArrayList<String>(cur.getCount());
        if (cur.moveToFirst()) {
            while (!cur.isAfterLast()) {
                int id = cur.getColumnIndex("_id");
                int nom = cur.getColumnIndex("Nom");
                lignesLues.add(cur.getString(id) + "-" + cur.getString(nom) + "\n");
                cur.moveToNext();
            }
            cur.close(); // fermer le cursor
//Afficher le résultat sur un ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tp6Part2Activity.this, android.R.layout.simple_list_item_1, lignesLues);
            lvAffichage.setAdapter(adapter);
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tp6Part2Activity.this,
                    android.R.layout.simple_list_item_1, new String[]{"La BDD des tâches est vide"});
            lvAffichage.setAdapter(adapter);
        }
    }

}