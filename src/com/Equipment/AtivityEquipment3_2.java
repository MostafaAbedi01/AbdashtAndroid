package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment3_2 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment3_2);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("شیرآلات الکترونیکی یکی از بهترین روشهای صرفه جویی در مصرف آب می باشد"
				+ " و بیشتر برای استفاده در اماکن عمومی با تعداد استفاده زیاد توصیه می شود."
				+ " این شیر در مدل های مختلف در بازار جهت استفاده متناسب با کاربری های مختلف موجود است."
				+ " اساس کار شیرآلات الکترونیکی قطع و وصل هوشمند جریان آب می باشد."
				+ " امروزه تنوع مدل در این شیرآلات و میل به استفاده از آنها به طور چشمگیری افزایش یافته است."
				+ " شیرهای الکترونیکی به صورت دیواری نیز طراحی و تولید شده اند. همچنین در"
				+ " برخی از این شیرآلات قابلیت اختلاط آب سرد و گرم وجود داشته و در برخی مدل ها نیز وجود ندارد.");
	}
}