package com.app.obedtandadjaja.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by obedtandadjaja on 8/26/15.
 */
public class TranslationDataSource {

    private SQLiteDatabase dictionary_long_database;
    private SQLiteDatabase dictionary_brief_database;
    private SQLiteDatabase dictionary_english_database;
    private Context context;

    public TranslationDataSource(Context context)
    {
        this.context = context;
        this.dictionary_long_database = new DataBaseHelper(context, "dictionary_long.sqlite").openDataBase();
        this.dictionary_brief_database = new DataBaseHelper(context, "dictionary_brief.sqlite").openDataBase();
        this.dictionary_english_database = new DataBaseHelper(context, "dictionary_english.sqlite").openDataBase();
    }

    public ArrayList<Translation> getEngIndTranslationLong(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from ENG_IND where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEnKrTranslation(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from EN_KR where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEnFrTranslation(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from EN_FR where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEnSpTranslation(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from EN_SP where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEnChTranslation(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from EN_CH where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEngIndTranslationBrief(String word)
    {
        Cursor cursor = dictionary_brief_database.rawQuery("select translation from ENG_IND where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getIndEngTranslationLong(String word)
    {
        Cursor cursor = dictionary_long_database.rawQuery("select translation from IND_ENG where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getIndEngTranslationBrief(String word)
    {
        Cursor cursor = dictionary_brief_database.rawQuery("select translation from IND_ENG where lower(word) = lower(\""+word+"\");", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }

        return translation_array;
    }

    public ArrayList<Translation> getEngEngTranslation(String word)
    {
        Cursor cursor = dictionary_english_database.rawQuery("select Definition from DEFINITIONS where wordID = (select wordID from WORDS where lower(word) = lower(\""+word+"\"));", null);
        cursor.moveToFirst();
        ArrayList<Translation> translation_array = new ArrayList<Translation>();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            translation_array.add(new Translation(word, cursor.getString(0)));
            cursor.moveToNext();
        }
        return translation_array;
    }

}
