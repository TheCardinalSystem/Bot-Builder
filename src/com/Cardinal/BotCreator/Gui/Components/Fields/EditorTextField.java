package com.Cardinal.BotCreator.Gui.Components.Fields;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Cardinal.BotCreator.Gui.Components.Cells.Editor.HierarchyCell;

/**
 * A panel for displaying extra info about a {@link HierarchyCell}.
 * 
 * @author Cardinal System
 *
 */
public class EditorTextField extends JPanel {

	private static final long serialVersionUID = -5914521579902871195L;

	/**
	 * A text field used for user input.
	 */
	private JTextField field;
	/**
	 * A text area used to display user info. Can be used for user input.
	 */
	private JTextArea display;
	/**
	 * The current {@link ActionListener} bound to {@linkplain EditorTextField#field
	 * the text field.}
	 */
	private ActionListener listener;

	/**
	 * Constructs a new {@link EditorTextField} with an {@link EmptyBorder}.
	 */
	public EditorTextField() {
		this.setLayout(new BorderLayout());
		field = new JTextField(20);
		display = new JTextArea();
		display.setEditable(false);
		this.setBorder(new EmptyBorder(4, 4, 4, 4));
	}

	/**
	 * Reconstructs the {@linkplain EditorTextField#field text field} with the given
	 * size.
	 * 
	 * @param size
	 *            the new size.
	 */
	public void setFieldSize(int size) {
		field = new JTextField(size);
	}

	/**
	 * Sets the {@linkplain EditorTextField#field text field's} text to the given
	 * text.
	 * 
	 * @param text
	 *            the text to use.
	 */
	public void setFieldText(String text) {
		field.setText(text);
	}

	/**
	 * Sets the {@linkplain EditorTextField text field's} action listener.
	 * 
	 * @param listener
	 *            the new listener.
	 * @see EditorTextField#field
	 */
	public void setFieldListener(ActionListener listener) {
		if (this.listener != null)
			field.removeActionListener(this.listener);
		field.addActionListener((this.listener = listener));
	}

	/**
	 * Set's the {@linkplain EditorTextField#display info text area's} text to the
	 * given text.
	 * 
	 * @param text
	 *            the new text.
	 */
	public void setDisplayText(String text) {
		display.setText(text);
	}

	/**
	 * Displays the {@linkplain EditorTextField#display info text area}.
	 */
	public void displayField() {
		this.remove(display);
		this.add(field, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Displays the {@linkplain EditorTextField#field text field}.
	 */
	public void displayTextDisplay() {
		this.remove(field);
		this.add(display, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Stops displaying everything in this panel.
	 */
	public void displayNone() {
		this.remove(display);
		this.remove(field);
		repaint();
	}

	/**
	 * Gets the {@linkplain EditorTextField#field text field}.
	 * 
	 * @return the text field.
	 */
	public JTextField getField() {
		return field;
	}

	/**
	 * Gets the {@linkplain EditorTextField#display info text area}.
	 * 
	 * @return the info text area.
	 */
	public JTextArea getTextDisplay() {
		return this.display;
	}
}
