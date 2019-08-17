package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment3_3 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment3_3);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("این شیرها به گونه ای "
				+ "طراحی شده اند که با فشار دکمه تعبیه شده بر روی شیر جران آب برقرار شده"
				+ " و پس از مصرف، با فشار مجدد دکمه، جریان قطع می شود. به علت استفاده مدام"
				+ " از جریان آب در مکان های عمومی مانند مساجد، وضوخانه ها، آبخوری مدارس و ...، استفاده"
				+ " از شیرآلات فشاری بهترین انتخاب در این مکان ها می باشد"
				+ " و منجر به صرفه جویی و کاهش مصرف می شود."
				+ " این شیر آلات می توانند دیواری نیز باشند. می توان به جای تعویض کامل شیر با نوع فشاری،"
				+ " از پرلاتورهای فشاری (سرشیر فشاری) یا ضربه ای (عادی و زماندار) استفاده کرد.");
	}
}