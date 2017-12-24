package com.Cardinal.BotCreator.Gui.Components.Menus;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * The default {@link JMenuBar} for the bot creator GUI.
 * 
 * @author Cardinal System
 * @see DefaultMenuBar#DefaultMenuBar(JFrame)
 */
public class DefaultMenuBar extends JMenuBar {

	private static final long serialVersionUID = 5874049073120337804L;

	/**
	 * The parent {@link JFrame} of this menu bar.
	 */
	private JFrame parent;

	/**
	 * Constructs a new {@link JMenuBar} with a {@link MenuFile} menu.
	 * 
	 * @param parent
	 *            the parent {@link JFrame} of this menu.
	 */
	public DefaultMenuBar(JFrame parent) {
		super();
		this.parent = parent;
		this.add(new MenuFile(this));
	}

	/**
	 * Gets the parent frame of this menu bar.
	 * 
	 * @return the parent {@link JFrame} of this menu bar.
	 */
	public JFrame getParent2() {
		return this.parent;
	}
}
