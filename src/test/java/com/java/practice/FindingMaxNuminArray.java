package com.java.practice;

import java.util.Set;
import java.util.TreeSet;

public class FindingMaxNuminArray {

	public static void main(String[] args) {
		int[] num = {3,6,9,3,98,87,23,900,4,11,8,456,89900};
		int temp =0;
		int max = 0;
		
		for (int i = 0; i < num.length; i++) {
			if(num[i] > max) {
				max = num[i];
			}
		}
		
		System.out.println("The maximum number is : "+max);
		
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j <= num.length-1; j++) {
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		System.out.println("\n" + "The maximum number is : " + num[num.length-1]);
		
		
		
		int[] num1 = {3,6,9,3,98,87,23,900,4,11,8,456};
		
		Set<Integer> maxNumArray= new TreeSet<Integer>();
		
		for (int i = 0; i < num1.length; i++) {
			maxNumArray.add(num1[i]);
		}
		
		System.out.println("\n" + "The maximum number is : " + maxNumArray);
		
		
	}
	
	
	

}
