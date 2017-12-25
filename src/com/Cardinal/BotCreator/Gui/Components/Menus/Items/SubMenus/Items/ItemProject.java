package com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * One of the default menu items of bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemProject#ItemProject()
 */
public class ItemProject extends JMenuItem {

	private static final long serialVersionUID = -1039665955222951549L;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link ProjectAction}-{@link ActionListener}.
	 * 
	 * @see ItemProject#getParent2()
	 */
	public ItemProject() {
		super("Project");
		this.addActionListener(new ProjectAction());
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
