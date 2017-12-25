package com.Cardinal.BotCreator.Gui.Panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Components.Menus.DefaultMenuBar;
import com.Cardinal.BotCreator.Gui.Panels.SubPanels.ControlLower;
import com.Cardinal.BotCreator.Gui.Panels.SubPanels.ControlUpper;

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
	 * Constructs a new {@link ControlPanel} ({@linkplain JPanel}) with a
	 * {@link ControlUpper} and a {@link ControlLower}.
	 */
	public ControlPanel() {
		super();
		this.setLayout(new BorderLayout());
		this.add(new ControlUpper(), BorderLayout.NORTH);
		this.add(new ControlLower(), BorderLayout.SOUTH);
		this.setBorder(BorderLibrary.RAISED.getBorder());
	}
}
