package com.example.dialogtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button simpleDialog;
	private Button status, hobby, chooseFriend;
	private TextView statusText;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simpleDialog = (Button) findViewById(R.id.simpleDialog);
		status = (Button) findViewById(R.id.status);
		hobby = (Button) findViewById(R.id.hobby);
		chooseFriend = (Button) findViewById(R.id.chooseFriend);
		statusText = (TextView) findViewById(R.id.stastusText);
		final Builder builder = new AlertDialog.Builder(this);
		simpleDialog.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				builder.setMessage("Are you sure you want to exit?");
				builder.setCancelable(false);
				builder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(MainActivity.this, "������ȷ����",
										1000).show();
							}
						});
				builder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int which) {
								Toast.makeText(MainActivity.this, "������ȡ����",1000).show();
							}
						});
				builder.create().show();
			}
		});

		status.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final String[] items = new String[] { "����", "����", "�뿪", "æµ",	"����", "����" };
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ�����״̬");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setCancelable(false);
				builder.setSingleChoiceItems(items, 1,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								if (which == (items.length - 1)) {
									Builder myBuilder = new Builder(
											MainActivity.this);
									final EditText myInput = new EditText(
											MainActivity.this);
									myBuilder.setTitle("���������״̬");
									myBuilder.setIcon(R.drawable.ic_launcher);
									myBuilder.setView(myInput);
									myBuilder.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,int which) {
											statusText.setText("�㵱ǰ��״̬�ǣ�"+ myInput.getText().toString());
										}
									});
									myBuilder.show();
								} else {
									statusText.setText("�㵱ǰ��״̬�ǣ�"	+ items[which]);
								}
							}
						});
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int which) {
							}
						});
				builder.show();
			}
		});
		hobby.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				final String[] items = new String[] { "����", "����", "��ѧ", "����",
						"�˶�", "����" };
				builder.setTitle("��İ����У�");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setCancelable(false);
				builder.setMultiChoiceItems(items, null,
						new DialogInterface.OnMultiChoiceClickListener() {
							public void onClick(DialogInterface dialog,
									int which, boolean isChecked) {
							}
						});
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int which) {
							}
						});
				builder.show();
			}
		});
		chooseFriend.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final String[] names = new String[] { "��������", "�\��", "Ƽˮ���" };
				final String[] infos = new String[] { "����ǩ����ĥ����", "����ǩ����ƴ����",
						"����ǩ�����������ߵ����У��������ߵ����£�" };
				final int[] imageids = new int[] { R.drawable.i1, R.drawable.i2,
						R.drawable.i3 };
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("img", imageids[i]);
					map.put("title", names[i]);
					map.put("info", infos[i]);
					listItems.add(map);}
				SimpleAdapter simpleAdapter = new SimpleAdapter(
						MainActivity.this, listItems, R.layout.simple,
						new String[] { "title", "info", "img" }, new int[] {
								R.id.title, R.id.info, R.id.img });
				Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
				myBuilder.setTitle("��ѡ�����");
				myBuilder.setIcon(R.drawable.ic_launcher);
				myBuilder.setAdapter(simpleAdapter,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int which) {
									Toast.makeText(MainActivity.this,"��ѡ��ĺ����ǣ�"+names[which],1000).show();
							}
						});
				myBuilder.create().show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
