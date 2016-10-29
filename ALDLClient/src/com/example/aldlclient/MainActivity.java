package com.example.aldlclient;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText name,author;
	private Button getData;
	protected Object songBinder;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData=(Button)findViewById(R.id.getData);
		name=(EditText)findViewById(R.id.name);
		author=(EditText)findViewById(R.id.author);
		final Intent intent=new Intent();
		intent.setAction("com.example.aldlclient.AIDLServer");
		bindService(intent,conn,Service.BIND_AUTO_CREATE);
		getData.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				try{
					name.setText(((Song) songBinder).getName());
					author.setText(((Song) songBinder).getAuthor());
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
	}
       private ServiceConnection conn=new ServiceConnection(){
    	   public void onSerciceDisconnected (ComponentName name){
    		   songBinder=null;
    	   }
    	   public void onServiceConnected (ComponentName name, IBinder service){
    		   songBinder=Song.Stub.asInterface(service);
    	   }
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO 自动生成的方法存根
			
		}
       };
       protected void onDestroy(){
    	   super.onDestroy();
    	   unbindService(conn);
       };
}
