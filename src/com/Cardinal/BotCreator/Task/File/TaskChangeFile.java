package com.Cardinal.BotCreator.Task.File;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;

import com.Cardinal.BotCreator.Task.ITask;
import com.Cardinal.BotCreator.Task.Runtime.TaskUnknownError;

/**
 * A task for changing the contents of a file.
 * 
 * @author Cardinal System
 *
 */
public class TaskChangeFile implements ITask {

	/**
	 * The file to change.
	 */
	private File file;
	/**
	 * The new content.
	 */
	private String[] lines;

	/**
	 * Changes the content of the given file to the given content.
	 * 
	 * @param file
	 *            the file to change.
	 * @param lines
	 *            the new content.
	 */
	public TaskChangeFile(File file, String[] lines) {
		this.file = file;
		this.lines = lines;
	}

	@Override
	public ITask[] runTask() {
		file.delete();
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			Arrays.stream(lines).forEach(writer::println);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return ITask.merge(new TaskUnknownError(e));
		}
		return null;
	}

}
