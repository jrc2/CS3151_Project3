package edu.westga.cs3151.project3.model;

/**
 * The GameNode for GameTree
 *
 * @author John Chittam
 * 
 * @param <T> the type of node value
 */
public class GameNode<T> {

	private T value;
	private GameNode<T> leftChild;
	private GameNode<T> rightChild;
	private boolean isQuestionNode;
	
	/**
	 * Instantiates a new game node.
	 * 
	 * @precondition none
	 * @postcondition this.value==value AND this.leftChild==null AND this.rightChild == null
	 * 				  AND this.isQuestionNode==isQuestionNode
	 *
	 * @param value the value
	 * @param isQuestionNode true if node contains a question, false if it contains a question
	 */
	public GameNode(T value, boolean isQuestionNode) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.isQuestionNode = isQuestionNode;
	}

	/**
	 * Gets the node's value.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the value
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Sets the value.
	 * 
	 * @precondition none
	 * @postcondition this.value==value
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Gets the left child.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the left child
	 */
	public GameNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child.
	 * 
	 * @precondition none
	 * @postcondition this.leftChild==leftChild
	 *
	 * @param leftChild the new left child
	 */
	public void setLeftChild(GameNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	/**
	 * Checks for left child.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return true if leftChild!=null, false otherwise
	 */
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	/**
	 * Gets the right child.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the right child
	 */
	public GameNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child.
	 * 
	 * @precondition none
	 * @postcondition this.rightChild==rightChild
	 *
	 * @param rightChild the new right child
	 */
	public void setRightChild(GameNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	/**
	 * Checks for right child.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return true if this.rightChild!=null, false otherwise
	 */
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	/**
	 * Gets is question node boolean.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the is question node boolean
	 */
	public boolean getIsQuestionNode() {
		return this.isQuestionNode;
	}
	
	/**
	 * Sets the is question node boolean.
	 * 
	 * @precondition none
	 * @postcondition this.getIsQuestionNode()==isQuestionNode
	 *
	 * @param isQuestionNode the new is question node boolean
	 */
	public void setIsQuestionNode(boolean isQuestionNode) {
		this.isQuestionNode = isQuestionNode;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
	
}
