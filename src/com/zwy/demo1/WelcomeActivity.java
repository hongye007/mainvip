package com.zwy.demo1;


/**
 * 
 * 
 * 欢迎界面
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		//定义一个计时
		Handler handler = new Handler();
		handler.postDelayed(new Loading(), 1000);
		
	}
	class Loading implements Runnable{
		@Override
		public void run() {
		// TODO Auto-generated method stub
		startActivity(new Intent(getApplication(),MainActivity.class));
		WelcomeActivity.this.finish();
		}
		}

}
