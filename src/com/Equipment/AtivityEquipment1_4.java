package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment1_4 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img= (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment1_4);
		
		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("تمام انسانها به صورت طبیعی میل  به آب و استحمام دارند."
				+ "به این خاطر انسان قادر به درک گذشت زمان در هنگام استحمام نبوده "
				+ "و نمی تواند تمرکز لازم روی زمان استحمام و میزان مصرف آب داشته باشد."
				+ " زمان سنج مصرف آب را می توان نوعی ساعت درنظر گرفت که در حمام قابل استفاده است"
				+ "که به طور مداوم افزایش زمان مصرف آب را بما یادآوری می کند.");
	}
}