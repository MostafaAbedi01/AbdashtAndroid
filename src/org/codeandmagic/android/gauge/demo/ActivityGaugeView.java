package org.codeandmagic.android.gauge.demo;


import org.codeandmagic.android.gauge.GaugeView;

import com.CalculateWaterUse.ExtendActivityWithUp;
import com.CalculateWaterUse.StaticValue;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ActivityGaugeView extends ExtendActivityWithUp {

	private GaugeView mGaugeView1;
	private GaugeView mGaugeView2;
	TextView lblResultLiter;
	TextView lblResultTitleAlarm;

	// private final Random RAND = new Random();

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gaugeview);
		setvalue(2);
		lblResultTitleAlarm = (TextView) findViewById(R.id.lblResultTitleAlarm);
		lblResultLiter = (TextView) findViewById(R.id.lblResultLiter);
		lblResultLiter.setText(StaticValue.LiterCalc + " لیتر در روز");
		mGaugeView1 = (GaugeView) findViewById(R.id.gauge_view1);
		mGaugeView2 = (GaugeView) findViewById(R.id.gauge_view2);

		mGaugeView1.setTargetValue(StaticValue.LiterCalc);
		mGaugeView2.setTargetValue(StaticValue.LiterCalc);

		if (StaticValue.LiterCalc <= StaticValue.LiterMain) {
			lblResultTitleAlarm.setText("**شما کم مصرف میباشید**");
			lblResultTitleAlarm.setTextColor(Color.parseColor("#19B052"));
			lblResultLiter.setTextColor(Color.parseColor("#19B052"));
		}
		// mTimer.start();
	}

	// private final CountDownTimer mTimer = new CountDownTimer(30000, 1000) {
	//
	// @Override
	// public void onTick(final long millisUntilFinished) {
	// mGaugeView1.setTargetValue(RAND.nextInt(101));
	// mGaugeView2.setTargetValue(RAND.nextInt(101));
	// }
	//
	// @Override
	// public void onFinish() {
	// }
	// };
}
