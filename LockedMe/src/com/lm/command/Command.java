package com.lm.command;

public abstract class Command {
	public abstract void execute(String commandName);
	public abstract boolean validate(String commandName); 
}
