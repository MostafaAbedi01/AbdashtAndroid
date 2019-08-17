package com.CalculateWaterUse;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
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

import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_3AshpazKhane extends ExtendActivityCountPeople {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	private SeekBar SeekBarQ2;
	private TextView txtSeekBarQ2;
	private Spinner spinner1;
	private RadioButton rdb0;
	private RadioButton rdb1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_3ashpazkhane);
		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  بار در هفته ");

		SeekBarQ2 = (SeekBar) findViewById(R.id.SeekBarQ2);
		txtSeekBarQ2 = (TextView) findViewById(R.id.txtSeekBar2);
		txtSeekBarQ2.setText(SeekBarQ2.getProgress() + "  بار در هفته ");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("در سینگ ظرف شویی یا ظرف");
		objlist.add("زیر جریان آب");
		objlist.add("هر دو روش");
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

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				int kitchenDishesByHand = SeekBarQ1.getProgress();
				int kitchenDishwasher = SeekBarQ2.getProgress();

				SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
				int CountPeople = SeekBarCountPeople.getProgress();

				rdb0 = (RadioButton) findViewById(R.id.rdb0);
				rdb1 = (RadioButton) findViewById(R.id.rdb1);
				int kitchenDishesByHandYesNo = 0;
				if (rdb0.isChecked()) {
					kitchenDishesByHandYesNo = 1;
				} else if (rdb1.isChecked()) {
					kitchenDishesByHandYesNo = 0;
				}

				int literkitchenDishesByHand = 0;
				if (kitchenDishesByHand == 1) {
					literkitchenDishesByHand = kitchenDishesByHandYesNo == 1 ? 19
							: 11;
				} else if (kitchenDishesByHand == 2) {
					literkitchenDishesByHand = kitchenDishesByHandYesNo == 1 ? 23
							: 15;
				} else if (kitchenDishesByHand == 3) {
					literkitchenDishesByHand = kitchenDishesByHandYesNo == 1 ? 26
							: 18;
				} else if (kitchenDishesByHand >= 4) {
					literkitchenDishesByHand = kitchenDishesByHandYesNo == 1 ? 31
							: 21;
				}
				double FCountPeople = 0;

				if (CountPeople == 1) {
					FCountPeople = 1;
				}
				if (CountPeople == 2) {
					FCountPeople = 1.4;
				}
				if (CountPeople == 3) {
					FCountPeople = 1.7;
				}
				if (CountPeople == 4) {
					FCountPeople = 2;
				}
				if (CountPeople == 5) {
					FCountPeople = 2.2;
				}
				if (CountPeople == 6) {
					FCountPeople = 2.4;
				}
				if (CountPeople == 7) {
					FCountPeople = 2.5;
				}
				if (CountPeople == 8) {
					FCountPeople = 2.6;
				}
				if (CountPeople == 9) {
					FCountPeople = 2.7;
				}
				if (CountPeople == 10) {
					FCountPeople = 2.8;
				}
				int kitchenWashVegetables = 0;
				if (spinner1.getSelectedItemPosition() == 0) {
					kitchenWashVegetables = 2;
				} else if (spinner1.getSelectedItemPosition() == 1) {
					kitchenWashVegetables = 3;
				} else if (spinner1.getSelectedItemPosition() == 2) {
					kitchenWashVegetables = 5;
				}
				StaticValue.LiterKitchenCalc = ((int) ((int) ((literkitchenDishesByHand * FCountPeople)
						+ (kitchenDishwasher * FCountPeople) + (kitchenWashVegetables * FCountPeople)) + (FCountPeople * 10)));

				StaticValue.LiterCalc = StaticValue.LiterKitchenCalc;
				StaticValue.LiterMain = StaticValue.LiterKitchenMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_3AshpazKhane.this,
						ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
