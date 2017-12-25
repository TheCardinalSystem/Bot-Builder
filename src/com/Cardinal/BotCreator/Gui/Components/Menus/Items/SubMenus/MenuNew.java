package com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus;

import javax.swing.JMenu;

import com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.Items.ItemProject;

/**
 * One of the default sub-menus of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see MenuNew#MenuNew()
 */
public class MenuNew extends JMenu {

	private static final long serialVersionUID = -3296100597206545030L;

	/**
	 * Constructs a new {@link JMenu} with an {@link ItemProject} item.
	 */
	public MenuNew() {
		super("New");
		this.add(new ItemProject());
	}
}
