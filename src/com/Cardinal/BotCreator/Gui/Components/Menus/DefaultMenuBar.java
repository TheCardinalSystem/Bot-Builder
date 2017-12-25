package com.Cardinal.BotCreator.Gui.Components.Menus;

import javax.swing.JMenuBar;

/**
 * The default {@link JMenuBar} for the bot creator GUI.
 * 
 * @author Cardinal System
 * @see DefaultMenuBar#DefaultMenuBar()
 */
public class DefaultMenuBar extends JMenuBar {

	private static final long serialVersionUID = 5874049073120337804L;

	/**
	 * Constructs a new {@link JMenuBar} with a {@link MenuFile} menu.
	 */
	public DefaultMenuBar() {
		super();
		this.add(new MenuFile());
	}
}
