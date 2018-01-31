package com.Cardinal.BotCreator.Task.Runtime;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Cardinal.BotCreator.Task.ITask;

/**
 * Restarts the program, runs all save methods.
 * 
 * @author Cardinal System
 *
 */
public class TaskRestart implements ITask {

	/**
	 * Restarts the application and runs all save methods.
	 */
	@Override
	public ITask[] runTask() {
		try {
			new File(System.getProperty("user.dir") + "/files/downloaded").delete();
			final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
			final File currentJar = new File(
					this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());

			if (!currentJar.getName().endsWith(".jar")) {
				throw new IOException("Program is not running from a JAR.");
			}

			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(currentJar.getPath());

			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
			System.exit(0);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
			return ITask.merge(() -> {
				int choice = JOptionPane
						.showConfirmDialog(null,
								"Restart failed. Do you wish to close instad?\n\nCaused by:\n"
										+ e.getClass().getSimpleName() + ": " +  e.getMessage(),
								"Restart", JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION)
					return ITask.merge(new TaskShutdown());

				return null;
			});
		}
		return null;
	}

}
