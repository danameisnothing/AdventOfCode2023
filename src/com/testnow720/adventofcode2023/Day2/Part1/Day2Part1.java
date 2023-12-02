package com.testnow720.adventofcode2023.Day2.Part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2Part1 {
	final int[] possibleCubes = {
			12, // red
			13, // green
			14 // blue
	};
	public void run() throws IOException {
		int start = (int) System.nanoTime();
		
		File input = new File("src\\com\\testnow720\\adventofcode2023\\Day2\\Part1\\input.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(input));
		
		ArrayList<Integer> totalGameIdPossible = new ArrayList<Integer>();
		
		String nextLineBuffer;
		while ((nextLineBuffer = fileReader.readLine()) != null) {
			String gameData = nextLineBuffer.substring(nextLineBuffer.indexOf(":") + 2);
			String gameId = nextLineBuffer.substring(nextLineBuffer.indexOf("e") + 2, nextLineBuffer.indexOf(":")); // "e" gets the "e" from "Game"
			boolean isPossible = true;
			
			String[] gameResPerPart = gameData.split("[\\\\s;]+");
			
			// Strip it even further
			for (int i = 0; i < gameResPerPart.length; i++) {
				String[] gameRes = gameResPerPart[i].strip().split("[\\\\s,]+");
				
				int redCount = 0;
				int greenCount = 0;
				int blueCount = 0;
				
				for (String e : gameRes) {
					String data = e.strip();
					
					String currIndexCount = data.substring(0, data.indexOf(" "));
					String currCube = data.substring(data.indexOf(" ") + 1);
					
					switch (currCube) {
						case "red":
							redCount += Integer.parseInt(currIndexCount);
							break;
						case "green":
							greenCount += Integer.parseInt(currIndexCount);
							break;
						case "blue":
							blueCount += Integer.parseInt(currIndexCount);
							break;
					}
				}
				
				if (redCount > possibleCubes[0] || greenCount > possibleCubes[1] || blueCount > possibleCubes[2]) {
					isPossible = false;
					break;
				}
				
				System.out.println("Game ID " + gameId + " section " + i + " : \nRed cube : " + redCount + "\nGreen cube : " + greenCount + "\nBlue count : " + blueCount + "\nisPossible : " + isPossible);
				System.out.println();
			}
			
			if (!isPossible) {
				System.out.println("Game NOT possible for game ID " + gameId);
			} else {
				System.out.println("Game possible for game ID " + gameId);
				totalGameIdPossible.add(Integer.parseInt(gameId));
			}
			
			System.out.println();
			System.out.println();
			
			
			// Strip whitespace for index 1 and above
			/*for (int i = 0; i < gameRes.length; i++) {
				gameRes[i] = gameRes[i].strip();
			}*/
			
			
			/*System.out.println(gameData);
			System.out.println(gameId);*/
		}
		
		fileReader.close();
		
		int total = 0;
		for (int value : totalGameIdPossible) {
			total += value;
		}
		
		System.out.println("Total : " + total);
		
		System.out.println("Took " + ((int) System.nanoTime() - start) * 1e-9 + "s");
	}
}
