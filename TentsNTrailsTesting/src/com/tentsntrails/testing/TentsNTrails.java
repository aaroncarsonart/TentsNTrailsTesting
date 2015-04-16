package com.tentsntrails.testing;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.openqa.selenium.Dimension;

/**
 * I suggest using this to store various testing constants and values to 
 * abstract away things like the website title, URL, etc.
 * @author Aaron Carson
 * @version Apr 13, 2015
 */
public final class TentsNTrails
{	
	// urls we have available.
	public static final String SPRINT_5 = "http://tentsntrailsdebug.azurewebsites.net";
	public static final String SPRINT_6 = "http://tentsntrailssprint6.azurewebsites.net";
	public static final String AARONS_TEST_SITE = "http://tentsntrails-test.azurewebsites.net";
	
	// Here is an easy, single-refrence point for a testing url.
	//public static final String URL = SPRINT_6;
	public static final String URL = AARONS_TEST_SITE;

	// private static WebDriver DRIVER = ;
	public static Dimension	FULLSCREEN_DIMENSION = getFullscreenDimension();

	/**
	 * Makes a fullscreen dimension to be reused from this static class
	 * reference, rather than re-instating it every time.
	 * @return a new dimension, that is the full size of the testing screen.
	 */
	private static Dimension getFullscreenDimension(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		int width =  (int) gd.getDefaultConfiguration().getBounds().getWidth();
		int height = (int) gd.getDefaultConfiguration().getBounds().getHeight();
		return new Dimension(width, height);
	}	
}