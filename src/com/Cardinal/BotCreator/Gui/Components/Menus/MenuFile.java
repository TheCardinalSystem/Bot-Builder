package com.Cardinal.BotCreator.Gui.Components.Menus;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemClose;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemExport;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemImport;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemRestart;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.MenuNew;

/**
 * One of the default menus of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see MenuFile#MenuFile(JMenuBar)
 */
public class MenuFile extends JMenu {

	private static final long serialVersionUID = 5368242730909706494L;

	/**
	 * The parent {@link JMenuBar} of this menu.
	 */
	private JMenuBar parent;

	/**
	 * Constructs a new {@link JMenu} with a {@link MenuNew} sub-menu,
	 * {@link ItemExport} item, {@link ItemImport} item, {@link ItemRestart} item,
	 * and {@link ItemClose} item.
	 * 
	 * @param parent
	 *            the parent {@link JMenuBar} of this menu.
	 */
	public MenuFile(JMenuBar parent) {
		super("File");
		this.parent = parent;
		this.add(new MenuNew(this));
		this.add(new ItemExport(this));
		this.add(new ItemImport(this));
		this.add(new ItemRestart(this));
		this.add(new ItemClose(this));
	}

	/**
	 * Gets the parent {@link JMenuBar} of this menu.
	 * 
	 * @return the parent {@link JMenuBar} of this menu,
	 */
	public JMenuBar getParent2() {
		return this.parent;
	}
}
