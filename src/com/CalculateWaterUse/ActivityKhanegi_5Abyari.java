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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityKhanegi_5Abyari extends ExtendActivityCountPeople {

	private ImageView btnResult;
	private Vibrator vibre;
	private SeekBar SeekBarQ1;
	private TextView txtSeekBarQ1;
	EditText txtValue;
	private Spinner spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khanegi_5abyari);

		setvalue(2);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		SeekBarQ1 = (SeekBar) findViewById(R.id.SeekBarQ1);
		txtSeekBarQ1 = (TextView) findViewById(R.id.txtSeekBarQ1);
		txtSeekBarQ1.setText(SeekBarQ1.getProgress() + "  دقیقه در روز ");
		txtValue = (EditText) findViewById(R.id.txtValue);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("شلنگ آب");
		objlist.add("آبپاش و فواره");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		SeekBarQ1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue,
					boolean fromUser) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  دقیقه در روز ");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  دقیقه در روز ");
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				txtSeekBarQ1.setText(seekBar.getProgress() + "  دقیقه در روز ");

			}
		});

		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				SeekBarCountPeople = (SeekBar) findViewById(R.id.SeekBarCountPeople);
				int CountPeople = SeekBarCountPeople.getProgress();

				int gardenAreaCountHome = 0;
				String valStr = txtValue.getText().toString();
				if (!valStr.equals(""))
					gardenAreaCountHome = Integer.parseInt(valStr);
				else {
					Toast.makeText(getBaseContext(),
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}

				int season = SeekBarQ1.getProgress();

				int gardenAreaType;
				StaticValue.LiterGardenAreaCalc = (int) (((gardenAreaCountHome) / 7 + season * 15) / CountPeople);
				StaticValue.LiterCalc = StaticValue.LiterGardenAreaCalc;
				StaticValue.LiterMain = StaticValue.LiterGardenAreaMain;
				Intent localIntentLock = new Intent(
						ActivityKhanegi_5Abyari.this, ActivityGaugeView.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}

}
