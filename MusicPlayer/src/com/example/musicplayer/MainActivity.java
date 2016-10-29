package com.example.musicplayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.musicplayer.MainActivity.ActivityReceiver;

public class MainActivity<ActivityReceiver> extends Activity implements OnClickListener{
    TextView title,author;
    ImageButton play,stop;
    ActivityReceiver activityReceiver;
    public static final String CONTROL="com.example.musicplayer.control";
    public static final String UPDATE="com.example.musicplayer.update";
    int statys=0x11;
    String[]titleStrs=new String[]{"老男孩","春天里","在路上"};
    String[]authorStrs=new String[]{"筷子兄弟","汪峰","刘欢"};
	public int status;    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		play=(ImageButton)this.findViewById(R.id.play);
		stop=(ImageButton)this.findViewById(R.id.stop);
		title=(TextView)this.findViewById(R.id.title);
		author=(TextView)this.findViewById(R.id.author);
		play.setOnClickListener(this);
		stop.setOnClickListener(this);
		activityReceiver=new ActivityReceiver();
		IntentFilter filter=new IntentFilter(UPDATE);
		registerReceiver(activityReceiver,filter);
		Intent intent=new Intent(this,MusicService.class);
		startService(intent);
	}
	public class ActivityReceiver extends BroadcastReceiver{
		public void onReceive(Context context, Intent intent) {
			int update=intent.getIntExtra("update", -1);
			int current=intent.getIntExtra("current", -1);
			if(current >=0){
				title.setText(titleStrs[current]);
				author.setText(titleStrs[current]);
			}
			switch(update){
			case 0x11:
				play.setImageResource(R.drawable.play);
				status=0x11;break;
			case 0x12:
				play.setImageResource(R.drawable.pause);
				status=0x12;break;
			case 0x13:
				play.setImageResource(R.drawable.play);
				status=0x13;break;
			}
		}
	}
	public void onClick(View source){
		Intent intent=new Intent(CONTROL);
		switch(source.getId()){
		case R.id.play:
			intent.putExtra("control", 1);
			break;
		case R.id.stop:
			intent.putExtra("control", 2);
			break;
		}
		sendBroadcast(intent);
	}

}
