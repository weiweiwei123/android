package com.example.campuslife;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;

public class CampusSceneryActivity extends Activity {
	switcher.setFactory(new ViewFactory(){
	public View makeView(){
		ImageView imageView = new ImageView(CampusSceneryActivity.this);
		imageView.setBackgroundColor(0xff0000);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
			LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		return imageView;
	}
});		
   switcher.setInAnimation(AnimationUtils.loadAnimation(this,
	android.R.anim.fade_in));
    switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
	android.R.anim.fade_out));		
    BaseAdapter adapter = new BaseAdapter(){			
	public int getCount(){
		return Integer.MAX_VALUE;
	}			
	public Object getItem(int position){
		return position;
	}
	public long getItemId(int position){
		return position;
	}
	public View getView(int position, View convertView, ViewGroup parent){
		
		ImageView imageView = new ImageView(CampusSceneryActivity.this);
		imageView
			.setImageResource(images[position % images.length]);
		
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
		TypedArray typedArray = obtainStyledAttributes(
			R.styleable.Gallery);
		imageView.setBackgroundResource(typedArray.getResourceId(
			R.styleable.Gallery_android_galleryItemBackground, 0));
		return imageView;
	}
};
gallery.setAdapter(adapter);
gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
	public void onItemSelected(AdapterView<?> arg0, View arg1,
			int position, long id) {
		switcher.setImageResource(images[position%images.length]);
		
	}
	public void onNothingSelected(AdapterView<?> arg0) {				
		
	}			
});
}
}


