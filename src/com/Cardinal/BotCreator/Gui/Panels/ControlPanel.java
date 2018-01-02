package com.Cardinal.BotCreator.Gui.Panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Components.Menus.DefaultMenuBar;
import com.Cardinal.BotCreator.Gui.Frames.MainFrame;
import com.Cardinal.BotCreator.Gui.Panels.Sub.ControlLower;
import com.Cardinal.BotCreator.Gui.Panels.Sub.ControlUpper;

/**
 * The left panel of the main frame. Divided vertically into two halves, each
 * serving their own purpose. More info to be added. <center>
 * <h2>Render:</h2>
 * <hr>
 * <table border="1">
 * <tr>
 * <th colspan="2" style="font-weight:normal;">{@linkplain DefaultMenuBar}</th>
 * </tr>
 * <tr>
 * <th rowspan="2" style="font-weight:normal;">{@linkplain VisualPanel}</th>
 * <td style="font-weight:bold;">{@linkplain ControlUpper Upper Half}</td>
 * </tr>
 * <tr>
 * <td style="font-weight:bold;">{@linkplain ControlLower Lower Half}</td>
 * </tr>
 * </table>
 * </center>
 * <hr>
 * 
 * @author Cardinal System
 *
 */
public class ControlPanel extends JPanel {

	private static final long serialVersionUID = -6488397793640482079L;
	/**
	 * The parent frame of this panel.
	 */
	private MainFrame parent;
	/**
	 * The upper panel of this panel.
	 */
	private ControlUpper upper;
	/**
	 * The lower panel of this panel.
	 */
	private ControlLower lower;
	/**
	 * Constructs a new {@link ControlPanel} ({@linkplain JPanel}) with a
	 * {@link ControlUpper} and a {@link ControlLower}. The layout will be
	 * constructed with the specified gaps between components.
	 * 
	 * @param hgap
	 *            the horizontal gap.
	 * @param vgap
	 *            the vertical gap.
	 * @param parent
	 *            the parent frame of this panel.
	 */
	public ControlPanel(int hgap, int vgap, MainFrame parent) {
		super();
		this.parent = parent;
		this.setLayout(new BorderLayout(hgap, vgap));
		this.add((upper = new ControlUpper(vgap, vgap, this)), BorderLayout.NORTH);
		this.add((lower = new ControlLower(vgap, vgap, this)), BorderLayout.SOUTH);
		this.setBorder(BorderLibrary.RAISED.getBorder());
	}
	/**
	 * Gets the parent frame of this panel.
	 * @return {@link ControlPanel#parent}.
	 */
	public MainFrame getParent() {
		return parent;
	}
	/**
	 * Gets the upper panel of this pane.
	 * @return {@link ControlPanel#upper}
	 */
	public ControlUpper getUpper() {
		return upper;
	}
	/**
	 * Gets the lower panel of this panel.
	 * @return {@link ControlPanel#lower}
	 */
	public ControlLower getLower() {
		return lower;
	}
}
