package com.example.memento;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final SQLiteOpenHelper mydbHelper = null;
	private Button chooseDate, add, query;
	private EditText date, subject, body;
	private ListView result;
    private LinearLayout title;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		chooseDate.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Calendar c=Calendar.getInstance();
			 new DatePickerDialog(MainActivity.this,
		    new DatePickerDialog.OnDateSetListener(){
				 public void onDateSet(DatePicker view,int year,int month,int day){
					 date.setText(year+"-"+(month+1)+"-"+day);
				 }
			 },c.get(Calendar.YEAR),c.get(Calendar.MONTH),
			 c.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		MyOnClickListerner myOnClickListerner = new MyOnClickListerner();
		add.setOnClickListener(myOnClickListerner);
		query.setOnClickListener(myOnClickListerner);
	}
     private class MyOnClickListerner implements OnClickListener {
    	public void onClick(View v){
    		mydbHelper=new MyDatebaseHelper (MainActivity.this,"memento.db",null,1); 
    		SQLiteDatabase db=mydbHelper.getReadableDatabase();
    		String subStr = subject.getText().toString();
			String bodyStr = body.getText().toString();
			String dateStr = date.getText().toString();
			switch(v.getId()){
			case R.id.add:
				title.setVisibility(View.INVISIBLE);
				addMemento(db,subStr,bodyStr,dateStr);
				Toast.makeText(MainActivity, this, "添加备忘录成功！"),1000).show;
				result.setAdapter(null);
				break;
			case R.id.query:
				title.setVisibility(View.VISIBLE);
				Cursor cursor = queryMemento(db, subStr, bodyStr, dateStr);
				SimpleCursorAdapter resultAdapter = new SimpleCursorAdapter(
						MainActivity.this, R.layout.result, cursor,
						new String[] { "_id", "subject", "body", "date" },
						new int[] { R.id.memento_num, R.id.memento_subject,
								R.id.memento_body, R.id.memento_date });
				result.setAdapter(resultAdapter);
				break;
				default:
					break;
			}
    	}
	}
    public void addMemento(SQLiteDatabase db, String subject, String body,
			String date) {
		db.execSQL("insert into memento_tb values(null,?,?,?)", new String[] {
				subject, body, date });
		this.subject.setText("");
		this.body.setText("");
		this.date.setText("");
    }
    public Cursor queryMemento(SQLiteSQLiteDatabase db, String subject, String body,
			String date){
    	Cursor cursor=db.rawQuery("selec * from memento_tb where subject like ? and body like ? and date like ?",
				new String[] { "%" + subject + "%", "%" + body + "%",
				"%" + date + "%" });
    	return cursor;
    }
    protected void onDestroy(){
    	if(mydbHelper!=null){
    		mydbHelper.close();
    	}
    }

}
