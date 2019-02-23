package com.eightfeatures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
	private final static String FILENAME = "file1.txt";

	public static void main(String[] args) {
		try (BufferedReader rd = new BufferedReader(new FileReader(FILENAME))) {
			String inputLine = null;

			while ((inputLine = rd.readLine()) != null)
				System.out.println(inputLine);
		} catch (IOException ex) {
			System.err.println("An IOException was caught: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}