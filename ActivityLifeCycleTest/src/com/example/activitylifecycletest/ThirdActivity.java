package com.example.activitylifecycletest;
import android.app.Activity;
import android.os.Bundle;

public class ThirdActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        System.out.println("ThirdActivity's onCreate");	
	}
	   protected void onStart(){
		   super.onStart();
		   System.out.println("ThirdActivity's onStart");
	   }
	   protected void onRestart(){
		   super.onStart();
		   System.out.println("ThirdActivity's onRestart");
	   }
	   protected void onResume(){
		   super.onStart();
		   System.out.println("ThirdActivity's onResume");
	   }
	   protected void onStop(){
		   super.onStart();
		   System.out.println("ThirdActivity's onStop");
	   }
	   protected void onDestroy(){
		   super.onStart();
		   System.out.println("ThirdActivity's onDestroy");
	   }
	   protected void onPause(){
		   super.onStart();
		   System.out.println("ThirdActivity's onPause");
	   }
			
		
	}
        
        


