package com.lm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lm.command.CommandFactory;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CommandFactory cf = CommandFactory.getInstance();
		LockedMe.createInstance();
		while(true){
			System.out.println("-> Type 'retrieve' to retrieve file name.");
			System.out.println("-> Type 'bo' to perform business operations.");
			System.out.println("-> Type 'close' to close the application.");
			String command = br.readLine();
			if("close".equals(command)) {
				System.out.println("Thank You for visit");
				break;
			}
				cf.execute(command);
		}

	}

}
