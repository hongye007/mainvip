package com.zwy.demo1;

/**
 * 登陆界面
 * 短信注册验证的开始界面
 * 
 * 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

import com.zwy.login.ForgetPassword;

public class MainActivity extends Activity {
	private Button log_btn;
	private Button logn_tishi_text;
	private Button forget_passwd;
	// 短信注册，随机产生头像
	private static final String[] AVATARS = {
			"http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
			"http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
			"http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
			"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
			"http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
			"http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
			"http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg",
			"http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
			"http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
			"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
			"http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg",
			"http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg" };
	private TextView tv1;

	private EditText login_user_edit;
	private EditText login_passwd_edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		log_btn = (Button) findViewById(R.id.login_login_btn);
		logn_tishi_text = (Button) findViewById(R.id.logn_tishi_text);
		forget_passwd = (Button) findViewById(R.id.forget_passwd);
		login_user_edit = (EditText) findViewById(R.id.login_user_edit);
		login_passwd_edit = (EditText) findViewById(R.id.login_passwd_edit);

		log_btn.setOnClickListener(new MyOnClickListener());
		logn_tishi_text.setOnClickListener(new MyOnClickListener());
		forget_passwd.setOnClickListener(new MyOnClickListener());
	}

	public class MyOnClickListener implements OnClickListener {

		Intent intent = new Intent();

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_login_btn:
				intent.setClass(MainActivity.this, MainView.class);
				MainActivity.this.startActivity(intent);

				break;

			case R.id.logn_tishi_text:
				// 初始化短信验证组件 填写public Key  和  private Key
				SMSSDK.initSDK(MainActivity.this, "7265c14450e0",
						"2c66a6cdf15b9391f3ed34d838f55dbd");
				// 打开注册页面
				RegisterPage registerPage = new RegisterPage();
				// 注册回调函数
				registerPage.setRegisterCallback(new EventHandler() {
					public void afterEvent(int event, int result, Object data) {
						// 解析注册结果
						if (result == SMSSDK.RESULT_COMPLETE) {
							@SuppressWarnings("unchecked")
							HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
							String country = (String) phoneMap.get("country");
							String phone = (String) phoneMap.get("phone");
							// 提交用户信息
							registerUser(country, phone);
							// 短息验证成功跳转
							Intent intent = new Intent();
							intent.setClass(MainActivity.this,
									com.zwy.login.Sign.class);
							intent.putExtra("phone", phone);
							MainActivity.this.startActivity(intent);
							MainActivity.this.finish();
						}
					}
				});
				//显示验证界面
				registerPage.show(MainActivity.this);

				break;
			case R.id.forget_passwd:
				intent.setClass(MainActivity.this, ForgetPassword.class);
				MainActivity.this.startActivity(intent);
				break;

			}

		}

	}

	// 提交用户信息
	private void registerUser(String country, String phone) {
		Random rnd = new Random();
		int id = Math.abs(rnd.nextInt());
		String uid = String.valueOf(id);
		String nickName = "SmsSDK_User_" + uid;
		String avatar = AVATARS[id % 12];
		SMSSDK.submitUserInfo(uid, nickName, avatar, country, phone);
	}
}
