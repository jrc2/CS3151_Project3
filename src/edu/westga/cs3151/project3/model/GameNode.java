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
	
	/**
	 * Instantiates a new game node.
	 * 
	 * @precondition none
	 * @postcondition this.value==value AND this.leftChild==null AND this.rightChild == null
	 *
	 * @param value the value
	 */
	public GameNode(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
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
	 * Checks for left chils.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return true if leftChild!=null, false otherwise
	 */
	public boolean hasLeftChile() {
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
	
	@Override
	public String toString() {
		return this.value.toString();
	}
	
}
