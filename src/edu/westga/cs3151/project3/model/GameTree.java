package edu.westga.cs3151.project3.model;

import java.util.Iterator;

/**
 * The GameTree
 * 
 * @author John Chittam
 *
 * @param <T> the type of node values
 */
public class GameTree<T> implements Iterable<T> {
	
	private GameNode<T> root;
	
	/**
	 * Instantiates a new game tree with given root node.
	 * 
	 * @precondition none
	 * @postcondition this.root==root;
	 *
	 * @param root the root node
	 */
	public GameTree(GameNode<T> root) {
		this.root = root;
	}
	
	/**
	 * Gets the root node of the game tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the root node of the game tree
	 */
	public GameNode<T> getRoot() {
		return this.root;
	}
	
	/**
	 * Sets the root node of the game tree.
	 * 
	 * @precondition none
	 * @postcondition this.root==root
	 *
	 * @param root the new root node
	 */
	public void setRoot(GameNode<T> root) {
		this.root = root;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
