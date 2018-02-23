package com.Cardinal.BotCreator.Gui.Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.Cardinal.BotCreator.Gui.Components.Menus.DefaultMenuBar;
import com.Cardinal.BotCreator.Gui.Panels.ControlPanel;
import com.Cardinal.BotCreator.Gui.Panels.VisualPanel;

/**
 * The default window/{@linkplain JFrame} of the bot creator GUI.
 * 
 * @author Cardinal System
 * @see MainFrame#MainFrame(String)
 */
public class MainFrame extends JFrame {

	public static void main(String args[]) {
		new MainFrame("Test");
	}

	private static final long serialVersionUID = -5257853932889784209L;

	private VisualPanel visual;
	private ControlPanel control;
	@SuppressWarnings("unused")
	private DefaultMenuBar menu;

	/**
	 * Constructs a new {@link JFrame} with a
	 * {@link DefaultMenuBar}-{@link JMenuBar}, a {@link ControlPanel}, and a
	 * {@link VisualPanel}. This constructor sets the frame size to half of the
	 * screen size, and centers it accordingly.
	 * 
	 * @param frameName
	 *            the name of this window/{@linkplain JFrame}
	 */
	public MainFrame(String frameName) {
		super(frameName);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int) width / 2, (int) height / 2);
		this.setLocation((int) width / 4, (int) height / 4);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setJMenuBar((menu = new DefaultMenuBar()));
		this.add((control = new ControlPanel(5, 5, this)), BorderLayout.EAST);
		this.add((visual = new VisualPanel()), BorderLayout.CENTER);

		/*
		 * Not liking this. Cannot figure out why it wont work... FrameMouseListener
		 * listener = new FrameMouseListener(this); control.addMouseListener(listener);
		 * visual.addMouseListener(listener); menu.addMouseListener(listener);
		 */

		this.setVisible(true);
	}

	public VisualPanel getVisualPanel() {
		return this.visual;
	}

	public ControlPanel getControlPanel() {
		return this.control;
	}

	/*
	 * private class FrameMouseListener extends MouseAdapter { private MainFrame
	 * frame;
	 * 
	 * protected FrameMouseListener(MainFrame frameIn) { this.frame = frameIn; }
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { if
	 * (!inBounds(frame.getControlPanel().getLower().getList(), e.getPoint())) {
	 * frame.getControlPanel().getLower().getList().clearSelection(); } if
	 * (!inBounds(frame.getControlPanel().getUpper().getList(), e.getPoint())) {
	 * frame.getControlPanel().getUpper().getList().clearSelection(); } if
	 * (!inBounds(frame.getVisualPanel().getList(), e.getPoint())) {
	 * frame.getVisualPanel().getList().clearSelection(); } }
	 * 
	 * private boolean inBounds(JList<?> list, Point p) { for (int i = 0; i <
	 * list.getModel().getSize(); i++) { if
	 * (list.getComponentAt(list.indexToLocation(i)).contains(p)) { return true; } }
	 * return false; } }
	 */
}
