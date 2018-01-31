package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.Runtime.TaskShutdown;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemClose#ItemClose()
 */
public class ItemClose extends JMenuItem {

	private static final long serialVersionUID = 4530113478515111711L;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link CloseAction}-{@link ActionListener}.
	 */
	public ItemClose() {
		super("Close");
		this.addActionListener(new CloseAction());
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
