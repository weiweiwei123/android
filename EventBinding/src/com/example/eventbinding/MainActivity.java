package com.example.eventbinding;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
//private Button myBtn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//myBtn=(Button)findViewById(R.id.mybtn);
		//myBtn.setOnClickListener(new OnClickListener(){
		//public void onClick(View v){
		//Toast.makeText(MainActivity.this,"�������еĴ�����",
		//Toast.LENGTH_SHORT).show();
		//}
		//});
	}
       public void clickEventHandler(View source){
    	   Toast.makeText(this, "�Զ����¼�������", Toast.LENGTH_SHORT).show();
	}

}
