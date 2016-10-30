package com.example.menutest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private boolean flag = false;
	TextView tView[] = new TextView[4];
	int num;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] files = new int[] { R.id.file01, R.id.file02, R.id.file03,
				R.id.file04 };
		for (int i = 0; i < tView.length; i++) {
			tView[i] = (TextView) findViewById(files[i]);
			registerForContextMenu(tView[i]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.start:
		case R.id.stop: 
			invalidateOptionsMenu();
			break;
		case R.id.exit:
			finish();
			break;
		default:
			break;
		}
		Toast.makeText(MainActivity.this, item.getTitle() + "被单击了！", 1000)
				.show();
		return true;
	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		super.onPrepareOptionsMenu(menu);
		MenuItem start = menu.findItem(R.id.start);
		MenuItem stop = menu.findItem(R.id.stop);
		start.setEnabled(flag);
		stop.setEnabled(!flag);
		flag = !flag;
		return true;
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {		
		switch (v.getId()) {
		      case R.id.file01:
			       num = 1;
			          break;
		       case R.id.file02:
			     num = 2;
			        break;
		        case R.id.file03:
			          num = 3;
			          break;
		         case R.id.file04:
			          num = 4;
			         break;
		             default:
			          break;
		        }
		menu.setHeaderTitle("文件操作");
		menu.add(0, Menu.FIRST + num * 10 + 1, 0, "发送");
		SubMenu subMenu = menu.addSubMenu(0, Menu.FIRST + num * 10 + 2, 1,
				"设置文字的颜色");
		subMenu.setHeaderTitle("The Second Level Menu");
		subMenu.add(0, Menu.FIRST + num * 100 + 21, 0, "红色");
		subMenu.add(0, Menu.FIRST + num * 100 + 22, 0, "蓝色");
		subMenu.add(0, Menu.FIRST + num * 100 + 23, 0, "绿色");
		menu.add(0, Menu.FIRST + num * 10 + 3, 2, "重命名");
		menu.add(0, Menu.FIRST + num * 10 + 4, 3, "删除");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	public boolean onContextItemSelected(MenuItem item) {
		String mesString = "你选择的是:";
		int count = item.getItemId() - Menu.FIRST;
		num = count / 10;
		if (num > 10) {
			num = num / 10;
		}
		if (item.getItemId() == (Menu.FIRST + num * 10 + 1)) {
			mesString += "发送";
		} else if (item.getItemId() == (Menu.FIRST + num * 10 + 2)) {
			mesString += "进入颜色设置界面";
		} else if (item.getItemId() == (Menu.FIRST + num * 100 + 21)) {
			tView[num - 1].setTextColor(Color.RED);			
		} else if (item.getItemId() == (Menu.FIRST + num * 100 + 22)) {
			tView[num - 1].setTextColor(Color.BLUE);			
		} else if (item.getItemId() == (Menu.FIRST + num * 100 + 23)) {
			tView[num - 1].setTextColor(Color.GREEN);			
		} else if (item.getItemId() == (Menu.FIRST + num * 10 + 3)) {
			final EditText inputname = new EditText(this);
			AlertDialog bDialog = new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.btn_star)
					.setTitle("请输入新名字")
					.setView(inputname)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									tView[num - 1].setText(inputname.getText()
											.toString());
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).create();
			bDialog.show();			
		} else if (item.getItemId() == (Menu.FIRST + num * 10 + 4)) {
			mesString += "删除";
		}
		Toast.makeText(this, mesString, Toast.LENGTH_LONG).show();
		return true;
	}
}
