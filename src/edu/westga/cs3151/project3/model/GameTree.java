package edu.westga.cs3151.project3.model;

/**
 * The GameTree
 * 
 * @author John Chittam
 *
 * @param <T> the type of node values
 */
public class GameTree<T> {
	
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
	 * Default game tree constructor.
	 * 
	 * @precondition none
	 * @postcondition this.rootValue==null
	 */
	public GameTree() {
		this(null);
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
	
	/**
	 * Edits the current node.
	 * 
	 * @precondition none
	 * @postcondition this.currNode.value==newValue AND this.currNode.isQuestion==isQuestion AND 
	 * 				  this.currNode.leftChild==leftChild AND this.currNode.rightChild==rightChild
	 *
	 * @param newValue the new value
	 * @param isQuestion the new is question value
	 * @param leftChild the new left child
	 * @param rightChild the new right child
	 */
	public void editCurrNode(String newValue, boolean isQuestion, GameNode<String> leftChild, GameNode<String> rightChild) {
		this.currNode.setValue(newValue);
		this.currNode.setIsQuestionNode(isQuestion);
		this.currNode.setLeftChild(leftChild);
		this.currNode.setRightChild(rightChild);
	}
	
	/**
	 * Tells if the current node has a child
	 *
	 * @return true if current node has a child, false if not
	 */
	public boolean currNodeHasChild() {
		return this.currNode.hasLeftChild() || this.currNode.hasRightChild();
	}
	
	/**
	 * Sets current node to its left child
	 * 
	 * @precondition none
	 * @postcondition this.currNode==this.currNode.leftChild
	 */
	public void goToLeftChild() {
		this.setCurrNode(this.currNode.getLeftChild());
	}
	
	/**
	 * Sets current node to its right child
	 * 
	 * @precondition none
	 * @postcondition this.currNode==this.currNode.rightChild
	 */
	public void goToRightChild() {
		this.setCurrNode(this.currNode.getRightChild());
	}

}
