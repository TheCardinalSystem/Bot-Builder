package com.Cardinal.BotCreator.Gui.Panels.SubPanels;

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
	 * Constructs a new {@link ControlLower} ({@linkplain JPanel}).
	 * 
	 * @see ControlPanel
	 */
	public ControlLower() {
		super();
		this.setBorder(BorderLibrary.NORMAL.getBorder());
	}
}
