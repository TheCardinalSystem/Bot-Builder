package com.Cardinal.BotCreator.Gui.Panels.Sub;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
import com.Cardinal.BotCreator.Gui.Panels.ControlPanel;

/**
 * The lower vertical half of the {@link ControlPanel}.
 * 
 * @author Cardinal System
 * @see ControlUpper
 */
public class ControlLower extends JPanel {

	private static final long serialVersionUID = 9080533032827681441L;

	/**
	 * Constructs a new {@link ControlLower} ({@linkplain JPanel}). The layout will be constructed with the
	 * specified gaps between components.
	 * 
	 * @param hgap
	 *            the horizontal gap.
	 * @param vgap
	 *            the vertical gap.
	 * 
	 * @see ControlPanel
	 */
	public ControlLower(int hgap, int vgap) {
		super();
		this.setLayout(new BorderLayout(hgap, vgap));
		this.setBorder(BorderLibrary.NORMAL.getBorder());
	}
}
