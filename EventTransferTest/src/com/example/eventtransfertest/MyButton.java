package com.example.eventtransfertest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {

	public MyButton(Context context,AttributeSet attrs){
		super(context,attrs);}
         public boolean onTouchEvent(MotionEvent event){
        	 System.out.println("MyButton�д����¼������ˣ�");
        	 return false;
        	 
         }

}
