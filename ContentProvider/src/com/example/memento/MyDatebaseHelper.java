package com.example.memento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatebaseHelper extends SQLiteOpenHelper {
	final String CREATE_TABLE_SQL=
			"create table memento_tb(_id integer primary" +
			"key autoincrement,subject,body,date)";
	public MyDatebaseHelper (Context context,String name,CursorFactory factory,int version){
		super (context,name,factory,version);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SQL);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("---------"+oldVersion+"------->"+newVersion);

	}

}
