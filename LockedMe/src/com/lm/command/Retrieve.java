package com.lm.command;

import java.util.List;

import com.lm.main.LockedMe;

public class Retrieve extends Command {

	@Override
	public void execute(String commandName) {
		// TODO Auto-generated method stub
		LockedMe lm = LockedMe.getInstance();
		List<String> files = lm.getFiles();
		for(String file : files) {
			System.out.println(file);
		}

	}

	@Override
	public boolean validate(String commandName) {
		// TODO Auto-generated method stub
		return true;
	}

}
