package edu.westga.cs3151.project3.utils;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.westga.cs3151.project3.model.GameTree;

/**
 * Handles loading files into program.
 * 
 * @author John Chittam
 */
public class FileIn {

	/**
	 * Loads a game tree from XML.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @param filename the filename to load from
	 * 
	 * @return the loaded game tree
	 */
	public static GameTree<?> loadGameTreeFromXML(String filename) {
		XMLDecoder decoder = null;
		
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " not found");
		}
		
		GameTree<?> gameTree = (GameTree<?>) decoder.readObject();
		return gameTree;
	}
}
