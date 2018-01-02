package com.Cardinal.BotCreator.Gui.Panels.Sub;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCellRenderer;
import com.Cardinal.BotCreator.Gui.Components.Cells.Default.EventCell;
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
	private JList<ComboBoxCell> operations = new JList<ComboBoxCell>(new DefaultListModel<ComboBoxCell>());
	public JScrollPane scrollPane;
	/**
	 * The parent panel of this panel.
	 */
	private ControlPanel parent;

	/**
	 * Constructs a new {@link ControlUpper} ({@linkplain JPanel}) with a
	 * {@link BorderLibrary#NORMAL normal} border and {@link JComboBox} of
	 * {@linkplain ComboBoxCell}s. The layout will be constructed with the specified
	 * gaps between components.
	 * 
	 * @param hgap
	 *            the horizontal gap.
	 * @param vgap
	 *            the vertical gap.
	 * @param parent
	 *            the parent panel of this panel.
	 * @see ControlPanel
	 */
	public ControlUpper(int hgap, int vgap, ControlPanel parent) {
		super();
		this.parent = parent;
		this.setLayout(new BorderLayout(hgap, vgap));
		this.setBorder(BorderLibrary.NORMAL.getBorder());
		operations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		operations.setCellRenderer(new ComboBoxCellRenderer());
		this.add(new JScrollPane(operations), BorderLayout.CENTER);
		this.addCell(new EventCell());
		operations.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if(evt.getClickCount() >= 2) {
		        	if(!operations.isSelectionEmpty()) {
		        		parent.getLower().addCell(operations.getSelectedValue());
		        		operations.clearSelection();
		        	}
		        }
		    }
		});
	}

	/**
	 * Gets the parent panel of this panel.
	 * 
	 * @return {@link ControlUpper#parent}.
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
	 * @see ControlUpper#removeCell(String)
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
	 * @see ControlUpper#addCell(ComboBoxCell)
	 */
	public ComboBoxCell removeCell(String name) {
		((DefaultListModel<ComboBoxCell>) operations.getModel()).removeElement(cells.get(name));
		return cells.remove(name);
	}
}
