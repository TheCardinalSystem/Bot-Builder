package com.Cardinal.BotCreator.Gui.Components.Menus;
import javax.swing.JMenu;

import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemClose;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemExport;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemImport;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.ItemRestart;
import com.Cardinal.BotCreator.Gui.Components.Menus.Items.SubMenus.MenuNew;

/**
 * One of the default menus of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see MenuFile#MenuFile()
 */
public class MenuFile extends JMenu {

	private static final long serialVersionUID = 5368242730909706494L;

	/**
	 * Constructs a new {@link JMenu} with a {@link MenuNew} sub-menu,
	 * {@link ItemExport} item, {@link ItemImport} item, {@link ItemRestart} item,
	 * and {@link ItemClose} item.
	 * 
	 */
	public MenuFile() {
		super("File");
		this.add(new MenuNew());
		this.add(new ItemExport());
		this.add(new ItemImport());
		this.add(new ItemRestart());
		this.add(new ItemClose());
	}

}
