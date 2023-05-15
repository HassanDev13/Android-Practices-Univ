package com.practice.algerianpositivevibes.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionBDD {
    private Context contexte;
    BDDHelper instHelper;
    // Constructeur
    public GestionBDD(Context context) {
        this.contexte = context;
        instHelper = new BDDHelper(contexte);
    }
    ////////////////////////////INSERT////////////////////////////////
    public long insererTache(Editable nom, String prio, Date date, String etat) {
// Récupérer la base de données SQLite puis appeller sa méthode insert
        SQLiteDatabase bdd = instHelper.getWritableDatabase();
        ContentValues ligne = new ContentValues();
// Attribuer les valeurs (nom, prio, date, etat) à « ligne » ????????

        ligne.put(BDDHelper.NomTask, nom.toString());
        ligne.put(BDDHelper.PrioTask, prio);
        ligne.put(BDDHelper.DeadTask, String.valueOf(date));
        ligne.put(BDDHelper.EtatAvancementTask, etat);
        long id = bdd.insert(BDDHelper.NOM_TABLE, null, ligne);
        Log.i("*****", "L'id de la tâche insérée est = " + Integer.toString((int) id));
        return id;
    }
    ////////////////////////////DELETE////////////////////////////////
// Supprimer les tâches dont leur état d'avancement = condition (DONE)
    public int supprimerTache(String condition) {
// Récupérer la base de données SQLite puis appeller sa méthode delete
        SQLiteDatabase bdd = instHelper.getWritableDatabase();
        String[] tasksupp = {condition};
        int ret = bdd.delete(BDDHelper.NOM_TABLE, BDDHelper.EtatAvancementTask + "=?",
                tasksupp);

        Log.i("*****", "Nombre de tâches supprimées = " + Integer.toString((int) ret));
        return ret;
    }
    //////////////////////////SELECT////////////////////////////////
    public Cursor obtenirTache() {
// Récupérer la base de données SQLite puis appeller sa méthode query????????????????

        // Récupérer la base de données SQLite puis appeler sa méthode query
        SQLiteDatabase bdd = instHelper.getReadableDatabase();
        String[] colonnes = {
                BDDHelper.ID,
                BDDHelper.NomTask,
                BDDHelper.PrioTask,
                BDDHelper.DeadTask,
                BDDHelper.EtatAvancementTask
        };
        return bdd.query(BDDHelper.NOM_TABLE, colonnes, null, null, null, null, null);

    }
    // Formater la date en chaîne de caractères
    private String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
