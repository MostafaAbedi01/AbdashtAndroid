package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment5_1 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment5_1);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("مالچ یا خاکپوش، با پوشش سطح خاک، و نگهداشتن رطوبت خاک،"
				+ " باعث کاهش میزان مصرف آب در آبیاری گیاهان و فضای سبز می شود:"
				+ "\n"
				+ "\n"
				+ "•	از بين بردن خاصيت مويينگي و كاهش سرعت آب در رسيدن به سطح و حفظ رطوبت خاك"
				+ "\n"
				+ "•	كاهش سرعت تبخير از طريق افزايش فشار بخار و كاهش سرعت انتقال حرارت و نگهداري رطوبت خاک"
				+ "\n"
				+ "•	افزايش ميزان نفوذ آب و استفاده بهينه از آب آبياري و بارندگي ( به دليل جذب بالاي آب توسط آن و افزايش ميزان نفوذ آب)"
				+ "\n"
				+ "•	نگهداري آب و كمك به حفظ رطوبت خاك   "
				+ "\n"
				+ "•	كاهش تغييرات دمايي در سطح خاك       "
				+ "\n"
				+ "•	عدم تاثيرات سوء شيميايي و فيزيكي بر خاك (پايدار بودن تركيب در شرايط گوناگون)"
				+ "\n" + "•	جلوگيري از رشد علف هاي هرز"

		);
	}
}