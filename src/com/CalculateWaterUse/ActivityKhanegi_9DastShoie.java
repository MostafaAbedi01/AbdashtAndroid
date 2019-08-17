package com.CalculateWaterUse;

import java.util.ArrayList;
import java.util.List;

import org.codeandmagic.android.gauge.demo.ActivityGaugeView;

import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_9DastShoie extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_9dastshoe);

		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				RadioButton rdb1_1 = (RadioButton) findViewById(R.id.rdb1_1);
				RadioButton rdb2_1 = (RadioButton) findViewById(R.id.rdb2_1);
				RadioButton rdb3_1 = (RadioButton) findViewById(R.id.rdb3_1);

				int LiterHandWashing = rdb1_1.isChecked() ? 10 : 5;
				LiterHandWashing += rdb2_1.isChecked() ? 10 : 5;
				LiterHandWashing += rdb3_1.isChecked() ? 10 : 5;

				StaticValue.LiterShowerCalc = LiterHandWashing;
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_9DastShoie.this,
						ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
