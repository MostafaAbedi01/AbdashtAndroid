package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment4_4 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img= (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment4_4);
		
		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("از آنجا که در هنگام شستشوی ظروف،" +
				" بیشترین مقدار آب مصرف می شود، انتخاب ماشین ظرفشویی کم مصرف،" +
				" یکی از راهکارهای مهم در کاهش مصرف آب در آشپزخانه می باشد.");
	}
}