package model;

import java.io.Serializable;

public class Health implements Serializable {
	private double height,weight,bmi;
	private String bodytype;

	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return this.bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBodytype() {
		return this.bodytype;
	}

	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}

	
	


}
