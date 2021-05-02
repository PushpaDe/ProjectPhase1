package com.lm.command;

public class CommandFactory {
	static CommandFactory cf = null;
	private CommandFactory() {
		
	}
	
	public static CommandFactory getInstance() {
		if(cf == null) {
			return cf = new CommandFactory();
		}
		return cf;
	}
	
	private CommandName getCommandName(String commandString) {
		CommandName cn = null;
		if(commandString==null)
		{
			cn=CommandName.valueOf("invalid");
		}
		if(commandString == null) {
			System.out.println("Not a valid command");
		}else {
			String[] split = commandString.split(" ");
			if("".equals(split[0])){
				System.out.println("Not a valid command");
			}else {
				try {
					cn = CommandName.valueOf(split[0]);
				}catch(Exception e) {
					System.out.println("Unknow command");
				}
			}
		}
		return cn!=null? cn:CommandName.valueOf("invalid");
	}
	
	public void execute(String commandString) {
		CommandName cn = null;
		Command cm = null;
		cn = getCommandName(commandString);
		switch(cn) {
		
		case retrieve:
			cm = new Retrieve();
			break;
		
		case bo:
			cm = new Bo();
			break;
			
		case add:
			cm = new Add();
			break;
			
		case delete:
			cm = new Delete();
			break;
		
		case search:
			cm = new Search();
			break;
		case invalid:
			break;
		default:
			break;
		}
		
		if(cm == null) {
			return;
		}
		
		cm.execute(commandString);
					
	}
	
	private enum CommandName {
		retrieve,
		bo,
		add,
		delete,
		search,
		invalid
		
	}
}
