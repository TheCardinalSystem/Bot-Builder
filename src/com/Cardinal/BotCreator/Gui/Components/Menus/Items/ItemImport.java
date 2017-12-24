package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * One of the default menu items or the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemImport#ItemImport(JMenu)
 */
public class ItemImport extends JMenuItem {

	private static final long serialVersionUID = 4889274472834503741L;

	/**
	 * The parent menu of this item.
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenuItem} with an
	 * {@link ImportAction}-{@link ActionListener}.
	 */
	public ItemImport(JMenu parent) {
		super("Import");
		this.parent = parent;
		this.addActionListener(new ImportAction());
	}

	/**
	 * Gets the parent menu of this menu item.
	 */
	public JMenu getParent() {
		return this.parent;
	}

	/**
	 * The default action for the {@link ItemImport} menu item.
	 * 
	 * @author Cardinal System
	 * @see ImportAction#actionPerformed(ActionEvent)
	 */
	private static class ImportAction implements ActionListener {

		/**
		 * Prompts the user to import a project.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}
}
