package com.Cardinal.BotCreator.Gui.Panels.SubPanels;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCellRenderer;
import com.Cardinal.BotCreator.Gui.Panels.ControlPanel;

/**
 * The upper vertical half of the {@link ControlPanel}.
 * 
 * @author Cardinal System
 * @see ControlLower
 */
public class ControlUpper extends JPanel {

	private static final long serialVersionUID = -3964311386913420436L;

	/**
	 * All the cells in the {@link ControlUpper#operations}-{@link JComboBox},
	 * accessible by name.
	 */
	private HashMap<String, ComboBoxCell> cells = new HashMap<String, ComboBoxCell>();
	/**
	 * The list of operations that can be added to the bot project.
	 */
	private JComboBox<ComboBoxCell> operations = new JComboBox<ComboBoxCell>();

	/**
	 * Constructs a new {@link ControlUpper} ({@linkplain JPanel}) with a
	 * {@link BorderLibrary#NORMAL normal} border and {@link JComboBox} of
	 * {@linkplain ComboBoxCell}s.
	 * 
	 * @see ControlPanel
	 */
	public ControlUpper() {
		super();
		this.setLayout(new BorderLayout());
		operations.setRenderer(new ComboBoxCellRenderer());
		this.add(operations, BorderLayout.CENTER);
	}

	/**
	 * Adds a cell to the operations menu.
	 * 
	 * @param cell
	 *            the cell to add.
	 * @return the {@link ComboBoxCell} that was added.
	 * @see ControlUpper#removeCell(String)
	 */
	public ComboBoxCell addCell(ComboBoxCell cell) {
		operations.addItem(cell);
		return cells.put(cell.getName(), cell);
	}

	/**
	 * Removes a cell from the operations menu.
	 * 
	 * @param name
	 *            the name of the cell to remove.
	 * @return the {@link ComboBoxCell} that was removed.
	 * @see ControlUpper#addCell(ComboBoxCell)
	 */
	public ComboBoxCell removeCell(String name) {
		operations.removeItem(cells.get(name));
		return cells.remove(name);
	}
}
