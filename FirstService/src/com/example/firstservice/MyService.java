package com.example.firstservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	private static final String TAG="MyService";
	private boolean quit;
	public IBinder onBind(Intent arg0){
		Log.i(TAG,"MyService onBind invoked!");
		return null;
	}
	public void onCreate(){
		Log.i(TAG,"MyService onCreate invoked!");
		super.onCreate();
	}
	public void onDestroy(){
		Log.i(TAG,"MyService onDestroy invoked!");
		super.onDestroy();
		this.quit=true;
	}
	public int onStartCommand(Intent intent,int flags,int startId){
		Log.i(TAG,"MyService onStartCommand invoked!");
		return super.onStartCommand(intent, flags, startId);
	}
}
