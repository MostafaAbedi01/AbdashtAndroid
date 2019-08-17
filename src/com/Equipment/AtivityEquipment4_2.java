package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment4_2 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment3_5);
		setvalue();

		ImageView img1 = (ImageView) findViewById(R.id.imageEquipment1);
		img1.setImageResource(R.drawable.equipment4_2_1);

		ImageView img2 = (ImageView) findViewById(R.id.imageEquipment2);
		img2.setImageResource(R.drawable.equipment4_2_2);

		JustifiedTextView txt1 = (JustifiedTextView) findViewById(R.id.txtEquipment1);
		txt1.setText("سرشیرهای کاهنده مصرف آب یا پرلاتورها،"
				+ " با اختلاط آب و هوا، موجب کاهش فشار آب و درنتیجه کاهش مصرف خواهند شد."
				+ " این سرشیرها به آسانی قابل نصب برروی انواع شیرآلات می باشند:"
				+ "\n\n"
				+ "ساده:"
				+ "سرشیرهای ساده کاهنده مصرف آب، با اختلاط آب با هوا و کاهش فشار آب در کاهش مصرف آب تاثیر زیادی دارند."
				+ "  هر بار استفاده از روشویی به طور متوسط 2 دقیقه زمان می برد که استفاده "
				+ "از سرشیرهای کاهنده مصرف آب، می¬تواند تا میزان 50% موجب کاهش مصرف آب شود. ");

		JustifiedTextView txt2 = (JustifiedTextView) findViewById(R.id.txtEquipment2);
		txt2.setText("\n"
				+ "تنظیمی:"
				+ " این سرشیرها، علاوه کاهش مصرف آب "
				+ "از طریق اختلاط آب و هوا، دارای پیچ تنظیم جریان نیز می باشند "
				+ "که از این طریق نیز می-توانند کاهش مصرف آب را موجب شوند."
				+ "\n"
				+ "با استفاده از سرشیر مجهز به تنظیم جریان می توان تا میزان بالای 50% موجب کاهش مصرف آب شود.");

		JustifiedTextView txt3 = (JustifiedTextView) findViewById(R.id.txtEquipment3);
		txt3.setText("");

		JustifiedTextView txt4 = (JustifiedTextView) findViewById(R.id.txtEquipment4);
		txt4.setText("");
	}
}