package com.sam_chordas.android.stockhawk.data;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.OnUpgrade;
import net.simonvt.schematic.annotation.Table;

/**
 * Created by sam_chordas on 10/5/15.
 */
@Database(version = QuoteDatabase.VERSION)
public class QuoteDatabase {
  private QuoteDatabase(){}

  public static final int VERSION = 9;

  @Table(QuoteColumns.class) public static final String QUOTES = "quotes";

    @OnUpgrade
    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("eeeeee", "aefewfcawd");
        db.execSQL("DROP TABLE IF EXISTS " + QUOTES);
    }
}
