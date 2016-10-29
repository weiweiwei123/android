package com.example.handlertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView myText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myText=(TextView)findViewById(R.id.myText);
		myText.setText("生成的随机数为；"+Math.random());
		final Handler myHandler = new Handler(){
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				if(msg.what==0x12){
					myText.setText("生成的随机数为：\n"+Math.random());
				}
			}
		};
		new Thread(new Runnable(){
			public void run(){
				try{
					while(true){
						Thread.sleep(300);
						Message msg=new Message();
						msg.what=0x12;
						myHandler.sendMessage(msg);
					}
					}catch(Exception e){
						e.printStackTrace();
					
				}
			};
		}).start();
	}

		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
