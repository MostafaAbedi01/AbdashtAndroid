package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment4_1 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment4_1);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("جایگزینی شیرآلات دو محوره با شیرآلات اهرمی اولین"
				+ " و مهمترین اقدام در جهت کاهش مصرف در آب پخش ها می باشد."
				+ " امروزه تنوع بسیار زیادی از این محصولات در بازار موجود است."
				+ " نصب این شیرآلات در آشپزخانه، روشویی، سرویس بهداشتی و حمام اکید توصیه می شود"
				+ " و رایج ترین جایگزین شیرآلات مخلوطی کلاسیک می باشد. استفاده از شیرآلات اهرمی باعث می شود"
				+ " قطع و وصل جریان آب و تنظیم دمای آب، با سرعت بسیار بیشتری انجام شود."
				+ " استفاده از شیرآلات اهرمی در آشپزخانه باعث می شود قطع"
				+ " و وصل جریان آب و تنظیم دمای آب، با سرعت بسیار بیشتری انجام شود."
				+ " این امر موجب کاهش مصرف آب در هنگام پخت و پز و شستن ظروف خواهد شد..");
	}
}