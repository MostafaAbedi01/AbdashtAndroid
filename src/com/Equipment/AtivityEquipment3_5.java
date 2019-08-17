package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment3_5 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment3_5);
		setvalue();

		ImageView img1 = (ImageView) findViewById(R.id.imageEquipment1);
		img1.setImageResource(R.drawable.equipment3_5_1);

		ImageView img2 = (ImageView) findViewById(R.id.imageEquipment2);
		img2.setImageResource(R.drawable.equipment3_5_2);

		ImageView img3 = (ImageView) findViewById(R.id.imageEquipment3);
		img3.setImageResource(R.drawable.equipment3_5_3);

		ImageView img4 = (ImageView) findViewById(R.id.imageEquipment4);
		img4.setImageResource(R.drawable.equipment3_5_4);

		JustifiedTextView txt1 = (JustifiedTextView) findViewById(R.id.txtEquipment1);
		txt1.setText("سرشیرهای کاهنده مصرف آب، یا پرلاتورها، "
				+ "با اختلاط آب و هوا، موجب کاهش فشار آب و درنتیجه کاهش مصرف خواهند شد که عبارتند از:"
				+ "\n\n" + "ساده:"
				+ " این سرشیرها به آسانی قابل نصب برروی انواع شیرآلات می باشند");

		JustifiedTextView txt2 = (JustifiedTextView) findViewById(R.id.txtEquipment2);
		txt2.setText("\n"
				+ "تنظیمی:"
				+ " این سرشیرها، علاوه کاهش مصرف آب "
				+ "از طریق اختلاط آب و هوا، دارای پیچ تنظیم جریان نیز می باشند "
				+ "که از این طریق نیز می-توانند کاهش مصرف آب را موجب شوند.");

		JustifiedTextView txt3 = (JustifiedTextView) findViewById(R.id.txtEquipment3);
		txt3.setText("\n"
				+ "لمسی:"
				+ " با لمس و فشار دادن اهرم کوچک تعبیه شده در این سرشیرها،"
				+ " می توان باعث قطع و وصل جریان آب شد. این پدیده موجب کاهش مصرف آب شده"
				+ " و این سرشیرها در روشویی ها جهت کاهش انتقال آلودگی، کابربرد فراوان دارد.");

		JustifiedTextView txt4 = (JustifiedTextView) findViewById(R.id.txtEquipment4);
		txt4.setText("\n"
				+ "الکترونیکی:"
				+ "نصب این سرشیرها"
				+ " برروی انواع شیرآلات اهرمی، به آنها قابلیت تبدیل شدن به یک شیر الکترونیکی را می دهد.");
	}
}