package com.example.campuslife;

import com.example.campusassist.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class CampusBuildActivity extends Activity {
	private Button goBack;
	private Spinner mySpinner;
	private ImageView myImage;
	private float mx,my;
	int [] imageIds=new int[]{
		R.drawable.jiaotong,R.drawable.jiaoqiaoxiaoqu,
		R.drawable.mailuxiaoqu,R.drawable.fenglinxiaoqu};
	String[] xiaoqu=new String[]{"交通示意图","蛟桥校区","麦庐校区","枫林校区"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.campus_build);
		goBack = (Button)findViewById(R.id.goBack);
		myImage=(ImageView)findViewById(R.id.myImage);
        goBack.setOnClickListener(new Button.OnClickListener(){            
			public void onClick(View v){                
                Intent intent = new Intent (CampusBuildActivity.this,CampusLifeActivity.class);
                startActivity(intent);
                finish();
            }  
        });  	
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,xiaoqu);
		mySpinner = (Spinner)findViewById(R.id.spinner);
		mySpinner.setAdapter(adapter);
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				myImage.setImageResource(imageIds[position]);				
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				myImage.setImageResource(imageIds[0]);				
			}			
		});	
		myImage.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				float curX,curY;
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					mx=event.getX();
					my=event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					curX=event.getX();
					curY=event.getY();
					myImage.scrollBy((int)(mx-curX), (int)(my-curY));
					mx=curX;
					my=curY;
					break;
				case MotionEvent.ACTION_UP:
					curX=event.getX();
					curY=event.getY();
					myImage.scrollBy((int)(mx-curX), (int)(my-curY));
					break;

				default:
					break;
				}
				return true;
			}
		});
	}

}
