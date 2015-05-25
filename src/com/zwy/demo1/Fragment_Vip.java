package com.zwy.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zwy.tools.CornerListView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class Fragment_Vip extends Fragment {
	private String[] vip_shop;
	private String[] vip_no;
	private SimpleAdapter adapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
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

		View rootView = inflater
				.inflate(R.layout.fg_mian_vip, container, false);
		CornerListView listview = (CornerListView) rootView
				.findViewById(R.id.vip_lv);
		listview.setAdapter(adapter);

		return rootView;
	}

}
