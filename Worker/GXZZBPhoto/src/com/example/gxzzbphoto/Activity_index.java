package com.example.gxzzbphoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Activity_index extends Activity {
	private LinearLayout lilay_01;
	private LinearLayout lilay_02;
	private LinearLayout lilay_03;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);

		lilay_01 = (LinearLayout) findViewById(R.id.index_ly03_01);
		lilay_01.setClickable(true);
		lilay_01.setOnClickListener(ocl);
		lilay_01.setOnTouchListener(otl);
		
		lilay_02 = (LinearLayout) findViewById(R.id.index_ly03_02);
		lilay_02.setClickable(true);
		lilay_02.setOnClickListener(ocl02);
		lilay_02.setOnTouchListener(otl);
		
		lilay_03 = (LinearLayout) findViewById(R.id.index_ly03_03);
		lilay_03.setClickable(true);
		lilay_03.setOnClickListener(ocl03);
		lilay_03.setOnTouchListener(otl);

	}

	public OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 打开拍照程序
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
			startActivityForResult(intent, 0);
//			// 取出照片数据
//			Bundle extras = intent.getExtras(); 
//			Bitmap bitmap = (Bitmap) extras.get("data"); 
			
		}
	};
	public OnClickListener ocl02 = new OnClickListener() {

		@Override
		public void onClick(View v) {
		
			
		}
	};
	public OnClickListener ocl03 = new OnClickListener() {

		@Override
		public void onClick(View v) {
		
			
		}
	};
	public OnTouchListener otl = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				lilay_01.setBackgroundResource(R.drawable.bottom_bar_current_bg);
				lilay_02.setBackgroundResource(R.drawable.bottom_bar_current_bg);
				lilay_03.setBackgroundResource(R.drawable.bottom_bar_current_bg);
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				lilay_01.setBackgroundColor(Color.TRANSPARENT);
				lilay_02.setBackgroundColor(Color.TRANSPARENT);
				lilay_03.setBackgroundColor(Color.TRANSPARENT);
			}
			return false;
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_index, menu);
		return true;
	}

}
