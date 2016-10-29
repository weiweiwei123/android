package com.example.texteditor;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnClickListener {
	 private Button red,green,blue,bold,italic,moren,bigger, smaller;
	 private TextView testText;
	 private EditText content;
	 private int flag=0;
	 

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testText=(TextView)findViewById(R.id.testText);
		testText.setTypeface(Typeface.DEFAULT);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		bigger = (Button) findViewById(R.id.bigger);
		smaller = (Button) findViewById(R.id.smaller);
		bold=(Button)findViewById(R.id.bold);
		italic=(Button)findViewById(R.id.italic);
		moren=(Button)findViewById(R.id.moren);
	    ColorListner myColorListner = new ColorListner();
	    red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		SizeListener mysizeListener=new SizeListener(testText);
		bigger.setOnClickListener(mysizeListener);
		smaller.setOnClickListener(mysizeListener);
		bold.setOnClickListener(this);
		italic.setOnClickListener(this);
		moren.setOnClickListener(this);
		content = (EditText) findViewById(R.id.content);
		content.setOnEditorActionListener(new OnEditorActionListener(){
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			testText.setText(content.getText().toString());
			return false;}
		});
	}
	    class ColorListner implements OnClickListener{
	    	public void onClick(View v){
	    		switch(v.getId()){
	    		case R.id.red:
	    			 testText.setTextColor(Color.RED);break;
	    		case R.id.green:
	    			 testText.setTextColor(Color.GREEN);break;
	    		case R.id.blue:
	    			 testText.setTextColor(Color.BLUE);break;
	    			 default:break;  			    		    			    		   		    	
	    }
	    	
	    }
	  
}
             public void onClick(View v){
            	Typeface tf=testText.getTypeface();
            	switch(v.getId()){
            	case R.id.italic:
            		if(flag==2||flag==3){
            			testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
            			flag=3;
            		}else{
            			testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
            			flag=1;} break;
            	case R.id.bold:
            		if(flag==2||flag==3){
            			testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
            			flag=3;
            		}else{
            			testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
            			flag=2;} break;
            	case R.id.moren:
            		 testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
            		   flag=0;
            		   break;
            		   default:break;
            	
            			
            			
            		}
            		}
            	}
             

            	
	


