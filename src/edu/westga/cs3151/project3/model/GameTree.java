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
	
	private GameNode<String> root;
	private GameNode<String> currNode;
	
	/**
	 * Instantiates a new game tree with given root node.
	 * 
	 * @precondition none
	 * @postcondition this.root==root;
	 *
	 * @param rootValue the root node value
	 */
	public GameTree(String rootValue) {
		this.root = new GameNode<String>(rootValue, false);
		this.currNode = this.root;
	}
	
	/**
	 * Gets the root node of the game tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the root node of the game tree
	 */
	public GameNode<String> getRoot() {
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
	public void setRoot(GameNode<String> root) {
		this.root = root;
	}
	
	/**
	 * Gets the current node.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the current node
	 */
	public GameNode<String> getCurrNode() {
		return this.currNode;
	}
	
	/**
	 * Sets the current node.
	 * 
	 * @precondition none
	 * @postcondition this.currNode==newCurrNode
	 *
	 * @param newCurrNode the new current node
	 */
	public void setCurrNode(GameNode<String> newCurrNode) {
		this.currNode = newCurrNode;
	}
	
	public void editCurrNode(String newValue, boolean isQuestion, GameNode<String> leftChild, GameNode<String> rightChild) {
		this.currNode.setValue(newValue);
		this.currNode.setIsQuestionNode(isQuestion);
		this.currNode.setLeftChild(leftChild);
		this.currNode.setRightChild(rightChild);
	}
	
	public boolean currNodeHasChild() {
		return this.currNode.hasLeftChild() || this.currNode.hasRightChild();
	}
	
	public GameNode<String> goToLeftChild() {
		this.setCurrNode(this.currNode.getLeftChild());
		return this.currNode;
	}
	
	public GameNode<String> goToRightChild() {
		this.setCurrNode(this.currNode.getRightChild());
		return this.currNode;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
