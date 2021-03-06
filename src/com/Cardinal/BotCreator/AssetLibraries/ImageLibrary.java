package com.Cardinal.BotCreator.AssetLibraries;

import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.Cardinal.BotCreator.lang.ResourceLoadException;

/**
 * The library of (default) image assets available for usage. Some images are
 * from Eclipse: <a href=
 * 'http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fref-icons.htm'>http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fref-icons.htm</a>
 * 
 * @author Cardinal System
 *
 */
public enum ImageLibrary {

	/**
	 * The Eclipse annotation icon.
	 */
	ANNOTATION("Icons/annotation_obj.png"),
	/**
	 * The Eclipse generic file icon.
	 */
	FILE("Icons/file_obj.png"),
	/**
	 * The Eclipse "search match" icon.
	 */
	YELLOW_ARROW("Icons/searchm_obj.png"),
	/**
	 * The Eclipse "add" icon.
	 */
	GREEN_PLUS("Icons/add_correction.png");

	/**
	 * The image instance of 'this'.
	 */
	private Image IMAGE;

	/**
	 * Sets the image instance of 'this'.
	 * 
	 * @param path
	 *            the location of the image in the 'assets' resource folder.
	 */
	private ImageLibrary(String path) {
		Image img = null;
		try {
			Path p = Paths.get(this.getClass().getResource(".").toURI());
			for (int i = 0; i < 4; i++) {
				p = p.getParent();
			}
			p = p.resolve("assets/Images/" + path);
			img = ImageIO.read(p.toUri().toURL());
		} catch (IOException | URISyntaxException e) {
			new ResourceLoadException(path, e).printStackTrace();
		}
		this.IMAGE = img;
	}

	/**
	 * Gets the image instance of 'this'.
	 * 
	 * @return the image instance of 'this'.
	 * @throws ResourceLoadException
	 *             thrown if the image was unable to load.
	 */
	public Image getImage() {
		return this.IMAGE;
	}

}
