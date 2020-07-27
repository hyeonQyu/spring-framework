package com.nextwin.ex;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BmiCalculator bmiCalculator;
	
	private void calculateBmi() {
		bmiCalculator.bmiCalculate(weight, height);
	}
	
	public void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobbys);
		calculateBmi();
	}
	
	public BmiCalculator getBmiCalculator() {
		return bmiCalculator;
	}
	
	public void setBmiCalculator(BmiCalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
}
