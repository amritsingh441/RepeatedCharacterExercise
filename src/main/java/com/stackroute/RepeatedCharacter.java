package com.stackroute;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class RepeatedCharacter {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
		/*
		 * Accept a String from the console Display the most repeated character as shown
		 * in example section Display No characters repeated, if the String has no
		 * repeated characters or is empty
		 */
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();
    	Character character = findRepeatedCharacter(str);
    	if(character.equals('0')) {
    		System.out.println("No characters repeated");
    		
    	}else {
    		System.out.println(character);
    	}
    	
    	
	}

	public static Character findRepeatedCharacter(String input) {
		if(input != null && ! input.isEmpty()) {
			char [] charArr = input.toCharArray();
			Map<Character, Integer> charMap = new TreeMap<Character, Integer>();
			for (int i = 0; i < charArr.length; i++) {
				if(charMap.containsKey(charArr[i])) {
					charMap.put(charArr[i], charMap.get(charArr[i])+1);
				}else {
					charMap.put(charArr[i], 1);
				}
				
			}
			Map.Entry<Character, Integer> repeatedEntry = null;
			for (Entry<Character, Integer> entry : charMap.entrySet()) {
				if(repeatedEntry == null || entry.getValue().compareTo(repeatedEntry.getValue())>0) {
					
					repeatedEntry = entry;
				}
				
			}
			if(repeatedEntry.getValue() == 0) {
				return '0';
			}
			return repeatedEntry.getKey();
		}
		return '0';
	}
}