package com.Cardinal.BotCreator.Gui.Components.Cells;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * The cell renderer for {@linkplain ComboBoxCell}s.
 * 
 * @author Cardinal System
 *
 */
public class ComboBoxCellRenderer implements ListCellRenderer<ComboBoxCell> {

	/**
	 * Renders the given {@link ComboBoxCell} as a {@link JLabel} with the contained
	 * {@link ImageIcon} and text.
	 * @see ComboBoxCell#getIcon()
	 * @see ComboBoxCell#getName()
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends ComboBoxCell> list, ComboBoxCell value, int index,
			boolean isSelected, boolean cellHasFocus) {

		JLabel jlab = new JLabel();
		try{
			jlab.setText(value.getName());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		try {
			jlab.setIcon(value.getIcon());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}

		return jlab;
	}

}