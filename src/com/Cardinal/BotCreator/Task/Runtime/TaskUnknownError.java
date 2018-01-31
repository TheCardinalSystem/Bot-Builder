package com.Cardinal.BotCreator.Task.Runtime;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import com.Cardinal.BotCreator.Task.ITask;

/**
 * A task used to display an known error to the user. They will be prompted to
 * continue or close the program.
 * 
 * @author Cardinal System
 *
 */
public class TaskUnknownError implements ITask {

	/**
	 * The unknown error.
	 */
	private Exception e;

	/**
	 * Constructs a new {@link TaskUnknownError}.
	 * 
	 * @param exception
	 *            the unknown error.
	 */
	public TaskUnknownError(Exception exception) {
		this.e = exception;
	}

	@Override
	public ITask[] runTask() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String error = sw.toString();

		JOptionPane.showConfirmDialog(null, "An unknown error was encountered:\n" + error, "Unknown Error",
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
		int i = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "Unknown Error",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i != JOptionPane.YES_OPTION)
			return ITask.merge(new TaskShutdown());
		else
			return null;
	}

}
