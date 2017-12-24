package com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus;

import javax.swing.JMenu;

import com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.Items.ItemProject;

/**
 * One of the default sub-menus of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see MenuNew#MenuNew(JMenu)
 */
public class MenuNew extends JMenu {

	private static final long serialVersionUID = -3296100597206545030L;

	/**
	 * The parent {@link JMenu} of this sub-menu.
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenu} with an {@link ItemProject} item.
	 * 
	 * @param parent
	 *            the parent {@link JMenu} of this sub-menu.
	 */
	public MenuNew(JMenu parent) {
		super("New");
		this.parent = parent;
		this.add(new ItemProject(this));
	}

	/**
	 * Gets the parent {@link JMenu} of this sub-menu.
	 * 
	 * @return the parent {@link JMenu} of this sub-menu.
	 * @see MenuNew#MenuNew(JMenu)
	 */
	public JMenu getParent2() {
		return this.parent;
	}
}
