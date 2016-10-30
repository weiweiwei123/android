package com.example.campusassist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private Button phoneAssist,trafficAssist,campusLife,scenery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		phoneAssist=(Button)findViewById(R.id.phoneAssist);
		trafficAssist=(Button)findViewById(R.id.trafficAssist);
		campusLife=(Button)findViewById(R.id.campusLife);
		scenery=(Button)findViewById(R.id.scenery);
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		phoneAssist.setOnClickListener(myOnClickListener);
		trafficAssist.setOnClickListener(myOnClickListener);
		campusLife.setOnClickListener(myOnClickListener);
		scenery.setOnClickListener(myOnClickListener);
	}
	public class MyOnClickListener implements OnClickListener{
		Intent intent=null;
		public void onClick(View v){
			switch(v.getId()){
			case R.id.phoneAssis
		       intent=new Intent(MainActivity.this,PhoneListActivity.class);
				    break;
		case R.id.trafficAssist:
			intent=new Intent(MainActivity.this,chuxingxinxiActivity.class);
			break;
		case R.id.compusList:
			intent=new Intent(MainActivity.this,CampusLifeActivity.class);
			break;
		case R.id.scenery:
			intent=new Intent(MainActivity.this,SceneryActivity.class);
			break;
			default:break;
		}
			startActivity(intent);
	}
	}
}
