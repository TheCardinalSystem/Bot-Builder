package com.Cardinal.BotCreator.Gui.Components.Menus.Items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.Cardinal.BotCreator.Task.TaskManager;
import com.Cardinal.BotCreator.Task.Tasks.TaskRestart;

/**
 * One of the default menu items of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see ItemRestart#ItemRestart(JMenu)
 */
public class ItemRestart extends JMenuItem {

	private static final long serialVersionUID = -5512655076022493646L;

	/**
	 * The parent {@link JMenu} of this menu item.
	 * 
	 * @see ItemRestart#getParent2()
	 */
	private JMenu parent;

	/**
	 * Constructs a new {@link JMenuItem} with a
	 * {@link RestartAction}-{@link ActionListener}.
	 * 
	 * @param parent
	 *            the parent {@link JMenu} of this menu item.
	 * @see ItemRestart#getParent2()
	 */
	public ItemRestart(JMenu parent) {
		super("Restart");
		this.parent = parent;
		this.addActionListener(new RestartAction());
	}

	/**
	 * Gets the parent {@link JMenu} of this menu item.
	 * 
	 * @return the parent {@link JMenu} of this menu item.
	 * @see ItemRestart#ItemRestart(JMenu)
	 */
	public JMenu getParent2() {
		return this.parent;
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
