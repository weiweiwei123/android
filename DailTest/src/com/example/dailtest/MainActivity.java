package com.example.dailtest;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText editText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText=(EditText)findViewById(R.id.num);
		Button mybtn=(Button)findViewById(R.id.mybtn);
		mybtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Uri uri=Uri.parse("tel:"+editText.getText().toString());
				Intent intent=new Intent(Intent.ACTION_CALL,uri);
				MainActivity.this.startActivity(intent);
			}
		});
	}
}
	
