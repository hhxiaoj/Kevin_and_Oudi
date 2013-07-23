package com.example.gxzzbphoto;





import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
	private LinearLayout wel_ly01;
	private LinearLayout wel_ly02;
	private ImageView img_view_logo;
	private Button btn01;
	
	private TextView txv01;
	private TextView txv02;
	private TextView txv03;
	private TextView txv04;
	
	public int screenW;
	public int screenH;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//fullLandScapeScreen();
		
		wel_ly01 = (LinearLayout)findViewById(R.id.wel_ly01);
		getScreen();
		md_image_view();
		
		wel_ly02 = (LinearLayout)findViewById(R.id.wel_ly02);
		md_texview();
		
		btn01 = (Button)findViewById(R.id.btn01);
		btn01.setOnClickListener(new Myevent());
		
	}
	class Myevent implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,
					Activity_index.class);
			MainActivity.this.startActivity(intent);
		}

	}
	
	
	private void md_image_view() {
		int imageview_height;
		int imageview_top;

		imageview_height = (int) (screenH * 0.25);
		imageview_top = (int) (screenH * 0.15);

		img_view_logo = new ImageView(this);
		img_view_logo.setImageDrawable(getResources().getDrawable(
				R.drawable.welcome_logo));

		img_view_logo.setAdjustViewBounds(true);
		img_view_logo.setMaxHeight(imageview_height);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		img_view_logo.setLayoutParams(params);
		params.setMargins(0, imageview_top, 0, 0);
		wel_ly01.addView(img_view_logo);

	}
	
	public void getScreen() {
		WindowManager windowM = getWindowManager();
		Display display = windowM.getDefaultDisplay();

		screenH = display.getHeight();
		screenW = display.getWidth();

	}
	/**
	 * 设置全屏及横屏显示
	 */
	private void fullLandScapeScreen() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
	private void md_texview() {

//		int textview_top;
//
//		textview_top = (int) (screenH * 0.07);

		txv01 = new TextView(this);
		txv02 = new TextView(this);
		txv03 = new TextView(this);
		txv04 = new TextView(this);

		txv01.setText(R.string.textvs1);
		txv02.setText(R.string.textvs2);
		txv03.setText(R.string.textvs3);
		txv04.setText(R.string.textvs4);

		LinearLayout.LayoutParams params_text_view = new LinearLayout.LayoutParams(
				android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
				android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);

//		txv01.setLayoutParams(params_text_view);
//
//		params_text_view.setMargins(0, textview_top, 0, 0);

		txv01.setGravity(Gravity.CENTER);
		txv02.setGravity(Gravity.CENTER);
		txv03.setGravity(Gravity.CENTER);
		txv04.setGravity(Gravity.CENTER);
		wel_ly02.addView(txv01);
		wel_ly02.addView(txv02);
		wel_ly02.addView(txv03);
		wel_ly02.addView(txv04);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
