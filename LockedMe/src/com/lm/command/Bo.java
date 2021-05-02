package com.lm.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lm.main.LockedMe;

public class Bo extends Command {

	@Override
	public void execute(String commandName) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CommandFactory cf = CommandFactory.getInstance();
		while(true){
			System.out.println("-> Type 'add <filename>' to add a file.");
			System.out.println("-> Type 'delete <filename>' to delete a file.");
			System.out.println("-> Type 'search <filename>' to search a file.");
			System.out.println("-> Type 'close' to close the Business Operations menu.");
			String command = null;
			try {
				command = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("close".equals(command)) {
				break;
			}
			cf.execute(command);
		}

	}

	@Override
	public boolean validate(String commandName) {
		// TODO Auto-generated method stub
		return false;
	}

}
