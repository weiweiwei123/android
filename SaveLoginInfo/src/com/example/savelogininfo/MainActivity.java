package com.example.savelogininfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected Editor loginEditor;
	protected TextView userInfo;
	protected TextView name;

	public void onCreate(Bundle savedInstanceState, TextView userInfo) {
		super.onCreate(savedInstanceState);
		SharedPreferences loginPreferences = getSharedPreferences ("login",Context.MODE_PRIVATE);
		SharedPreferences accessPreferences = getSharedPreferences ("accwss",Context.MODE_WORLD_READABLE);
		int count=accessPreferences.getInt("count",1);
			Toast.makeText(MainActivity.this,"欢迎您，这是第"+count+"次访问！",
			Toast.LENGTH_LONG).show();
			Editor loginEditor = loginPreferences.edit();
			Editor accessEditor = accessPreferences.edit();
			accessEditor.putInt("count",++count);
			accessEditor.commit();
			String userName = loginPreferences.getString("name",null);
			String userPsd = loginPreferences.getString("psd",null);
			boolean isSavePsd = loginPreferences.getBoolean("isSavePsd",false);
			boolean isAutoLogin = loginPreferences.getBoolean("isAutoLogin", false);
			 if(isAutoLogin){
				 this.setContentView(R.layout.activity_main);
				 userInfo=(TextView)findViewById(R.id.userInfo);
				 userInfo.setText("欢迎您:"+userName+",登陆成功!");
			 }else{
				 loadActivity();
			 }
	}

	public void loadActivity() {
		this.setContentView(R.layout.activity_main);
		Button login = (Button)findViewById(R.id.login);
		final CheckBox rememberPsdBox = (CheckBox) findViewById(R.id.rememberPsd);
		final CheckBox autoLoginBox = (CheckBox) findViewById(R.id.autoLogin);
		name=(EditText)findViewById(R.id.name);
		final TextView psd = (EditText)findViewById(R.id.psd);
		boolean isSavePsd = false;
		if(isSavePsd){
			Object userPsd = null;
			psd.setText((CharSequence) userPsd);
			CharSequence userName = null;
			name.setText(userName);
			rememberPsdBox.setChecked(true);
		}
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				loginEditor.putString("name",name.getText().toString());
				loginEditor.putString("psd",psd.getText().toString());
				loginEditor.putBoolean("isSavePsd",rememberPsdBox.isChecked());
				loginEditor.putBoolean("isAutoLogin",autoLoginBox.isChecked());
				loginEditor.commit();
				MainActivity.this.setContentView(R.layout.activity_welcome);
				userInfo=(TextView)findViewById(R.id.userInfo);
				userInfo.setText("欢迎您：" + name.getText().toString() + ",登陆成功！");
			}
		});			
	}
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			loginEditor.putBoolean("isAutoLogin", false);
			loginEditor.commit();
			onCreate(null);
			break;
		case R.id.exit:
			this.finish();
			break;
		default:
			break;
		}
		return true;
	}

}
