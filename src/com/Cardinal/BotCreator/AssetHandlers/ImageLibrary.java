package com.Cardinal.BotCreator.AssetHandlers;

import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

/**
 * The library of (default) image assets available for usage.
 * 
 * @author Cardinal System
 *
 */
public enum ImageLibrary {

	/**
	 * Just a default value to be used until images are added.
	 */
	IMG("");

	private Image ourImage;

	/**
	 * Sets the image instance of 'this'.
	 * 
	 * @param path
	 *            the location of the image in the 'assets' resource folder.
	 */
	private ImageLibrary(String path) {
		try {
			Path p = Paths.get(this.getClass().getResource(".").toURI());
			for (int i = 0; i < 4; i++) {
				p = p.getParent();
			}
			p = p.resolve("assets/" + path);
			this.ourImage = ImageIO.read(p.toUri().toURL());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
			this.ourImage = null;
		}
	}

	/**
	 * Gets the image instance of 'this'.
	 * 
	 * @return the image instance of 'this'.
	 */
	public Image get() {
		return this.ourImage;
	}
}
