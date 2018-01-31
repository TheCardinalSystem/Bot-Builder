package com.Cardinal.BotCreator.Gui.Components.Cells.Editor.File;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCellHandler;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;
import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.File.TaskChangeFile;
import com.Cardinal.BotCreator.Task.Runtime.TaskUnknownError;

/**
 * A {@link HierarchyCell} used to edit and/or view the contents of a file.
 * 
 * @author Cardinal System
 *
 */
public class FileContent implements HierarchyCell {

	/**
	 * The file which this is to bind to.
	 */
	private File file;
	/**
	 * A panel used to display extra controls in the {@link EditorTextField}.
	 */
	JPanel panel = new JPanel(new BorderLayout());

	/**
	 * Constructs a new {@link FileContent} cell.
	 * 
	 * @param file
	 *            the file to bind to.
	 */
	public FileContent(File file) {
		this.file = file;
	}

	@Override
	public ImageIcon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Content";
	}

	@Override
	public HierarchyCell[] getChildren() {
		return null;
	}

	/**
	 * Displays the file's contents and the option to edit them.
	 */
	@Override
	public void open(JList<HierarchyCell> listIn, EditorTextField textDisplay, HierarchyCellHandler handlerIn) {
		try {
			String lines = Files.readAllLines(file.toPath()).stream().collect(Collectors.joining("\n"));
			textDisplay.setDisplayText(lines);
			JButton edit = new JButton("Edit"), update = new JButton("Save");
			edit.setEnabled(true);
			update.setEnabled(false);
			edit.addActionListener(e -> {
				textDisplay.getTextDisplay().setEditable(true);
				edit.setEnabled(false);
				update.setEnabled(true);
			});
			update.addActionListener(e -> {
				textDisplay.getTextDisplay().setEditable(false);
				edit.setEnabled(true);
				update.setEnabled(false);
				TaskManager.queue(new TaskChangeFile(file, textDisplay.getTextDisplay().getText().split("\n")));
			});
			panel.add(edit, BorderLayout.WEST);
			panel.add(update, BorderLayout.EAST);
			textDisplay.displayTextDisplay();
			textDisplay.add(panel, BorderLayout.SOUTH);
		} catch (IOException e) {
			e.printStackTrace();
			TaskManager.queue(new TaskUnknownError(e));
		}
	}

	/**
	 * Removes the extra controls and closed the {@link EditorTextField}.
	 */
	@Override
	public void close(JList<HierarchyCell> listIn, EditorTextField textDisplay) {
		textDisplay.remove(panel);
		textDisplay.displayNone();
	}

}
