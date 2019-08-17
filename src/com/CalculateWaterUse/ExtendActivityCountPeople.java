package com.CalculateWaterUse;

import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ExtendActivityCountPeople extends ExtendActivityWithUp {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	public SeekBar SeekBarCountPeople;
	private TextView txtCountPeople;

	public void setvalue(int id) {

		Button btnLevel3 = (Button) findViewById(R.id.btnLevel3);
		Button btnLevel2 = (Button) findViewById(R.id.btnLevel2);
		Button btnLevel1 = (Button) findViewById(R.id.btnLevel1);
		ImageView photolevel2 = (ImageView) findViewById(R.id.photolevel2);

		if (id == 0) {
			btnLevel3.setVisibility(View.GONE);
			btnLevel2.setVisibility(View.GONE);
			photolevel2.setVisibility(View.GONE);

		}
		if (id == 1) {
			btnLevel3.setVisibility(View.GONE);
		}

		btnLevel3.setText(StaticValue.CalculateWaterUseLevel3);
		btnLevel2.setText(StaticValue.CalculateWaterUseLevel2);
		btnLevel1.setText(StaticValue.CalculateWaterUseLevel1);

		SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
		txtCountPeople = (TextView) findViewById(R.id.txtCountPeople);
		txtCountPeople.setText(SeekBarCountPeople.getProgress() + "  ‰›— ");
		SeekBarCountPeople
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progresValue, boolean fromUser) {
						txtCountPeople.setText(seekBar.getProgress() + "  ‰›— ");
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						txtCountPeople.setText(seekBar.getProgress() + "  ‰›— ");
					}

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						txtCountPeople.setText(seekBar.getProgress() + "  ‰›— ");

					}
				});
	}
}