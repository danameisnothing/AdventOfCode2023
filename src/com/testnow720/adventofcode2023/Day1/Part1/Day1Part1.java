package com.testnow720.adventofcode2023.Day1.Part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Part1 {
	public void run() throws IOException {
		int start = (int) System.nanoTime();
		
		File input = new File("src\\com\\testnow720\\adventofcode2023\\Day1\\Part1\\input.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(input));
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		String nextLineBuffer;
		while ((nextLineBuffer = fileReader.readLine()) != null) {
			ArrayList<Character> tempNum = new ArrayList<Character>();
			char[] lineContent = nextLineBuffer.toCharArray();
			
			System.out.println("Current line : " + nextLineBuffer);
			
			for (int i = 0; i < lineContent.length; i++) {
				// bruh what is this double conversion shit
				if (String.valueOf(lineContent[i]).matches("[\\d]")) {
					tempNum.add(lineContent[i]);
				}
			}
			
			// reeeeeeeeeeeee
			nums.add(Integer.parseInt(String.valueOf(tempNum.get(0)).concat(String.valueOf(tempNum.get(tempNum.size() - 1)))));
			
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
