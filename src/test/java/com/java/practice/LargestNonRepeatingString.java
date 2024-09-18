package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class LargestNonRepeatingString {

	public static void main(String[] args) {
		String word = "asdfghjkialkjshgdgf";

		char[] charArray = word.toCharArray();
		ArrayList<String> charList= new ArrayList<String>();
		ArrayList<String> charListFinal= new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int maxLength = 0;

		for (int i = 0; i < charArray.length-1; i++) {
			charList.add(Character.toString(charArray[i]));
			for (int j = i+1; j < charArray.length; j++) {
				if(!Character.toString(charArray[i]).equals(Character.toString(charArray[j]))) {
					charList.add(Character.toString(charArray[j]));
				}else break;
			}

			if(charList.size() > maxLength) {
				charListFinal.clear();
				charListFinal.addAll(charList);
				maxLength = charList.size();
			}
			charList.clear();
		}
		
		for (String letters : charListFinal) {
			sb.append(letters);
		}

		System.out.println("The maximum non repeating string is : "+ sb.toString());

	}
	
	@Test
	public void correctProcedureUsingMap() {
		String word = "asdfghjkialkjshgdgf";
		
		int maxLength = 0;
		String nonRepeatingWord = null;
		
		Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
		
		char[] charArray = word.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			
			
			if(!charMap.containsKey(charArray[i])) {
				charMap.put(charArray[i], i);
			}
			
			else {
				i = charMap.get(charArray[i]);
				charMap.clear();		
			}
			
			if(charMap.size() > maxLength) {
				maxLength = charMap.size();
				nonRepeatingWord = charMap.keySet().toString();
			}
		}
		
		System.out.println("The maximum non repeating string is : "+nonRepeatingWord);
	}

}
