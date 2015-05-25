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
		option.setLocationMode(LocationMode.Hight_Accuracy);// ���ö�λģʽ
		option.setCoorType("bd09ll");// ���صĶ�λ����ǰٶȾ�γ�ȣ�Ĭ��ֵgcj02
		int span = 1000;
		option.setScanSpan(span);// ���÷���λ����ļ��ʱ��Ϊ5000ms
		option.setIsNeedAddress(true); // ���������
		locationClient.setLocOption(option);
		
	}
	public void start(){
		locationClient.start();
		locationClient.stop();
	}

}
