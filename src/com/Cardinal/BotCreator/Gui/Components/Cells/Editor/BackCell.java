package com.Cardinal.BotCreator.Gui.Components.Cells.Editor;

import javax.swing.ImageIcon;
import javax.swing.JList;

import com.Cardinal.BotCreator.AssetLibraries.ImageLibrary;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;
import com.Cardinal.BotCreator.Utils.ImageUtils;

/**
 * The default cell to be added to the end of every cell list.
 * 
 * @author Cardinal System
 *
 */
public class BackCell implements HierarchyCell {

	/**
	 * A vertically flipped copy of {@link ImageLibrary#YELLOW_ARROW}.
	 */
	private static final ImageIcon icon = new ImageIcon(ImageUtils.flip(ImageLibrary.YELLOW_ARROW.getImage(), false));

	/**
	 * The {@link HierarchyCellHandler} which is assigned to this cell's cell
	 * hierarchy.
	 */
	private HierarchyCellHandler handler;

	/**
	 * Constructs a new {@link BackCell}.
	 * @param handler {@link BackCell#handler}
	 */
	public BackCell(HierarchyCellHandler handler) {
		this.handler = handler;
	}

	@Override
	public ImageIcon getIcon() {
		return icon;
	}

	@Override
	public String getName() {
		return "Back";
	}

	@Override
	public HierarchyCell[] getChildren() {
		return null;
	}

	/**
	 * Invokes {@link HierarchyCellHandler#goBack()}.
	 */
	@Override
	public void open(JList<HierarchyCell> listIn, EditorTextField textDisplay, HierarchyCellHandler handlerIn) {
		handler.goBack();
	}

	@Override
	public void close(JList<HierarchyCell> listIn, EditorTextField textDisplay) {
	}

}
