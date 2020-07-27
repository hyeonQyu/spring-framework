package com.nextwin.ex;

public class MyCalculator {
	private Calculator calculator;
	private int first;
	private int second;
	
	public void add() {
		calculator.addition(first, second);
	}
	
	public void sub() {
		calculator.substraction(first, second);
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void setFirst(int first) {
		this.first = first;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
}
