package com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * One of the default menu items of bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemProject#ItemProject(JMenu)
 */
public class ItemProject extends JMenuItem {

	private static final long serialVersionUID = -1039665955222951549L;

	/**
	 * The parent {@link JMenu} of this menu item.
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link ProjectAction}-{@link ActionListener}.
	 * 
	 * @param parent
	 *            the parent {@link JMenu} of this menu item.
	 * @see ItemProject#getParent2()
	 */
	public ItemProject(JMenu parent) {
		super("Project");
		this.parent = parent;
		this.addActionListener(new ProjectAction());
	}

	/**
	 * Gets the parent {@link JMenu} of this menu item.
	 * 
	 * @return the parent {@link JMenu} of this menu item.
	 */
	public JMenu getParent2() {
		return this.parent;
	}

	/**
	 * The default action for the {@link ItemProject} menu item.
	 * 
	 * @author Cardinal System
	 * @see ProjectAction#actionPerformed(ActionEvent)
	 */
	private static class ProjectAction implements ActionListener {

		/**
		 * Prompts the user to create a new project.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}
}
