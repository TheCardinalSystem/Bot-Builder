package com.Cardinal.BotCreator.Gui.Components.Cells.Editor;

/**
 * A template for a {@link HierarchyCell} handler.
 * 
 * @author Cardinal System
 *
 */
public interface HierarchyCellHandler {

	/**
	 * Opens the inside of the given cell.
	 * 
	 * @param cell
	 *            the cell to open.
	 */
	public void open(HierarchyCell cell);

	/**
	 * Gets the previous cell relative to the given cell in the cell hierarchy.
	 * 
	 * @param cell
	 *            the cell to retrieve relative to.
	 * @return the next cell.
	 */
	public HierarchyCell getParent(HierarchyCell cell);

	/**
	 * Gets the default cell that is to be added at the end of every cell list.
	 * 
	 * @return the default cell.
	 */
	public BackCell getBackCell();

	/**
	 * Opens the previous cell in the cell hierarchy.
	 */
	public void goBack();

}
