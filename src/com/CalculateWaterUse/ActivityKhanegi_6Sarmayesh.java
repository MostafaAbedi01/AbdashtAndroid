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

public class ActivityKhanegi_6Sarmayesh extends ExtendActivityCountPeople {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private RadioButton rdb0;
	private RadioButton rdb1;
	private Spinner spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_6sarmayesh);
		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  ساعت در روز ");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("3500 تا 4500");
		objlist.add("4500 تا 5000");
		objlist.add("5500 تا 6000");
		objlist.add("6500 تا 8000");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		SeekBarQ1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  ساعت در روز ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  ساعت در روز ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  ساعت در روز ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
				int CountPeople = SeekBarCountPeople.getProgress();

				rdb0 = (RadioButton) findViewById(R.id.rdb0);
				rdb1 = (RadioButton) findViewById(R.id.rdb1);

				int coolerTime = SeekBarQ1.getProgress();

				int coolerVolume = 0;
				if (spinner1.getSelectedItemPosition() == 0) {
					coolerVolume = 10;
				} else if (spinner1.getSelectedItemPosition() == 1) {
					coolerVolume = 13;
				} else if (spinner1.getSelectedItemPosition() == 2) {
					coolerVolume = 15;
				} else if (spinner1.getSelectedItemPosition() == 3) {
					coolerVolume = 18;
				}

				if (rdb1.isChecked()) {
					StaticValue.LiterCoolerCalc = (int) ((int) ((int) (coolerTime * coolerVolume)) / CountPeople);
				}

				StaticValue.LiterCalc = StaticValue.LiterCoolerCalc;
				StaticValue.LiterMain = StaticValue.LiterCoolerMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_6Sarmayesh.this,
						ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
