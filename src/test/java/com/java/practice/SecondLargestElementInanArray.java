package com.java.practice;


public class SecondLargestElementInanArray {

	public static void main(String[] args) {
		int[] numsArray = {12,0,5,8,9,3,5,6,7,5,100,98765,900,89,100,234,789,65,89};	
		
		int j = removeDuplicate(numsArray);
		
		for (int i = 0; i < j; i++) {
			System.out.print(numsArray[i]+ "  ");
		}
		
		System.out.println("\n"+"The 2nd largest element is : " + numsArray[j-2]);
	}
	
	public static int removeDuplicate(int[] numsArray) {
		//Arrays.sort(numsArray);
		
		for (int i = 0; i < numsArray.length-1; i++) {
			for (int j = i+1; j <= numsArray.length - 1; j++) {
				int temp;
				if(numsArray[i] > numsArray[j]) {
					temp = numsArray[i];
					numsArray[i] = numsArray[j];
					numsArray[j] = temp;
				}
			}
		}
		for (int i = 0; i <= numsArray.length - 1; i++) {
			System.out.print(numsArray[i]+"  ");
		}
		
		System.out.println("_________________");
		
		int temp[] = new int[numsArray.length];
		int j = 0;
		
		for (int i = 0; i < numsArray.length - 1; i++) {
			if(numsArray[i] != numsArray[i+1]) {
				temp[j] = numsArray[i];
				j = j+1;
			}
		}
		temp[j++] = numsArray[numsArray.length - 1];
		
		for (int i = 0; i < j; i++) {
			numsArray[i] = temp[i];
		}
		
		return j;
		
	}
}
