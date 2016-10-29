package com.example.eventtransfertest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyButton myButton=(MyButton)findViewById(R.id.myBtn);
		myButton.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v,MotionEvent event){
				System.out.println("监听器中的触摸世间触发了！");
				return false;
			}
		});
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("MainActivity中的触摸世间触发了！");
		return false;
	}

}
