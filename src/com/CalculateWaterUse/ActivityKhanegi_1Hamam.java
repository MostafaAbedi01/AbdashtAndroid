package com.CalculateWaterUse;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_1Hamam extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private SeekBar SeekBarQ2;
	private TextView txtSeekBarQ2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_1hamam);

		setvalue(2);

		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  بار در هفته ");

		SeekBarQ2 = (SeekBar) findViewById(R.id.SeekBarQ2);
		txtSeekBarQ2 = (TextView) findViewById(R.id.txtSeekBar2);
		txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  دقیقه ");

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
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  دقیقه ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  دقیقه ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  دقیقه ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				int countShower = SeekBarQ1.getProgress();
				int minuteShower = SeekBarQ2.getProgress();
				double minuteShowerLiter;
				if (minuteShower < 10) {
					minuteShowerLiter = 60;
				} else if (minuteShower < 20) {
					minuteShowerLiter = 100;
				} else if (minuteShower < 30) {
					minuteShowerLiter = 140;
				} else if (minuteShower < 40) {
					minuteShowerLiter = 180;
				} else {
					minuteShowerLiter = 220;
				}

				double frequencyFactor = 0;
				if (countShower <= 3) {
					frequencyFactor = 1.2;
				} else if (countShower <= 6) {
					frequencyFactor = 1.1;
				} else if (countShower <= 9) {
					frequencyFactor = 1;
				} else if (countShower <= 11) {
					frequencyFactor = 0.9;
				} else if (countShower <= 13) {
					frequencyFactor = 0.8;
				} else if (countShower <= 14) {
					frequencyFactor = 0.7;
				}
				StaticValue.LiterShowerCalc = (int) ((((double) countShower / 7) * (frequencyFactor)) * minuteShowerLiter);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_1Hamam.this, ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
