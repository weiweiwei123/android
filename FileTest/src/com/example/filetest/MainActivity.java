package com.example.filetest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button read,write;
	private EditText readText,writeText;
	private String fileName="content.txt";
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		read=(Button)findViewById(R.id.read);
		write=(Button)findViewById(R.id.write);
		readText=(EditText)findViewById(R.id.readText);
		writeText=(EditText)findViewById(R.id.writeText);
		read.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				readText.setText(read());
			}
		});
		write.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				write(writeText.getText().toString());
	}
		});
	}
	public void write(String content){
		
		try{
			FileOutputStream fos=openFileOutput(fileName,Context.MODE_APPEND);
			PrintStream ps=new PrintStream(fos);
			ps.print(content);
			ps.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String read(){
		StringBuilder sbBuilder=new StringBuilder("");
		try{
			FileInputStream is=openFileInput(fileName);
			byte[]buffer=new byte[64];
			int hasRead;
			while((hasRead=is.read(buffer))!=-1){
				sbBuilder.append(new String(buffer,0,hasRead));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sbBuilder.toString();
	}

}
