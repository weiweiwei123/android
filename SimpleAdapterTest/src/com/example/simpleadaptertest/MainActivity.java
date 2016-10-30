package com.example.simpleadaptertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
String[] names=new String[]{"��������","�\��","Ƽˮ���"};
String[] infos=new String[]{"����ǩ����ĥ����","����ǩ����ƴ����","����ǩ�����������ߵ����У��������ߵ����£�"};
int[] imageids=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3};
List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
 for(int i=0;i<names.length;i++){
    	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("img",imageids[i]);
        	map.put("title",names[i]);
        	map.put("info",infos[i]);
        	listItems.add(map);
        }
SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.activity_main,
      new String[]{"title","info","img"},
      new int[]{R.id.title,R.id.info,R.id.img});
	setListAdapter(simpleAdapter);
    }
	private void setListAdapter(SimpleAdapter simpleAdapter) {	
	}
}

