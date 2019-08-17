package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment1_3 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment1_3);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("برای همه ما پیش آمده که به علت دور بودن یکی از شیرهای برداشت آب (نظیر حمام)"
				+ " از محل آب گرمکن (یا هر سیستم گرمایشی دیگر)، مدت زمانی باید صبرکرده"
				+ " و آب گرم را باز نگه داریم تا پس از هدررفت مقدار بسیار زیادی آب،"
				+ ".به تدریج آب گرم به محل مصرف برسد و بتوانیم از آن استفاده کنیم."
				+ " \n \n "
				+ " این مشکل خصوصاً در منازل ویلائی و بزرگ و قدیمی و مکانهایی که استانداردهای طراحی تاسیسات"
				+ " در آنها رعایت نشده بسیار به چشم می خورد."
				+ "\n"
				+ " یکی از روشهای کم هزینه رفع"
				+ " این مشکل استفاده از پمپ های سیرکولاتور در مسیر جریان آب گرم مصرفی است "
				+ "که باعث می شود تا زمانی که آب به دمای"
				+ " از پیش تعریف شده نرسیده، جریان آب برقرار نشده و از هدررفت مقادیر بسیار"
				+ " زیادی از آب و انرژی جلوگیری بعمل می آید."
				+ "\n"
				+ " سیستم سیرکوله آب گرما یک سیستم"
				+ " پردازشگر کوچک اما مفید است که می تواند در زیر سینک و یا در حمام نصب گردد.");
	}
}