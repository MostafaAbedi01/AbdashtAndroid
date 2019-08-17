package com.VirtualWater;

import java.io.Serializable;

public class ItemDetailsVirtualWater implements Serializable {
	private static final long serialVersionUID = -5435670920302756945L;

	public ItemDetailsVirtualWater() {

	}

	public ItemDetailsVirtualWater(String name, String itemDescription,
			String unit, int imageNumber) {
		this.setName(name);
		this.setItemDescription(itemDescription);
		this.setUnit(unit);
		this.setImageNumber(imageNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSubResult() {
		return subResult;
	}

	public void setSubResult(String subResult) {
		this.subResult = subResult;
	}

	private int value;
	private String name;
	private String itemDescription;
	private String unit;
	private String subResult;
	private int imageNumber;

}
