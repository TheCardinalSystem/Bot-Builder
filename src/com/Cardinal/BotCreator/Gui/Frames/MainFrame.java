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

	/**
	 * Constructs a new {@link JFrame} with a
	 * {@link DefaultMenuBar}-{@link JMenuBar}. This constructor sets the frame size
	 * to half of the screen size, and centers it accordingly.
	 * 
	 * @param frameName the name of this window/{@linkplain JFrame}
	 */
	public MainFrame(String frameName) {
		super(frameName);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int)width / 2, (int)height / 2);
		this.setLocation((int)width/4, (int)height/4);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(new DefaultMenuBar());
		this.add(new ControlPanel(), BorderLayout.EAST);
		this.add(new VisualPanel(), BorderLayout.CENTER);
		this.setVisible(true);
	}

}
