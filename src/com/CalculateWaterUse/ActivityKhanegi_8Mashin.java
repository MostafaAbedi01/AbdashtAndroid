package com.CalculateWaterUse;

import java.util.ArrayList;
import java.util.List;

import org.codeandmagic.android.gauge.demo.ActivityGaugeView;

import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Vibrator;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

import android.widget.ImageView;

import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_8Mashin extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private Spinner spinner1;
	private Spinner spinner2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_8mashin);

		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  عدد ");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("با شلنگ");
		objlist.add("با آبپاش");
		objlist.add("با شلنگ مجهز به سر شلنگ");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> objlist2 = new ArrayList<String>();

		objlist2.add("1 بار درهفته");
		objlist2.add("2تا3 بار در هفته");
		objlist2.add("2تا3 بار در ماه");
		objlist2.add("1 بار درماه");
		objlist2.add("هر 3ماه یکبار");
		objlist2.add("هر 4تا6ماه یکبار");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter2);

		SeekBarQ1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  عدد ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  عدد ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  عدد ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				int carWashCount = SeekBarQ1.getProgress();
				int carWashPeriod = spinner2.getSelectedItemPosition() + 1;
				int carWashHow = spinner1.getSelectedItemPosition() + 1;
				double liter = 0;
				if (carWashPeriod == 1) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 16;
					} else if (carWashHow == 2) {
						liter = 80;
					} else {
						liter = 72;
					}
				} else if (carWashPeriod == 2) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 8;
					} else if (carWashHow == 2) {
						liter = 40;
					} else {
						liter = 36;
					}
				} else if (carWashPeriod == 3) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 3.5;
					} else if (carWashHow == 2) {
						liter = 19;
					} else {
						liter = 18;
					}
				} else if (carWashPeriod == 4) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 2;
					} else if (carWashHow == 2) {
						liter = 10;
					} else {
						liter = 9;
					}
				} else if (carWashPeriod == 5) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 1;
					} else if (carWashHow == 2) {
						liter = 5;
					} else {
						liter = 4;
					}
				} else if (carWashPeriod == 6) {
					if (carWashHow == 0) {
						liter = 0;
					} else if (carWashHow == 1) {
						liter = 0.5;
					} else if (carWashHow == 2) {
						liter = 2.5;
					} else {
						liter = 2;
					}
				}

				StaticValue.LiterCarWashCalc = (int) (carWashCount * liter);
				StaticValue.LiterCalc = StaticValue.LiterCarWashCalc;
				StaticValue.LiterMain = StaticValue.LiterCarWashMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_8Mashin.this, ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
