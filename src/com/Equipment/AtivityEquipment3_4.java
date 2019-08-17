package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.widget.ImageView;

public class AtivityEquipment3_4 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment3_4);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("شیرهای پدالی به دو صورت تك پدال و دو پدال در بازار موجود هستند"
				+ " و در صورت استفاده صحیح می توانند تا 70 درصد صرفه جوئی در مصرف آب به دنبال داشته باشند."
				+ " این شیرها دارای دو ورودی برای آب سرد و گرم هستند و معمولاً روی ورودی آب سرد شیرجداگانه ای"
				+ " برای تنظیم دما قرار دارد. به این ترتیب آب سرد با گرم مخلوط می شود و"
				+ " آماده تحویل به مصرف کننده است. یک اهرم خاص که می تواند با بازوی فلزی یا"
				+ " از هر جنس محکم دیگه ای باشد، فنری را روی سر این شیر کنترل می کند"
				+ " که این فنر در واقع دریچه اصلی باز و بست شیر برای جریان پیدا کردن آب است."
				+ " این اهرم در کنار دیوار سرویس بهداشتی به سمت پایین نصب می شود"
				+ " و پدال شیر به انتهای آن وصل است. این پدال در کنار روشوئی و حتی ظرفشوئی"
				+ " در دسترس مصرف کننده قرار می گیرد و با هر بار فشار دادن پا روی پدال،"
				+ " جریان آب برقرار می شود و به محض رها کردن پدال آب قطع می شود ."
				+ " چون شما از قبل دمای آب تنظیم شده نیازی به تنظیم دما در هر بار استفاده نیست"
				+ " و از این بابت هم در مصرف آب صرفه جوئی می شود."
				+ "\n"
				+ "بعلت عدم تماس دست مصرف کننده با شیر، درست مثل شیر الکترونیکی، استفاده از این شیرها هم"
				+ "  رعایت اصول بهداشتی رو به دنبال دارند. در قیاس با شیرهای الکترونیکی ،"
				+ " شیر پدالی نیازی به انرژی مثل برق و باطری ندارد و هزینه های جانبی آن کمتر است و شاید"
				+ " این موضوع بزرگترین مزیت این شیر نسبت به شیر الکترونیکی باشد.");
	}
}