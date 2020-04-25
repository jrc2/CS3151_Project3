package edu.westga.cs3151.project3.utils;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import edu.westga.cs3151.project3.model.GameTree;

/**
 * The Class SaveToXML.
 * 
 * @author John Chittam
 */
public class SaveToXML {

	/**
	 * Writes a game tree to XML.
	 * 
	 * @precondition none
	 * @postcondition file saved if no errors
	 *
	 * @param gameTree the tree to save
	 * @param filename the filename to save to
	 */
	public static void writeGameTreeToXML(GameTree<String> gameTree, String filename) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error saving to file: " + filename);
		}
		encoder.writeObject(gameTree);
		encoder.close();
	}
}
