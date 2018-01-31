package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.Runtime.TaskRestart;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemRestart#ItemRestart()
 */
public class ItemRestart extends JMenuItem {

	private static final long serialVersionUID = -5512655076022493646L;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link RestartAction}-{@link ActionListener}.
	 */
	public ItemRestart() {
		super("Restart");
		this.addActionListener(new RestartAction());
	}

	/**
	 * The default action for the {@link ItemRestart} menu item.
	 * 
	 * @author Cardinal System
	 * @see RestartAction#actionPerformed(ActionEvent)
	 */
	private class RestartAction implements ActionListener {

		/**
		 * Queues a new {@link TaskRestart} in the {@link TaskManager}.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			TaskManager.queue(new TaskRestart());
		}

	}
}
