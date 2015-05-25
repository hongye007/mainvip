package com.zwy.tools;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

public class BaiduLocation {
	private Context context;
	private LocationClient locationClient = null;
	private BDLocationListener myListener = null;;

	public BaiduLocation(Context context1, BDLocationListener myListener2) {
		myListener = myListener2;
		this.context = context1;
		locationClient = new LocationClient(context);
		
		locationClient.registerLocationListener(myListener);

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度，默认值gcj02
		int span = 1000;
		option.setScanSpan(span);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true); // 反地理编码
		locationClient.setLocOption(option);
		
	}
	public void start(){
		locationClient.start();
		locationClient.stop();
	}

}
