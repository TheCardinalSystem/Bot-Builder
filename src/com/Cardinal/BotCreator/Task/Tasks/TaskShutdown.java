package com.Cardinal.BotCreator.Task.Tasks;

import com.Cardinal.BotCreator.Task.ITask;

/**
 * Shutdowns the program, runs all save methods.
 * 
 * @author Cardinal System
 *
 */
public class TaskShutdown implements ITask {

	/**
	 * Shutdowns the program and runs all save methods.
	 */
	@Override
	public ITask[] runTask() {
		System.exit(0);
		return null;
	}

}
