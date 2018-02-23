package com.Cardinal.BotCreator.Gui.Panels;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCellRenderer;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCellHandler;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.Customizer.BackCell;
import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.File.FileCell;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;
import com.Cardinal.BotCreator.Gui.Components.Menus.DefaultMenuBar;

/**
 * The right panel of the mainframe. Used for all graphic components such as
 * images.<center>
 * <h2>Render:</h2>
 * <hr>
 * <table border="1">
 * <tr>
 * <th colspan="2" style="font-weight:normal;">{@linkplain DefaultMenuBar}</th>
 * </tr>
 * <tr>
 * <td style="font-weight:bold;">VisualPanel</td>
 * <td>{@linkplain ControlPanel Upper Half <br>
 * Lower Half}</td>
 * </tr>
 * </table>
 * </center>
 * <hr>
 * 
 * @author Cardinal System
 *
 */
public class VisualPanel extends JPanel implements HierarchyCellHandler {

	private static final long serialVersionUID = 7053195481836751193L;

	/**
	 * The list of operations that can be added to the bot project.
	 */
	private JList<HierarchyCell> methods = new JList<HierarchyCell>(new DefaultListModel<HierarchyCell>());
	/**
	 * A multipurpose field for displaying info relevant to the current
	 * {@link HierarchyCell}.
	 */
	private EditorTextField field = new EditorTextField();
	/**
	 * The hierarchy of {@link HierarchyCell HierarchyCells} in this pane.
	 */
	private Stack<HierarchyCell> cellHierarchy = new Stack<HierarchyCell>();
	/**
	 * The default cell to be added at the end of opened cell.
	 * 
	 * @see VisualPanel#getBackCell()
	 */
	private BackCell back = new BackCell(this);
	/**
	 * The cells at the top of cell hierarchy.
	 */
	private ArrayList<HierarchyCell> topLevel = new ArrayList<HierarchyCell>();

	/**
	 * Constructs a new {@link VisualPanel} with a {@link JList} for displaying
	 * {@link HierarchyCell HierarchyCells}.
	 */
	public VisualPanel() {
		this.setLayout(new BorderLayout());

		this.add(field, BorderLayout.SOUTH);

		methods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		methods.setCellRenderer(new ComboBoxCellRenderer());
		this.add(new JScrollPane(methods), BorderLayout.CENTER);

		methods.addMouseListener(new CellClickListener(this));

		try {
			addTopLevelCell(new FileCell(new File("C:/Users/Peter Paul/Desktop/pack.mcmeta")));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clears the cell list and lists the children of the given cell.
	 * 
	 * @param cell
	 *            the cell whose children to list.
	 */
	@Override
	public void open(HierarchyCell cell) {
		if (!cellHierarchy.isEmpty())
			cellHierarchy.peek().close(methods, field);
		cellHierarchy.push(cell);
		DefaultListModel<HierarchyCell> model = (DefaultListModel<HierarchyCell>) methods.getModel();
		model.removeAllElements();
		Arrays.stream(cell.getChildren()).forEach(model::addElement);
		model.addElement(back);
		methods.setModel(model);
	}

	/**
	 * Adds a cell to the top of the cell hierarchy.
	 * 
	 * @param cell
	 *            the cell to add.
	 */
	public void addTopLevelCell(HierarchyCell cell) {
		topLevel.add(cell);
		if (cellHierarchy.isEmpty()) {
			DefaultListModel<HierarchyCell> model = (DefaultListModel<HierarchyCell>) methods.getModel();
			model.removeAllElements();
			topLevel.forEach(model::addElement);
			methods.setModel(model);
		}
	}

	/**
	 * Gets the default cell to be added at the end of every cell list. This cell
	 * returns to the next cell in the cell hierarchy upon being opened.
	 * 
	 * @return the default cell.
	 * @see VisualPanel#goBack()
	 */
	@Override
	public BackCell getBackCell() {
		return back;
	}

	public void goBack() {
		try {
			cellHierarchy.pop().close(methods, field);
			cellHierarchy.peek().open(methods, field, this);
		} catch (EmptyStackException e) {
			DefaultListModel<HierarchyCell> model = (DefaultListModel<HierarchyCell>) methods.getModel();
			model.removeAllElements();
			topLevel.forEach(model::addElement);
			methods.setModel(model);
		}
	}

	@Override
	public HierarchyCell getParent(HierarchyCell cell) {
		Iterator<HierarchyCell> it = cellHierarchy.iterator();
		while (it.hasNext()) {
			if (it.next().equals(cell))
				return it.next();
		}
		return null;
	}

	public JList<HierarchyCell> getList() {
		return this.methods;
	}

	/**
	 * The default click listener for the cell list.
	 * 
	 * @author Cardinal System
	 *
	 */
	private class CellClickListener extends MouseAdapter {
		private VisualPanel panel;

		protected CellClickListener(VisualPanel panelIn) {
			this.panel = panelIn;
		}

		public void mouseClicked(MouseEvent evt) {
			if (!methods.isSelectionEmpty()) {
				/*
				 * if (methods.getSelectedValue().getChildren() == null && evt.getClickCount() >
				 * 0) { methods.getSelectedValue().open(methods, field, panel); } else
				 */if (evt.getClickCount() >= 2) {
					methods.getSelectedValue().open(methods, field, panel);
				}
			}

		}
	}

}
