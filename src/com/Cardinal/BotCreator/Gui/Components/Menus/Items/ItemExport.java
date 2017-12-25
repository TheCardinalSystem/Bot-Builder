package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemExport#ItemExport()
 */
public class ItemExport extends JMenuItem {

	private static final long serialVersionUID = -7867642294998612290L;

	/**
	 * Constructs a new {@link JMenuItem} with an
	 * {@link ExportAciton}-{@link ActionListener}.
	 */
	public ItemExport() {
		super("Export");
		this.addActionListener(new ExportAciton());
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
