package com.example.gxzzbphoto;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class Activity_Upload extends Activity {

	private ImageView image_upload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);

		image_upload = (ImageView) findViewById(R.id.image_upload);

		Bundle extras = getIntent().getExtras();

		image_upload.setImageBitmap(BitmapFactory.decodeFile(extras
				.getString("picturePath")));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__upload, menu);
		return true;
	}

}
