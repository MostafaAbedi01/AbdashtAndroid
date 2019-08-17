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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_4Lebas extends ExtendActivityCountPeople {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private SeekBar SeekBarQ2;
	private TextView txtSeekBarQ2;
	private SeekBar SeekBarQ4;
	private TextView txtSeekBarQ4;
	private Spinner spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_4lebas);

		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  بار در هفته ");

		SeekBarQ2 = (SeekBar) findViewById(R.id.SeekBarQ2);
		txtSeekBarQ2 = (TextView) findViewById(R.id.txtSeekBar2);
		txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");

		SeekBarQ4 = (SeekBar) findViewById(R.id.SeekBarQ4);
		txtSeekBarQ4 = (TextView) findViewById(R.id.txtSeekBar4);
		txtSeekBarQ4.setText(SeekBarQ2.getProgress() + "  بار ");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("درب جلو");
		objlist.add("دوقولو یا سطلی");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

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

		SeekBarQ4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ4.setText(seekBar.getProgress() + "  بار ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ4.setText(seekBar.getProgress() + "  بار ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ4.setText(seekBar.getProgress() + "  بار ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
				int CountPeople = SeekBarCountPeople.getProgress();

				int countWasherInWeek = SeekBarQ1.getProgress();
				int countWasherSeries = SeekBarQ2.getProgress();
				int unitWasherInWeek = SeekBarQ4.getProgress();
				int typeWasher = 0;
				int washer = 0;
				if (spinner1.getSelectedItemPosition() == 0) {
					typeWasher = 1;
				} else if (spinner1.getSelectedItemPosition() == 1) {
					typeWasher = 2;
				}

				if (typeWasher == 1) {
					washer = (int) (countWasherInWeek * 8);
				} else if (typeWasher == 2) {
					washer = (int) (countWasherInWeek * 10);
				}
				washer = (int) (washer * countWasherSeries);

				int frequencyFactor = 0;
				if (unitWasherInWeek == 1) {
					frequencyFactor = (int) (20);
				}
				if (unitWasherInWeek == 2) {
					frequencyFactor = (int) (35);
				}
				if (unitWasherInWeek == 3) {
					frequencyFactor = (int) (50);
				}
				if (unitWasherInWeek == 4) {
					frequencyFactor = (int) (65);
				}
				if (unitWasherInWeek == 5) {
					frequencyFactor = (int) (80);
				}
				if (unitWasherInWeek == 6) {
					frequencyFactor = (int) (95);
				}
				if (unitWasherInWeek == 7) {
					frequencyFactor = (int) (110);
				}

				double FCountPeople = 0;
				if (CountPeople == 1) {
					FCountPeople = 1;
				}
				if (CountPeople == 2) {
					FCountPeople = 1.7;
				}
				if (CountPeople == 3) {
					FCountPeople = 2.5;
				}
				if (CountPeople == 4) {
					FCountPeople = 3.3;
				}
				if (CountPeople == 5) {
					FCountPeople = 4.1;
				}
				if (CountPeople == 6) {
					FCountPeople = 4.8;
				}
				if (CountPeople == 7) {
					FCountPeople = 5.6;
				}
				if (CountPeople == 8) {
					FCountPeople = 6.4;
				}
				if (CountPeople == 9) {
					FCountPeople = 7.1;
				}
				if (CountPeople == 10) {
					FCountPeople = 7.9;
				}
				StaticValue.LiterWasherCalc = (int) ((frequencyFactor * FCountPeople) + washer);

				StaticValue.LiterCalc = StaticValue.LiterWasherCalc;
				StaticValue.LiterMain = StaticValue.LiterWasherMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_4Lebas.this, ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
