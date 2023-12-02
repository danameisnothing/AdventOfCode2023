package com.testnow720.adventofcode2023.Day2.Part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day2Part2 {
	final int[] possibleCubes = {
			12, // red
			13, // green
			14 // blue
	};
	public void run() throws IOException {
		int start = (int) System.nanoTime();
		
		File input = new File("src\\com\\testnow720\\adventofcode2023\\Day2\\Part2\\input.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(input));
		
		ArrayList<Integer> totalPower = new ArrayList<Integer>();
		
		String nextLineBuffer;
		while ((nextLineBuffer = fileReader.readLine()) != null) {
			String gameData = nextLineBuffer.substring(nextLineBuffer.indexOf(":") + 2);
			String gameId = nextLineBuffer.substring(nextLineBuffer.indexOf("e") + 2, nextLineBuffer.indexOf(":")); // "e" gets the "e" from "Game"
			
			String[] gameRes = gameData.split("[\\\\s,;]+");
			
			// Strip whitespace for index 1 and above
			for (int i = 0; i < gameRes.length; i++) {
				gameRes[i] = gameRes[i].strip();
			}
			
			ArrayList<Integer> redCount = new ArrayList<Integer>();
			ArrayList<Integer> greenCount = new ArrayList<Integer>();
			ArrayList<Integer> blueCount = new ArrayList<Integer>();
			
			for (String data : gameRes) {
				
				String currIndexCount = data.substring(0, data.indexOf(" "));
				String currCube = data.substring(data.indexOf(" ") + 1);
				
				switch (currCube) {
					case "red":
						redCount.add(Integer.parseInt(currIndexCount));
						break;
					case "green":
						greenCount.add(Integer.parseInt(currIndexCount));
						break;
					case "blue":
						blueCount.add(Integer.parseInt(currIndexCount));
						break;
				}
			}
			
			int maxRed = Collections.max(redCount);
			int maxGreen = Collections.max(greenCount);
			int maxBlue = Collections.max(blueCount);
			int power = maxRed * maxGreen * maxBlue;
			
			System.out.println("Game ID " + gameId + " : \nHighest red cube : " + maxRed + "\nHighest green cube : " + maxGreen + "\nHighest blue count : " + maxBlue + "\nCube power : " + power);
			System.out.println();
			
			totalPower.add(power);
			
			/*System.out.println(gameData);
			System.out.println(gameId);*/
		}
		
		fileReader.close();
		
		int total = 0;
		for (int value : totalPower) {
			total += value;
		}
		
		System.out.println("Total : " + total);
		
		System.out.println("Took " + ((int) System.nanoTime() - start) * 1e-9 + "s");
	}
}
