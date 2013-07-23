package com.example.gxzzbphoto;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.ImageView;

public class Activity_Camera extends Activity {

	private ImageView cameraPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		cameraPhoto = (ImageView) findViewById(R.id.camaraPhoto);
		Bitmap bmp = getIntent().getParcelableExtra("cameraPath");
		cameraPhoto.setImageBitmap(bmp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__camera, menu);
		return true;
	}

}
