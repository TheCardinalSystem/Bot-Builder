package com.Cardinal.BotCreator.Task;

import java.util.Arrays;
import java.util.Stack;

public class TaskManager {

	private static final Stack<ITask> QUEUE = new Stack<ITask>();
	public static final Executor EXECUTOR = new Executor();

	public static void queue(ITask task, ITask... tasks) {
		try{
			QUEUE.add(task);
		}catch(NullPointerException e) {
			if(Arrays.asList(tasks).isEmpty()) throw e;
		}
		Arrays.stream(tasks).forEach(QUEUE::add);
		
		if(!EXECUTOR.isAlive()) EXECUTOR.start();
	}

	private static class Executor extends Thread{
		@Override
		public void run() {
			while(!QUEUE.isEmpty()) {
				ITask[] results = QUEUE.pop().runTask();
				
				if(results == null || results.length < 1) 
					continue;
				
				queue(null, results);
			}
		}
	}
}
