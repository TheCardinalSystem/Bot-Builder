package com.Cardinal.BotCreator.Gui.Panels;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCellRenderer;

/**
 * The lower vertical half of the {@link ControlPanel}.
 * 
 * @author Cardinal System
 * @see ControlUpper
 */
public class ControlLower extends JPanel {

	private static final long serialVersionUID = 9080533032827681441L;
	private JList<ComboBoxCell> operations = new JList<ComboBoxCell>(new DefaultListModel<ComboBoxCell>());
	public JScrollPane scrollPane;
	/**
	 * The parent pawnel of this panel.
	 */
	private ControlPanel parent;
	/**
	 * All the cells in the {@link ControlLower#operations}-{@link JList},
	 * accessible by name.
	 */
	private HashMap<String, ComboBoxCell> cells = new HashMap<String, ComboBoxCell>();
	/**
	 * Constructs a new {@link ControlLower} ({@linkplain JPanel}). The layout will
	 * be constructed with the specified gaps between components.
	 * 
	 * @param hgap
	 *            the horizontal gap.
	 * @param vgap
	 *            the vertical gap.
	 * @param parent
	 *            the parent panel of this panel.
	 * @see ControlPanel
	 */
	public ControlLower(int hgap, int vgap, ControlPanel parent) {
		super();
		this.parent = parent;
		this.setLayout(new BorderLayout(hgap, vgap));
		this.setBorder(BorderLibrary.NORMAL.getBorder());
		operations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		operations.setCellRenderer(new ComboBoxCellRenderer());
		this.add((scrollPane = new JScrollPane(operations)), BorderLayout.CENTER);
	}

	/**
	 * Gets the parent panel of this panel.
	 */
	public ControlPanel getParent() {
		return parent;
	}
	/**
	 * Adds a cell to the operations menu.
	 * 
	 * @param cell
	 *            the cell to add.
	 * @return the {@link ComboBoxCell} that was added.
	 * @see ControlLower#removeCell(String)
	 */
	public ComboBoxCell addCell(ComboBoxCell cell) {
		((DefaultListModel<ComboBoxCell>) operations.getModel()).addElement(cell);
		return cells.put(cell.getName(), cell);
	}

	/**
	 * Removes a cell from the operations menu.
	 * 
	 * @param name
	 *            the name of the cell to remove.
	 * @return the {@link ComboBoxCell} that was removed.
	 * @see ControlLower#addCell(ComboBoxCell)
	 */
	public ComboBoxCell removeCell(String name) {
		((DefaultListModel<ComboBoxCell>) operations.getModel()).removeElement(cells.get(name));
		return cells.remove(name);
	}
}
