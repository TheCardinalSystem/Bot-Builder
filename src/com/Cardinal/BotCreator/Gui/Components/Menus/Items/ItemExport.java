package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemExport#ItemExport(JMenu)
 */
public class ItemExport extends JMenuItem {

	private static final long serialVersionUID = -7867642294998612290L;

	/**
	 * The parent {@link JMenu} of this menu item.
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenuItem} with an
	 * {@link ExportAciton}-{@link ActionListener}.
	 * 
	 * @param parent
	 *            the parent {@link JMenu} of this item.
	 * @see ItemExport#getParent2()
	 */
	public ItemExport(JMenu parent) {
		super("Export");
		this.parent = parent;
		this.addActionListener(new ExportAciton());
	}

	/**
	 * Gets the parent {@link JMenu} of this menu item.
	 * 
	 * @return the parent {@link JMenu} if this menu item.
	 */
	public JMenu getParent2() {
		return this.parent;
	}

	/**
	 * The default action for the {@link ItemExport} menu item.
	 * 
	 * @author Cardinal System
	 * @see ExportAciton#actionPerformed(ActionEvent)
	 */
	private static class ExportAciton implements ActionListener {

		/**
		 * Prompts the user to export a project.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}
}
