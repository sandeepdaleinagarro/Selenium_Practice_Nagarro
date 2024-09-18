package com.selenium.practice;

public class IntegerCaching {

	public static void main(String[] args) {
		Integer num1  = 127;
		Integer num2 = 127;
		
		if(num1 == num2) {
			System.out.println("both are equal");
		}else {
			System.out.println("both are not equal");
		}
	}
}
