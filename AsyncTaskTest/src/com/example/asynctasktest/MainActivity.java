package com.example.asynctasktest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button myBtn=null;
	private TextView myText=null;
	private ProgressBar myBar=null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myBtn=(Button)findViewById(R.id.myBtn);
		myText=(TextView)findViewById(R.id.myText);
		myBar=(ProgressBar)findViewById(R.id.myBar);
		myBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				DownTask downTask=new DownTask(myText,myBar);
				downTask.execute(100);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
