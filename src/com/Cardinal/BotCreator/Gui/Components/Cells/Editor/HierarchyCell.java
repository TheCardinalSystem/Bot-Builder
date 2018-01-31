package com.Cardinal.BotCreator.Gui.Components.Cells.Editor;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JList;

import com.Cardinal.BotCreator.Gui.Components.Cells.ComboBoxCell;
import com.Cardinal.BotCreator.Gui.Components.Fields.EditorTextField;

/**
 * A {@link ComboBoxCell} that has child cells and set open methods.
 * 
 * @author Cardinal System
 *
 */
public interface HierarchyCell extends ComboBoxCell {

	/**
	 * Gets all the child cells of this cell.
	 * 
	 * @return the child cells.
	 */
	public HierarchyCell[] getChildren();

	/**
	 * Opens this cell. If this cell does not require a special open mechanism, use
	 * the {@linkplain HierarchyCellHandler#open(HierarchyCell) open} method in the
	 * <code>handlerIn</code> parameter.
	 * 
	 * @param listIn
	 *            the cell list which this cell is in.
	 * @param textDisplay
	 *            the info display panel.
	 * @param handlerIn
	 *            the cell handler.
	 */
	public void open(JList<HierarchyCell> listIn, EditorTextField textDisplay, HierarchyCellHandler handlerIn);

	/**
	 * Closes this cell. This is like finalize: it saves any work and restores any
	 * changes make to the GUI as defined by the subclass.
	 * 
	 * @param listIn
	 *            the cell list which this cell is in.
	 * @param textDisplay
	 *            the info display panel.
	 */
	public void close(JList<HierarchyCell> listIn, EditorTextField textDisplay);

	/**
	 * Creates an ordered array of {@link HierarchyCell} objects.
	 * 
	 * @param firstChild
	 *            the first element to place in the array.
	 * @param otherChildren
	 *            any other elements to place in the array.
	 * @return the ordered array.
	 */
	public static HierarchyCell[] merge(HierarchyCell firstChild, HierarchyCell... otherChildren) {

		ArrayList<HierarchyCell> ordered = new ArrayList<HierarchyCell>(
				Arrays.asList(new HierarchyCell[] { firstChild }));
		ordered.addAll(Arrays.asList(otherChildren));

		return ordered.toArray(new HierarchyCell[ordered.size()]);
	}
}
