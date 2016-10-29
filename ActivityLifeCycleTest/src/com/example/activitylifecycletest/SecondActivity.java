package com.example.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent(SecondActivity.this,MainActivity.class);
				startActivity(intent);	
			}
		});
		System.out.println("SecondActivity's onCreate");	
	}
	   protected void onStart(){
		   super.onStart();
		   System.out.println("SecondActivity's onStart");
	   }
	   protected void onRestart(){
		   super.onStart();
		   System.out.println("SecondActivity's onRestart");
	   }
	   protected void onResume(){
		   super.onStart();
		   System.out.println("SecondActivity's onResume");
	   }
	   protected void onStop(){
		   super.onStart();
		   System.out.println("SecondActivity's onStop");
	   }
	   protected void onDestroy(){
		   super.onStart();
		   System.out.println("SecondActivity's onDestroy");
	   }
	   protected void onPause(){
		   super.onStart();
		   System.out.println("SecondActivity's onPause");
	   }
			
		
	}


