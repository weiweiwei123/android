package com.example.expandablelistview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	String[] type = new String[] { "我的好友", "大学同学", "亲戚朋友" };
	String[][] info = new String[][] { { "张三", "张四", "张五" }, { "李四", "李斯" },
			{ "王五", "王六", "王二", "王三" } };
	int[] groupImgs = new int[] { R.drawable.g1, R.drawable.g2, R.drawable.g3};
	int[][] imgIds = new int[][] {
			{ R.drawable.a1, R.drawable.a2, R.drawable.a3 },
			{ R.drawable.a4, R.drawable.a5, R.drawable.a6 },
			{ R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10 } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		ExpandableListView myExpandable = (ExpandableListView) findViewById(R.id.myExpandable);
		ExpandableListAdapter myAdapter = new BaseExpandableListAdapter() {

			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				return true;}
			public boolean hasStableIds() {
				return false;
			}
			private TextView getTextView() {
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT);
				TextView textView = new TextView(MainActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL);
				textView.setTextSize(20);
				textView.setPadding(30, 0, 0, 0);
				textView.setTextColor(Color.BLACK);
				return textView;}
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				LinearLayout layout = new LinearLayout(MainActivity.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				layout.setGravity(Gravity.CENTER_VERTICAL);
				ImageView groupImg=new ImageView(MainActivity.this);
				groupImg.setImageResource(groupImgs[groupPosition]);
				layout.addView(groupImg);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				layout.addView(textView);
				return layout;
			}

			public long getGroupId(int groupPosition) {

				return groupPosition;
			}

			public int getGroupCount() {
				return type.length;
			}

			public Object getGroup(int groupPosition) {
				return type[groupPosition];
			}

			public int getChildrenCount(int groupPosition) {
				return info[groupPosition].length;
			}

			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				LinearLayout layout = new LinearLayout(MainActivity.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				layout.setPadding(20, 0, 0, 0);
				ImageView itemImage = new ImageView(MainActivity.this);
				itemImage.setPadding(20, 0, 0, 0);
				itemImage
						.setImageResource(imgIds[groupPosition][childPosition]);
				layout.addView(itemImage);
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition)
						.toString());
				layout.addView(textView);
				return layout;
			  }

			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			  }

			public Object getChild(int groupPosition, int childPosition) {
				return info[groupPosition][childPosition];
			}
		};
		myExpandable.setAdapter(myAdapter);
	}
}