package com.Cardinal.BotCreator.Gui.Components.Cells.Editor.File;

import java.io.File;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JList;

import com.Cardinal.BotCreator.AssetLibraries.ImageLibrary;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCellHandler;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;

/**
 * A {@link HierarchyCell} used to represent a file.
 * 
 * @author Cardinal System
 *
 */
public class FileCell implements HierarchyCell {

	/**
	 * The file this cell represents.
	 */
	private File file;
	/**
	 * The {@link FileName} child-cell of this cell.
	 */
	private FileName name;
	/**
	 * The {@link FileContent} child-cell of this cell.
	 */
	private FileContent content;
	/**
	 * This cell's icon.
	 * 
	 * @see ImageLibrary#FILE
	 */
	private static ImageIcon ICON = new ImageIcon(ImageLibrary.FILE.getImage());

	/**
	 * Constructs a new {@link FileCell} and binds it to the given file.
	 * 
	 * @param file
	 *            the file to bind to.
	 * @throws IllegalAccessException
	 *             thrown if the given file is a directory.
	 */
	public FileCell(File file) throws IllegalAccessException {
		if (file.isDirectory())
			throw new IllegalAccessException("Directories are allowed in FileCells!");
		this.file = file;
		name = new FileName(file, this);
		content = new FileContent(file);
	}

	/**
	 * Changes the file which this is to represent.
	 * 
	 * @param f
	 *            the new file.
	 * @deprecated Only to be called by {@link FileCell#name}.
	 */
	@Deprecated
	public void setFile(File f) {
		this.file = f;
		this.content = new FileContent(f);
	}

	@Override
	public ImageIcon getIcon() {
		return ICON;
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public HierarchyCell[] getChildren() {
		return HierarchyCell.merge(content, name);
	}

	@Override
	public void open(JList<HierarchyCell> listIn, EditorTextField textDisplay, HierarchyCellHandler handlerIn) {
		handlerIn.open(this);
	}

	@Override
	public void close(JList<HierarchyCell> listIn, EditorTextField textDisplay) {
		Arrays.stream(getChildren()).forEach(c -> c.close(listIn, textDisplay));
	}

}
