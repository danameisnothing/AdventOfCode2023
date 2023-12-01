package com.testnow720.adventofcode2023.Day1.Part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Part2 {
	final String[][] possibleLetterDigits = {
			{"one", "1"},
			{"two", "2"},
			{"three", "3"},
			{"four", "4"},
			{"five", "5"},
			{"six", "6"},
			{"seven", "7"},
			{"eight", "8"},
			{"nine", "9"}
	};
	
	public void run() throws IOException {
		int start = (int) System.nanoTime();
		
		File input = new File("src\\com\\testnow720\\adventofcode2023\\Day1\\Part2\\input.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(input));
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		String nextLineBuffer;
		while ((nextLineBuffer = fileReader.readLine()) != null) {
			// Spaghetti moment
			ArrayList<Character> tempNum = new ArrayList<Character>();
			ArrayList<Integer> tempNumIndex = new ArrayList<Integer>();
			
			char[] lineContent = nextLineBuffer.toCharArray();
			
			System.out.println("Current line : " + nextLineBuffer);
			
			// Raw number parsing
			for (int i = 0; i < lineContent.length; i++) {
				// bruh what is this double conversion shit
				// this is the most regex i've done lololololol
				if (String.valueOf(lineContent[i]).matches("[\\d]")) {
					tempNum.add(lineContent[i]);
					tempNumIndex.add(i);
				}
			}
			
			// Digit number parsing
			for (int i = 0; i < possibleLetterDigits.length; i++) {
				// make sure they are the same
				int index = nextLineBuffer.indexOf(possibleLetterDigits[i][0]);
				int lastIndex = nextLineBuff er.lastIndexOf(possibleLetterDigits[i][0]);
				if (index != -1 && lastIndex != -1) {
					// Dirty fix but oh well
					if (index == lastIndex) {
						System.out.println(possibleLetterDigits[i][0] + " found at index " + index);
						tempNum.add(possibleLetterDigits[i][1].toCharArray()[0]);
						tempNumIndex.add(index);
					} else {
						System.err.println("indexOf and lastIndexOf not same!!!");
						tempNum.add(possibleLetterDigits[i][1].toCharArray()[0]);
						tempNumIndex.add(index);
						tempNum.add(possibleLetterDigits[i][1].toCharArray()[0]);
						tempNumIndex.add(lastIndex);
					}
				}
			}
			
			if (tempNumIndex.indexOf(Collections.min(tempNumIndex)) != tempNumIndex.indexOf(Collections.max(tempNumIndex))) {
				//nums.add(Integer.parseInt( String.valueOf( tempNum.get(tempNumIndex.indexOf(Collections.min(tempNumIndex))) ).concat( String.valueOf( tempNum.get(tempNumIndex.indexOf(Collections.max(tempNumIndex))) ) )  ));
			} else {
				//System.err.println("SAME, CONCATENATING SAME NUM");
				//nums.add(tempNum.get(tempNumIndex.indexOf(Collections.max(tempNumIndex)))  +   tempNum.get(tempNumIndex.indexOf(Collections.max(tempNumIndex)))); // test
			}
			
			nums.add(Integer.parseInt( String.valueOf( tempNum.get(tempNumIndex.indexOf(Collections.min(tempNumIndex))) ).concat( String.valueOf( tempNum.get(tempNumIndex.indexOf(Collections.max(tempNumIndex))) ) )  ));
			
			// Assumptions
			System.out.println("Number : " + nums.get(nums.size() - 1));
			System.out.println();
		}
		
		fileReader.close();
		
		int total = 0;
		for (Integer value : nums) {
			total += value;
		}
		
		System.out.println("Total : " + total);
		
		System.out.println("Took " + ((int) System.nanoTime() - start) * 1e-9 + "s");
	}
}
