package com.zwy.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zwy.demo1.R;

public class Sign extends Activity {

	private String phone;
	private EditText password;
	private EditText repassword;
	private Button btn_next;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signview);
		// 获取手机号
		Intent intent = this.getIntent();
		phone = intent.getExtras().getString("phone");
		password = (EditText) findViewById(R.id.signup_password);
		repassword = (EditText) findViewById(R.id.signup_repassword);
		btn_next = (Button) findViewById(R.id.sing_1_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (password.getText() != repassword.getText()) {
					password.setText("");
					repassword.setText("");
					Toast.makeText(Sign.this, "请输入相同密码！", Toast.LENGTH_SHORT);
				} else if (password.getText().length() < 6) {
					password.setText("");
					repassword.setText("");
					Toast.makeText(Sign.this, "密码过短！请重新输入！", Toast.LENGTH_SHORT);
				}else {
	
					
				}

			}

		});
	}
}
