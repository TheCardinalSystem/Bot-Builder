package com.Cardinal.BotCreator.Task.File;

import java.io.File;

import com.Cardinal.BotCreator.Task.ITask;
import com.Cardinal.BotCreator.Task.Runtime.TaskUnknownError;

public class TaskRenameFile implements ITask {

	private File file;
	private String name;

	public TaskRenameFile(File file, String newName) {
		this.file = file;
		this.name = newName;
	}

	@Override
	public ITask[] runTask() {
		try {
			file.renameTo(new File(file.getParentFile(), name));
		} catch (Exception e) {
			return ITask.merge(new TaskUnknownError(e));
		}
		return null;
	}

}
