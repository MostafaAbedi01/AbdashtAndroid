package com.CalculateWaterUse;

import java.util.ArrayList;
import java.util.List;

import org.codeandmagic.android.gauge.demo.ActivityGaugeViewOther;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityList4_3School extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	EditText txtValue;
	private Spinner spinner1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity4_3school);

		setvalue(2);
		txtValue = (EditText) findViewById(R.id.txtValue);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		btnResult = (ImageView) findViewById(R.id.btnResult);

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add("روزانه");
		objlist.add("شبانه روزی");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int countShower = 0;
				String valStr = txtValue.getText().toString();
				if (!valStr.equals(""))
					countShower = Integer.parseInt(valStr);
				else {
					Toast.makeText(getBaseContext(),
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}
				double spinnervalue = 0;
				if (spinner1.getSelectedItemPosition() == 0) {
					spinnervalue = 15;
				} else if (spinner1.getSelectedItemPosition() == 1) {
					spinnervalue = 120;
				}

				StaticValue.LiterShowerCalc = (int) (countShower * spinnervalue);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(ActivityList4_3School.this,
						ActivityGaugeViewOther.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
