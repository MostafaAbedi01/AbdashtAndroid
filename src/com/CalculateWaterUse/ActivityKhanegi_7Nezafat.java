package com.CalculateWaterUse;

import org.codeandmagic.android.gauge.demo.ActivityGaugeView;

import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Vibrator;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.ImageView;

import android.widget.SeekBar;

import android.widget.TextView;

import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_7Nezafat extends ExtendActivityCountPeople {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private SeekBar SeekBarQ2;
	private TextView txtSeekBarQ2;
	private SeekBar SeekBarQ3;
	private TextView txtSeekBarQ3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_7nezafat);
		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  بار در هفته ");

		SeekBarQ2 = (SeekBar) findViewById(R.id.SeekBarQ2);
		txtSeekBarQ2 = (TextView) findViewById(R.id.txtSeekBar2);
		txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");

		SeekBarQ3 = (SeekBar) findViewById(R.id.SeekBarQ3);
		txtSeekBarQ3 = (TextView) findViewById(R.id.txtSeekBar3);
		txtSeekBarQ3.setText(SeekBarQ2.getProgress() + "  بار در هفته ");

		SeekBarQ1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در هفته ");

			}
		});

		SeekBarQ2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");

			}
		});

		SeekBarQ3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ3.setText(seekBar.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ3.setText(seekBar.getProgress() + "  بار در هفته ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ3.setText(seekBar.getProgress() + "  بار در هفته ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
				int CountPeople = SeekBarCountPeople.getProgress();

				int cleaningHouseWc = SeekBarQ1.getProgress();
				int cleaningHouseBathroom = SeekBarQ2.getProgress();
				int cleaningHouseKitchen = SeekBarQ3.getProgress();

				StaticValue.LiterHandWashingCalc = (int) (((int) ((cleaningHouseWc * 30)
						+ (cleaningHouseBathroom * 50) + (cleaningHouseKitchen * 70)) / 7) / CountPeople);
				
				StaticValue.LiterCalc = StaticValue.LiterHandWashingCalc;
				StaticValue.LiterMain = StaticValue.LiterHandWashingMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_7Nezafat.this, ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
