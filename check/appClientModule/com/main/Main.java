package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
			System.out.println("In");
		File file=
				new File("C:\\app\\rnaraboy1\\admin\\orcl\\dpdump\\oipa-dev2-11-21-2017-22_00_01.dmp"); 
//		Scanner scanner=new Scanner(file);
//		FileInputStream fileInputStream=new FileInputStream(file);
		FileReader fileReader = new FileReader(file);
		boolean flag=true;
		int i=0;
		System.out.println("Before loop ");
//		fileReader.read();
		while(true){
			i=(char)fileReader.read();
			System.out.print((char)i);
		
//			if(i==10){
//				System.out.println((char)i);
//				break;
//			}
		}
		
	}

}
