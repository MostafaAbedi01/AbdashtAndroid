package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment1_2 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment1_2);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("استفاده از شیر *آب بس* برای تنه دوش های دو محوره می باشد."
				+ " در ابتدای دوش گرفتن می توان دمای آب را تنظیم نمود"
				+ "  و  در زمان های عدم نیاز به جریان آب، با یک فشار ساده آب را قطع و دوباره وصل کرد."
				+ " با این روش ساده می توان به آسانی از هدر رفت"
				+ " آب در حمام در زمان های عدم نیاز به آب، جلوگیری نمود.");
	}
}