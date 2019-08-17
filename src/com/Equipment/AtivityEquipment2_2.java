package com.Equipment;

import ir.noghteh.JustifiedTextView;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AtivityEquipment2_2 extends ExtendActivityWithTitle {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment1_1);
		setvalue();
		ImageView img = (ImageView) findViewById(R.id.imageEquipment);
		img.setImageResource(R.drawable.equipment2_2);

		JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.txtEquipment);
		txt.setText("فلاش تانكهاي عادي در هر بار استفاده بين 20-13 ليترآب به ازائ هر تخليه مصرف مي كنند."
				+ " آمار نشان مي دهد حدود 20 درصد مصرف آب خانگي در توالت ها مي باشد. لذا استفاده"
				+ " از فلاش تانك هاي كم مصرف به عنوان يك استاندارد ملي مي تواند مطرح گردد."
				+ " در حال حاضر فلاش تانكهاي دو مرحله اي (دوال) كم مصرف ( 3-6 ليتري )"
				+ " كه نسبت به نوع پرمصرف آن بيش از 80 درصد صرفه جويي در مصرف آب دارد در دسترس مي باشد. "
				+ "\n"
				+ "\n"
				+ "کاهش حجم فلاش تانک های حجیم-"
				+ " میتوان با استفاده از قطعات سبک و حجیم پلاستیکی"
				+ " و قرار دادن آنها در مخزن فلاش تانک، حجم فلاش تانک را کاهش داد."
				+ " یا با قرار دادن مانع در داخل فلاش تانک،"
				+ " باعث کاهش حجم مخزن آن شده تا در هر بار استفاده، آب کمتری مصرف شود. "
				+ "استفاده از  مخازن پرکننده پلاستیکی کوچک با احجام تعریف شده،"
				+ " می تواند راهکار مناسبی برای کاهش حجم فلاش تانک باشد.");
	}
}