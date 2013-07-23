package com.example.gxzzbphoto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
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
	private static int RESULT_LOAD_IMAGE = 2;
	private static int RESULT_LOAD_PHOTO_IMAGE = 1;

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
		lilay_02.setOnClickListener(ocl);
		lilay_02.setOnTouchListener(otl);

		lilay_03 = (LinearLayout) findViewById(R.id.index_ly03_03);
		lilay_03.setClickable(true);
		lilay_03.setOnClickListener(ocl);
		lilay_03.setOnTouchListener(otl);

	}

	public OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// 拍照
			if (v == lilay_01) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, RESULT_LOAD_PHOTO_IMAGE);
			}
			// 上传照片
			if (v == lilay_02) {
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
			// 用户
			if (v == lilay_03) {

			}

		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_PHOTO_IMAGE) {
			Bundle extras = data.getExtras();
			Bitmap bitmap =  (Bitmap) extras.get("data");

			Intent photoIntent = new Intent(Activity_index.this,
					Activity_Camera.class);
			photoIntent.putExtra("cameraPath", bitmap);

			startActivity(photoIntent);

		}

		if (requestCode == RESULT_LOAD_IMAGE) {

			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			Intent newIntent = new Intent(Activity_index.this,
					Activity_Upload.class);
			newIntent.putExtra("picturePath", picturePath);

			startActivity(newIntent);

		}

	}

	public OnTouchListener otl = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				v.setBackgroundResource(R.drawable.bottom_bar_current_bg);

			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				v.setBackgroundColor(Color.TRANSPARENT);
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
