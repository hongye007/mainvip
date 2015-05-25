package com.zwy.demo1;


/**
 * 
 * 主界面的显示
 * 显示五个 Fragment
 */
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainView extends Activity {

	private FragmentManager fm;
	private FragmentTransaction ft;
	private Fragment_Vip fg_main_vip;
	private Fragment_At fg_main_at;
	private Fragment_Message fg_main_message;
	private Fragment_More fg_main_more;
	private Fragment_Search fg_main_search;

	private ImageButton btn_main_search;
	private ImageButton btn_main_at;
	private ImageButton btn_vip;
	private ImageButton btn_main_message;
	private ImageButton btn_main_more;
	private MyMainOnClickListener myMainOnClickListener;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainview);

		// 实例化Fragment管理器
		fm = getFragmentManager();
		// 设置默认Fragment
		setDefaultFragment();
		myMainOnClickListener = new MyMainOnClickListener();
		// 找到五个按钮控件
		btn_main_search = (ImageButton) findViewById(R.id.btn_main_search);
		btn_main_at = (ImageButton) findViewById(R.id.btn_main_at);
		btn_vip = (ImageButton) findViewById(R.id.btn_vip);
		btn_main_message = (ImageButton) findViewById(R.id.btn_main_message);
		btn_main_more = (ImageButton) findViewById(R.id.btn_main_more);

		// 五个按钮的点击事件注册
		btn_main_search.setOnClickListener(myMainOnClickListener);
		btn_main_at.setOnClickListener(myMainOnClickListener);
		btn_vip.setOnClickListener(myMainOnClickListener);
		btn_main_message.setOnClickListener(myMainOnClickListener);
		btn_main_more.setOnClickListener(myMainOnClickListener);

	}

	// 自定义按钮点击事件接口的实现  包含五个底部的导航按钮
	public class MyMainOnClickListener implements OnClickListener {

		public void onClick(View v) {
			// 实例化Fragment管理器
			ft = fm.beginTransaction();
			setFragmentHide(ft);
			setFiveButtonNomal();
			switch (v.getId()) {
			case R.id.btn_main_search:
				//
				btn_main_search.setImageDrawable(getResources().getDrawable(
						R.drawable.btn_main_serch));

				if (fg_main_search == null) {
					fg_main_search = new Fragment_Search();
					ft.add(R.id.main_content, fg_main_search);
				} else {
					ft.show(fg_main_search);
				}
				// ft.replace(R.id.main_content, fg_main_search);

				break;
			case R.id.btn_main_at:
				btn_main_at.setImageDrawable(getResources().getDrawable(
						R.drawable.btn_main_at));

				if (fg_main_at == null) {
					fg_main_at = new Fragment_At();
					ft.add(R.id.main_content, fg_main_at);
				} else {
					ft.show(fg_main_at);
				}
				// ft.replace(R.id.main_content, fg_main_at);

				break;
			case R.id.btn_vip:
				if (fg_main_vip == null) {
					fg_main_vip = new Fragment_Vip();
					ft.add(R.id.main_content, fg_main_vip);
				} else {
					ft.show(fg_main_vip);
				}
				// ft.replace(R.id.main_content, fg_main_vip);

				break;
			case R.id.btn_main_message:
				btn_main_message.setImageDrawable(getResources().getDrawable(
						R.drawable.btn_main_message));
				if (fg_main_message == null) {
					fg_main_message = new Fragment_Message();
					ft.add(R.id.main_content, fg_main_message);
				} else {
					ft.show(fg_main_message);
				}
				// ft.replace(R.id.main_content, fg_main_message);

				break;
			case R.id.btn_main_more:
				btn_main_more.setImageDrawable(getResources().getDrawable(
						R.drawable.btn_main_more));
				if (fg_main_more == null) {
					fg_main_more = new Fragment_More();
					ft.add(R.id.main_content, fg_main_more);

				} else {
					ft.show(fg_main_more);
				}
				// ft.replace(R.id.main_content, fg_main_more);

				break;

			}
			ft.commit();
		}

	}

	//设置所有的Fragment 隐藏
	public void setFragmentHide(FragmentTransaction ft) {
		if (fg_main_at != null) {
			ft.hide(fg_main_at);
		}
		if (fg_main_message != null) {
			ft.hide(fg_main_message);
		}
		if (fg_main_more != null) {
			ft.hide(fg_main_more);
		}
		if (fg_main_search != null) {
			ft.hide(fg_main_search);
		}
		if (fg_main_vip != null) {
			ft.hide(fg_main_vip);
		}

	}

	// /设置默认Fragment
	public void setDefaultFragment() {
		// 实例化Fragment管理器

		ft = fm.beginTransaction();

		fg_main_vip = new Fragment_Vip();
		ft.replace(R.id.main_content, fg_main_vip);

		ft.commit();
	}

	// 设置五个导航按钮为初试状态
	public void setFiveButtonNomal() {
		btn_main_search.setImageDrawable(getResources().getDrawable(
				R.drawable.btn_main_serche_nomal));
		btn_main_at.setImageDrawable(getResources().getDrawable(
				R.drawable.btn_mian_at_nomal));
		btn_main_message.setImageDrawable(getResources().getDrawable(
				R.drawable.btn_main_message_nomal));
		btn_main_more.setImageDrawable(getResources().getDrawable(
				R.drawable.btn_main_more_nomal));

	}

}
