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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_2ServiceBehdashti extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private SeekBar SeekBarQ2;
	private TextView txtSeekBarQ2;

	private Spinner spinner1;
	private Spinner spinner2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_2servicebehdashti);
		setvalue(2);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> listJenseManhol = new ArrayList<String>();
		listJenseManhol.add("بدون فلاش تانک");
		listJenseManhol.add("فلاش تانک دیواری دوگانه");
		listJenseManhol.add("فلاش تانک معمولی");
		listJenseManhol.add("فلاش شیری");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, listJenseManhol);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list2 = new ArrayList<String>();
		list2.add("فلاش تانک ساده");
		list2.add("فلاش تانک دوگانه");
		list2.add("فلاش با وکیوم");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter2);

		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  بار در روز ");

		SeekBarQ2 = (SeekBar) findViewById(R.id.SeekBarQ2);
		txtSeekBarQ2 = (TextView) findViewById(R.id.txtSeekBar2);
		txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در روز ");

		SeekBarQ1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در روز ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در روز ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  بار در روز ");

			}
		});

		SeekBarQ2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در روز ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در روز ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در روز ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				int countQ1 = SeekBarQ1.getProgress();
				int countQ2 = SeekBarQ2.getProgress();

				int wcFarangi = countQ1;
				int wcFarangiF;
				int wcIrani = countQ2;
				int wcIraniF = 0;
				int literWcIrani = 0;
				int literWcFarangi = 0;

				if (spinner1.getSelectedItemPosition() == 0) {
					wcIraniF = 0;
				} else if (spinner1.getSelectedItemPosition() == 1) {
					wcIraniF = 5;
				} else if (spinner1.getSelectedItemPosition() == 2) {
					wcIraniF = 13;
				} else if (spinner1.getSelectedItemPosition() == 3) {
					wcIrani = 6;
				}

				if (spinner2.getSelectedItemPosition() == 0) {
					wcFarangiF = 8;
				} else {
					wcFarangiF = 4;
				}

				if (wcFarangi > 0) {
					literWcFarangi = (int) (wcFarangi * wcFarangiF);
				}

				if (wcIrani > 0) {
					literWcIrani = (int) (wcIrani * wcIraniF);
				}

				StaticValue.LiterWcCalc = literWcIrani + literWcFarangi + 10;

				StaticValue.LiterCalc = StaticValue.LiterWcCalc;
				StaticValue.LiterMain = StaticValue.LiterWcMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_2ServiceBehdashti.this,
						ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
