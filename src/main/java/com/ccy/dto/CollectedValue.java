package com.ccy.dto;

import java.util.Date;

public class CollectedValue {

	private double value;

	private Date time;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CollectedValue [value=" + value + ", time=" + time + "]";
	}

}
