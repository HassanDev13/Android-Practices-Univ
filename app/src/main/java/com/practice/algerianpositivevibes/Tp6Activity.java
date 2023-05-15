package com.practice.algerianpositivevibes;

import android.content.res.TypedArray;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.algerianpositivevibes.db.GestionBDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tp6Activity extends AppCompatActivity {
    private String etatAvanc;
    private Editable deadl;
    private Editable taskName;
    private String prio;
    TypedArray etatVals;
    TypedArray prioVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp6);

        // Supprimer (Réinitialise) la BDD à chaque lancement de l'application
        this.deleteDatabase("MaBDD");
        // Récupére les view déclarées dans l'interface (fichier layout xml)
        Button addBout = (Button) findViewById(R.id.button2);
        Button viewBout = (Button) findViewById(R.id.button4);
        Button delBout = (Button) findViewById(R.id.button3);
        EditText nomEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText dateEditText = (EditText) findViewById(R.id.editTextDate2);
        ListView affichageLV = (ListView) findViewById(R.id.listView);
        Spinner prioSpinn = (Spinner) findViewById(R.id.spinner);
        Spinner etatSpinn = (Spinner) findViewById(R.id.spinner2);

        etatVals = getResources().obtainTypedArray(R.array.etat);
        prioVals = getResources().obtainTypedArray(R.array.priorite);

        GestionBDD control = new GestionBDD(Tp6Activity.this);

        addBout.setOnClickListener(v -> {

            if (!(nomEditText.getText().toString()).equals("") && !(dateEditText.getText().toString()).equals("")) {

                taskName = nomEditText.getText();

                deadl = dateEditText.getText();

                etatAvanc = etatVals.getString(etatSpinn.getSelectedItemPosition());
                etatSpinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        etatAvanc = etatVals.getString(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
// Récupérer la priorité
                prio = prioVals.getString(prioSpinn.getSelectedItemPosition());
                prioSpinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        etatAvanc = prioVals.getString(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
// Deuxième étape appeler la méthode insert (il est nécessaire de convertir deadl en un objet Date):
                try {
                    Date deadDateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(deadl.toString());
                    long id = control.insererTache(taskName, prio, deadDateFormat, etatAvanc);
                    Toast.makeText(Tp6Activity.this, "L'id de la tâche est = " + id, Toast.LENGTH_LONG).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
// Si il manque des informations concernant la tâche à ajouter dans la BDD
            else {
                Toast.makeText(Tp6Activity.this, "Veuillez saisir les champs manquants ", Toast.LENGTH_SHORT).show();
            }
        });
// Bouton Afficher les tâches disponibles dans la BDD
        viewBout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Appelet la méthode obtenirTache ensuite récupérer les lignes du cursseur retourné
                Cursor cur = control.obtenirTache();
                String[] lignesLues = new String[cur.getCount()];
                if (cur.getCount() > 0) {
                    for (int i = 0; i < cur.getCount(); i++) {
                        cur.moveToNext();
                        int id = cur.getInt(0);
                        String nom = cur.getString(1);
                        String prio = cur.getString(2);
                        String etat = cur.getString(3);
                        String dead = cur.getString(4);
                        lignesLues[i] = id + "---" + nom + "---" + prio + "---" + etat + "--- " + dead + "\n ";
                    }
                    cur.close();
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tp6Activity.this, android.R.layout.simple_list_item_1, lignesLues);
                    affichageLV.setAdapter(adapter);
                }
            }
        });
// Bouton supprimer les tâches réalisées depuis la BDD
        delBout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.supprimerTache("Done");
            }
        });
    }
}