package com.Cardinal.BotCreator.Gui.Panels.SubPanels;

import javax.swing.JPanel;

import com.Cardinal.BotCreator.Gui.Borders.BorderLibrary;
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
	 * Constructs a new {@link ControlUpper} ({@linkplain JPanel}).
	 * 
	 * @see ControlPanel
	 */
	public ControlUpper() {
		super();
		this.setBorder(BorderLibrary.NORMAL.getBorder());
	}
}
