package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.Tasks.TaskShutdown;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemClose#ItemClose()
 */
public class ItemClose extends JMenuItem {

	private static final long serialVersionUID = 4530113478515111711L;

	/**
	 * The parent {@link JMenu} of this menu item.
	 * 
	 * @see ItemClose#getParent2()
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link CloseAction}-{@link ActionListener}.
	 * 
	 * @param parent
	 *            the parent {@link JMenu} of this menu item.
	 */
	public ItemClose(JMenu parent) {
		super("Close");
		this.parent = parent;
		this.addActionListener(new CloseAction());
	}

	/**
	 * Gets the parent {@link JMenu} of this menu item.
	 * 
	 * @return the parent {@link JMenu} of this menu item.
	 * @see ItemClose#ItemClose(JMenu)
	 */
	public JMenu getParent2() {
		return this.parent;
	}

	/**
	 * The default action for the {@link ItemClose} menu item
	 * 
	 * @author Cardinal System
	 * @see CloseAction#actionPerformed(ActionEvent)
	 */
	private class CloseAction implements ActionListener {

		/**
		 * Queues a {@link TaskShutdown} in the {@link TaskManager}.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			TaskManager.queue(new TaskShutdown());
		}

	}
}
