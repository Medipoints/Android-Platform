package database;





import java.util.ArrayList;
import java.util.List;

import tabviewadpt.ListDoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Datahelper {
	
	private Context c;
	private SQLiteDatabase db;
	public Datahelper(Context c){
		this.c=c;
		Db_helper db_helper=new Db_helper(this.c);
		this.db=db_helper.getWritableDatabase();
	}

	public void insert(String name,String surname,String education,String specialization,Float experience,Float
			latitiude,Float longitude,String address){
		ContentValues cv = new ContentValues();
		cv.put(Db_helper.d_name,name);
		cv.put(Db_helper.d_surname,surname);
		cv.put(Db_helper.d_edu,education);
		cv.put(Db_helper.d_spec,specialization);
		
		cv.put(Db_helper.d_exp,experience);
		cv.put(Db_helper.d_lat,latitiude);
		cv.put(Db_helper.d_long,longitude);
		cv.put(Db_helper.d_address,address);
		db.insert(Db_helper.tab_name, null, cv);
		
	}
	
	public ArrayList<String> showall(){
		
		ArrayList<String> arrlist=new ArrayList<String>();
		String n=new String();
		final Cursor cu=db.rawQuery("SELECT * FROM Doc_details;",null);
		
		if(cu!=null)
		{
			if(cu.moveToFirst())
			 {
				 do
				 {
					   n=cu.getString(cu.getColumnIndex("name"));
					   arrlist.add(n);
									 
				 }
				 while(cu.moveToNext());
			 }
					
		}
		
		return arrlist;
	}

	
public ArrayList<String> getLat(){
		
		ArrayList<String> arrlist=new ArrayList<String>();
		String n=new String();
		final Cursor cu=db.rawQuery("SELECT * FROM Doc_details;",null);
		
		if(cu!=null)
		{
			if(cu.moveToFirst())
			 {
				 do
				 {
					   n=cu.getString(cu.getColumnIndex("latitude"));
					   arrlist.add(n);
									 
				 }
				 while(cu.moveToNext());
			 }
					
		}
		
		return arrlist;
	}
	

public ArrayList<String> getLong(){
	
	ArrayList<String> arrlist=new ArrayList<String>();
	String n=new String();
	final Cursor cu=db.rawQuery("SELECT * FROM Doc_details;",null);
	
	if(cu!=null)
	{
		if(cu.moveToFirst())
		 {
			 do
			 {
				   n=cu.getString(cu.getColumnIndex("longitude"));
				   arrlist.add(n);
								 
			 }
			 while(cu.moveToNext());
		 }
				
	}
	
	return arrlist;
}
	
	
}
