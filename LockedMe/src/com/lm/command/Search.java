package com.lm.command;

import java.io.File;

import com.lm.main.LockedMe;

public class Search extends Command {

	@Override
	public void execute(String commandName) {
		// TODO Auto-generated method stub
		if(!validate(commandName)) {
			System.err.println("Invalid search command.");
			return;
		}
		
		String filename = commandName.split(" ")[1];
		LockedMe lm = LockedMe.getInstance();
		
		File loc = new File(lm.getProjDir());
		
		if(!loc.exists()) {
			System.err.println("Location to search files doesn't exist.");
			return;
		}
		
		File file = new File(lm.getProjDir() + "/" + filename);
		if(!file.exists()) {
			System.err.println("File doesn't exists.");
			return;
		}
		System.out.println("File exist in the system.");

	}

	@Override
	public boolean validate(String commandName) {
		// TODO Auto-generated method stub
		if(commandName.split(" ").length != 2)
			return false;
		return true;
	}

}
