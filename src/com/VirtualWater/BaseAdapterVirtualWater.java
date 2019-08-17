package com.VirtualWater;

import java.util.List;

import IranSoftjo.Abdasht.R;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseAdapterVirtualWater extends
		ArrayAdapter<ItemDetailsVirtualWater> {

	protected static final String LOG_TAG = BaseAdapterVirtualWater.class
			.getSimpleName();

	private List<ItemDetailsVirtualWater> items;
	private int layoutResourceId;
	private Context context;

	public BaseAdapterVirtualWater(Context context, int layoutResourceId,
			List<ItemDetailsVirtualWater> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		AtomPaymentHolder holder = null;

		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);

		holder = new AtomPaymentHolder();
		holder.atomPayment = items.get(position);
		holder.removePaymentButton = (ImageButton) row
				.findViewById(R.id.atomPay_removePay);
		holder.removePaymentButton.setTag(holder.atomPayment);
		holder.name = (TextView) row.findViewById(R.id.atomPay_name);
		holder.value = (TextView) row.findViewById(R.id.atomPay_value);
		holder.unit = (TextView) row.findViewById(R.id.lblunit);
		holder.subResult = (TextView) row.findViewById(R.id.lblSubResult);
		holder.itemDescription = (TextView) row
				.findViewById(R.id.lblitemDescription);
		holder.imageNumber = (ImageView) row.findViewById(R.id.imgphoto);
		setValueTextListeners(holder);
		row.setTag(holder);
		setupItem(holder);
		return row;
	}

	private void setupItem(AtomPaymentHolder holder) {
		holder.name.setText(holder.atomPayment.getName());
		if (holder.atomPayment.getValue() > 0) {
			holder.value.setText(String.valueOf(holder.atomPayment.getValue()));
		} else {
			holder.value.setText("");
		}
		holder.unit.setText(holder.atomPayment.getUnit());
		holder.itemDescription.setText(holder.atomPayment.getItemDescription());
		holder.subResult.setText(holder.atomPayment.getSubResult());
		holder.imageNumber
				.setImageResource(holder.atomPayment.getImageNumber());
	}

	public static class AtomPaymentHolder {
		ItemDetailsVirtualWater atomPayment;
		TextView name;
		TextView value;
		ImageButton removePaymentButton;
		TextView itemDescription;
		TextView unit;
		TextView subResult;
		ImageView imageNumber;
	}

	private void setValueTextListeners(final AtomPaymentHolder holder) {
		holder.value.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try {
					holder.atomPayment.setValue(Integer.parseInt(s.toString()));
				} catch (NumberFormatException e) {
					Log.e(LOG_TAG,
							"error reading double value: " + s.toString());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}
}
