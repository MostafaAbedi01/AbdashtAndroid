package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment1_5 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment1_5);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("جایگزینی شیرآلات دو محوره با شیرآلات اهرمی اولین و"
				+ " مهمترین اقدام در جهت کاهش مصرف در آب پخش ها می باشد. امروزه تنوع بسیار"
				+ " زیادی از این محصولات در بازار موجود است. نصب این شیرآلات در آشپزخانه،"
				+ " روشویی، سرویس بهداشتی و حمام اکید توصیه می شود"
				+ " و رایج ترین جایگزین شیرآلات مخلوطی کلاسیک می باشد."
				+ " استفاده از شیرآلات اهرمی باعث می شود قطع و وصل جریان آب و تنظیم دمای آب،"
				+ " با سرعت بسیار بیشتری انجام شود. انتخاب شیرآلات اهرمی در حمام، باعث می شود"
				+ " تنظیم دمای آب و قطع و وصل نمودن جریان به سهولت و با سرعت بیشتری انجام شود"
				+ " که این خود باعث کاهش مصرف آب در حمام خواهد شد.");
	}
}