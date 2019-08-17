package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment4_3 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment4_3);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("انتخاب لباسشویی کم مصرف می تواند کاهش بسیار زیاد  مصرف آب در آشپزخانه را موجب شود."
				+ " در هنگام انتخاب ماشین لباسشویی باید براساس برچسب"
				+ " انرژی و دفترچه راهنمای آن، دقت لازم صورت گیرد.");
	}
}