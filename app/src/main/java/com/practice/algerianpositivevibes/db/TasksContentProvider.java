package com.practice.algerianpositivevibes.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TasksContentProvider extends ContentProvider {
    private SQLiteDatabase bdd;

    @Override
    public boolean onCreate() {
        // Initialize the SQLiteDatabase object
        bdd =  new BDDHelper(getContext()).getWritableDatabase();
        return bdd != null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String nomBDD = uri.getPathSegments().get(0);
        String nomTable = uri.getPathSegments().get(1);

        // Check if the request is for a specific row of the table
        String id = null;
        List<String> pathSeg = uri.getPathSegments();
        if (pathSeg.size() > 2) {
            id = uri.getLastPathSegment();
            if (selectionArgs == null) {
                selectionArgs = new String[]{id};
                selection = "_id= ?";
            } else {
                selection = selection + " AND _id=?";
                String[] tmp = new String[selectionArgs.length + 1];
                System.arraycopy(selectionArgs, 0, tmp, 0, selectionArgs.length);
                tmp[tmp.length - 1] = id;
                selectionArgs = tmp;
            }
        }

        // Get the SQLiteDatabase object and call the query method on it
        Cursor cursor = bdd.query(nomTable, projection, selection, selectionArgs, null, null, sortOrder);
        // Return the cursor
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

