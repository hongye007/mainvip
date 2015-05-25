package com.zwy.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.zwy.tools.BaiduLocation;
import com.zwy.tools.CornerListView;

public class Fragment_Search extends Fragment {
	private Context context = null;
	private StringBuffer sb = null;
	private BaiduLocation baiduLocation = null;
	private TextView search_location_content;
	private Button search_location_refrash;
	private View view;
	// 百度回调函数

	private String[] vip_shop;
	private String[] vip_no;
	private SimpleAdapter adapter;

	private BDLocationListener myListener = new MyLocationListener();;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 获取上下文
		context = getActivity().getApplicationContext();
		// 获取view
		view = inflater.inflate(R.layout.fg_main_serch, container, false);
		// 获取控件
		search_location_content = (TextView) view
				.findViewById(R.id.search_location_content);
		search_location_refrash = (Button) view
				.findViewById(R.id.search_location_refrash);
		// 初始化定位栏
		baiduLocation = new BaiduLocation(context, myListener);
		baiduLocation.start();
		search_location_refrash.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				search_location_content.setText("");
				baiduLocation.start();
			}
		});

		// 返回view

		// ///////
		vip_shop = getResources().getStringArray(R.array.vip_array_shop);
		vip_no = getResources().getStringArray(R.array.vip_array_no);
		int[] images = { R.drawable.aa, R.drawable.bb, R.drawable.cc };
		int[] color = { R.color.c1, R.color.c4, R.color.c2, R.color.c3 };

		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < vip_shop.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("logo", images[i]);
			map.put("shop", vip_shop[i]);
			map.put("no", vip_no[i]);
			map.put("color", color[i]);
			items.add(map);
		}

		adapter = new SimpleAdapter(getActivity().getApplicationContext(),
				items, R.layout.vip_listview, new String[] { "logo", "shop",
						"no" }, new int[] { R.id.vip_list_image,
						R.id.vip_list_name, R.id.vip_list_no });

		
		CornerListView listview = (CornerListView) view
				.findViewById(R.id.search_listview);
		listview.setAdapter(adapter);
		// //////////
		return view;
	}

	class MyLocationListener implements BDLocationListener {
		public void onReceiveLocation(BDLocation location) {
			// Receive Location
			sb = new StringBuffer(256);
			sb.append("time : ");
			sb.append(location.getTime());
			sb.append("\nerror code : ");
			sb.append(location.getLocType());
			sb.append("\nlatitude : ");
			sb.append(location.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(location.getLongitude());
			sb.append("\nradius : ");
			sb.append(location.getRadius());
			if (location.getLocType() == BDLocation.TypeGpsLocation) {
				sb.append("\nspeed : ");
				sb.append(location.getSpeed());
				sb.append("\nsatellite : ");
				sb.append(location.getSatelliteNumber());
				sb.append("\ndirection : ");
				sb.append("\naddr : ");
				sb.append(location.getAddrStr());
				sb.append(location.getDirection());
			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				sb.append("\naddr : ");
				sb.append(location.getAddrStr());
				// 运营商信息
				sb.append("\noperationers : ");
				sb.append(location.getOperators());
			}
			search_location_content.setText(location.getAddrStr());
		}
	}

}
