package com.Cardinal.BotCreator.Gui.Components.Cells.Default;

import javax.swing.ImageIcon;

import com.Cardinal.BotCreator.AssetLibraries.ImageLibrary;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCell;

/**
 * A {@link ComboBoxCell} used to represent {@link EventSubscriber
 * EventSubscriber} instances.
 * 
 * @author Cardinal System
 * @see EventCell#getName()
 * @see EventCell#getIcon()
 */
public class EventCell implements ComboBoxCell {

	/**
	 * The unchanging icon used for this cell.
	 * <img src="./doc-files/annotation_obj.png" />
	 */
	private static final ImageIcon ICON = new ImageIcon(ImageLibrary.ANNOTATION.getImage());

	/**
	 * The icon of this cell.
	 * 
	 * @see EventCell#ICON
	 */
	@Override
	public ImageIcon getIcon() {
		return ICON;
	}

	/**
	 * The name of this cell.
	 * 
	 * @return "Event Handler"
	 */
	@Override
	public String getName() {
		return "Event Handler";
	}

}
