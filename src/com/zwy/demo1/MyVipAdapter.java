package com.zwy.demo1;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyVipAdapter extends BaseAdapter implements ListAdapter {
	private Context context;
	LayoutInflater layoutinflater;
	List<Map<String, Object>> items;

	public MyVipAdapter(Context context2, List<Map<String, Object>> items) {
		this.items = items;
		this.context = context2;
		layoutinflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutinflater.inflate(R.layout.vip_listview, null);
		}
		convertView.setBackgroundColor((Integer) this.items.get(position).get(
				"color"));
		ImageView image = (ImageView) convertView
				.findViewById(R.id.vip_list_image);
		TextView vip_name = (TextView) convertView
				.findViewById(R.id.vip_list_name);
		TextView vip_no = (TextView) convertView.findViewById(R.id.vip_list_no);
		image.setImageDrawable(context.getResources().getDrawable(
				(Integer) (this.items.get(position).get("logo"))));
		vip_name.setText(this.items.get(position).get("shop").toString());
		vip_no.setText(this.items.get(position).get("no").toString());
		return convertView;
	}

}
