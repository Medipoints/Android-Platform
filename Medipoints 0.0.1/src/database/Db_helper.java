package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Db_helper extends SQLiteOpenHelper {

	private static final String db_name="check.db";
	private static final int db_version=1;
	public static final String tab_name="Doc_details";
	public static final String d_no="doc_id";
	public static final String d_name="name";
	public static final String d_surname="surname";
	public static final String d_edu="education";
	public static final String d_spec="specialization";
	public static final String d_exp="experience";
	public static final String d_lat="latitude";
	public static final String d_long="longitude";
	public static final String d_address="address";
	
	public Db_helper(Context c) {
		// TODO Auto-generated constructor stub
		super(c,db_name,null,db_version);
	
	}
	
		
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE Doc_details (doc_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,surname TEXT,education TEXT,specialization TEXT,experience FLOAT,latitude FLOAT,longitude FLOAT,address VARCHAR2(150));");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+tab_name);
		onCreate(db);
	}

}
