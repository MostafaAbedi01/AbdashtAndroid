package com.IranSoftjo;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityHelp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.help_main);

		TextView txtEquipmentTitle = (TextView) findViewById(R.id.txtEquipmentTitle);
		txtEquipmentTitle.setText("راهنمای اپلیکیشن");

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("این نرم افزار جهت محاسبه و مدیریت مصرف آب کشور تهیه و تولید شده است و مقادیر نمایش داده شده به صورت متوسط مقدار میباشد.\n "
				+ "در این نرم افزار سعی شده جهت آگاهی عموم از مصرف آب خانگی و غیر خانگی اطلاع رسانی کاملی بشود.");
	}
}
