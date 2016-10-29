package com.example.readothersharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences accessPreferences,loginPreferences;
		Context appContext=null;
		try{
			appContext=createPackageContext("com.example.readothersharedpreferences",
					Context.CONTEXT_IGNORE_SECURITY);
		}catch(Exception e){
			e.printStackTrace();
		}
		accessPreferences=appContext.getSharedPreferences("access", Context.MODE_WORLD_READABLE);
		int count=accessPreferences.getInt("count", 0);
		loginPreferences=appContext.getSharedPreferences("login", Context.MODE_WORLD_READABLE); 
		String name=loginPreferences.getString("name", null);
		Toast.makeText(this, "你好,"+name+",SaveLoginInfo应用程序已经被使用了"+count+"次!",Toast.LENGTH_LONG).show();
		}

}
