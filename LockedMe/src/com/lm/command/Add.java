package com.lm.command;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lm.main.LockedMe;

public class Add extends Command {

	@Override
	public void execute(String commandName){
		// TODO Auto-generated method stub
		if(!validate(commandName)) {
			System.err.println("Invalid add command.");
			return;
		}
		
		String filename = commandName.split(" ")[1];
		LockedMe lm = LockedMe.getInstance();
		
		File loc = new File(lm.getProjDir());
		
		if(!loc.exists()) {
			System.err.println("Location to add files doesn't exist.");
			return;
		}
		
		File file = new File(lm.getProjDir() + "/" + filename);
		if(file.exists()) {
			System.err.println("File already exists.");
			return;
		}
		
		try {
			if(file.createNewFile()) {
				System.out.println("File created.");
				if(lm.getFiles().size() == 0) {
					lm.getFiles().add(filename);
					return;
				}
				
				List<String> files = lm.getFiles();
				for(int i = 0 ; i < files.size() ; i++) {
					if(filename.compareTo(files.get(i)) <= 0) {
						files.add(i, filename);
						return;
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Problem in adding the file.");
		}
		
		
	}

	@Override
	public boolean validate(String commandName) {
		// TODO Auto-generated method stub
		if(commandName.split(" ").length != 2)
			return false;
		return true;
	}

}
