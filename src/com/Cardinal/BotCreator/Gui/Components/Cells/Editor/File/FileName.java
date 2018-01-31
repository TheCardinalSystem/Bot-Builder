package com.Cardinal.BotCreator.Gui.Components.Cells.Editor.File;

import java.io.File;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JList;

import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCellHandler;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;
import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.File.TaskRenameFile;

/**
 * A {@link HierarchyCell} used to display and edit a file name.
 * 
 * @author Cardinal System
 *
 */
public class FileName implements HierarchyCell {

	/**
	 * The file which this cell is bound to.
	 */
	private File file;
	/**
	 * The parent {@link FileCell} of this cell.
	 */
	private FileCell parent;

	/**
	 * Constructs a new {@link FileName} cell.
	 * 
	 * @param file
	 *            the file to bind to.
	 * @param ourParent
	 *            the {@link FileCell} parent of this cell.
	 */
	public FileName(File file, FileCell ourParent) {
		this.file = file;
		this.parent = ourParent;
	}

	@Override
	public ImageIcon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public HierarchyCell[] getChildren() {
		return null;
	}

	/**
	 * Prompts the user to edit the file name.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void open(JList<HierarchyCell> listIn, EditorTextField textDisplay, HierarchyCellHandler handlerIn) {
		Arrays.stream(parent.getChildren()).forEach(c -> {
			if (c instanceof FileContent) {
				try {
					c.close(listIn, textDisplay);
				} catch (NullPointerException e) {
				}
			}
		});

		textDisplay.setFieldText(file.getName());
		textDisplay.setFieldListener(e -> {
			String newName = textDisplay.getField().getText();
			TaskManager.queue(new TaskRenameFile(file, newName));
			file = new File(file.getParentFile(), newName);
			parent.setFile(file);
			handlerIn.goBack();
		});
		textDisplay.displayField();
	}

	@Override
	public void close(JList<HierarchyCell> listIn, EditorTextField textDisplay) {
		textDisplay.displayNone();
	}

}
