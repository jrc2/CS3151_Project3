package edu.westga.cs3151.project3.model;

import java.util.Random;

/**
 * Controls the Game.
 *
 * @author John Chittam
 */
public class Game {
	
	private GameTree<String> gameTree;
	private static final String[] INITIAL_ANIMAL_CHOICES = {"frog", "liger", "sloth", "cat", "koala", "human", "unicorn", "goat", "chicken", 
															"penguin", "lobster", "porcupine", "chewbacca", "chupacabra", "owl", "water deer"};
	
	/**
	 * Instantiates a new game.
	 * 
	 * @precondition gameTree is instantiated
	 * @postcondition none
	 */
	public Game() {
		Random random = new Random();
		int animalChoiceIndex = random.nextInt(INITIAL_ANIMAL_CHOICES.length);
		String initialAnimalName = INITIAL_ANIMAL_CHOICES[animalChoiceIndex];
		this.gameTree = new GameTree<String>(initialAnimalName);
	}
	
	/**
	 * Gets the game tree.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the game tree
	 */
//	public GameTree<String> getGameTree() {
//		return this.gameTree;
//	}
	
	/**
	 * Gets the curr node.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the curr node
	 */
	public GameNode<String> getCurrNode() {
		return this.gameTree.getCurrNode();
	}
	
	/**
	 * Checks for children.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return true if either node has a child, false otherwise
	 */
	public boolean hasChildren() {
		return this.gameTree.currNodeHasChild();
	}
	
	public void setNodeAfterAnswer(boolean answer) {
		if (answer) {
			this.gameTree.goToRightChild();
		} else {
			this.gameTree.goToLeftChild();
		}
		
	}
	
	public void resetGame() {
		this.gameTree.setCurrNode(this.gameTree.getRoot());
	}
	
	/**
	 * Adds a new animal and distinguishing question after
	 * an incorrect guess
	 * 
	 * @precondition newAnimal!=null AND !newAnimal.isBlank() AND newQuestion!=null AND !newQuestion.isBlank()
	 * @postcondition new animal and question are added to the tree
	 *
	 * @param newAnimal the new animal
	 * @param newQuestion the distinguishing question
	 * @param questionIsTrue true if the answer to the question is "yes", false if "no"
	 */
	public void addAnimalAfterWrongGuess(String newAnimalName, String newQuestion, boolean questionIsTrue) {
		if (newAnimalName == null || newAnimalName.isBlank()) {
			throw new IllegalArgumentException("New animal cannot be null or blank");
		}
		if (newQuestion == null || newQuestion.isBlank()) {
			throw new IllegalArgumentException("New question cannot be null or blank");
		}
		
		String oldAnimalName = this.getCurrNode().getValue();
		
		String newLeftValue;
		String newRightValue;
		if (questionIsTrue) {
			newLeftValue = oldAnimalName;
			newRightValue = newAnimalName;
		} else {
			newLeftValue = newAnimalName;
			newRightValue = oldAnimalName;
		}
		
		GameNode<String> newLeftChild = new GameNode<String>(newLeftValue, false);
		GameNode<String> newRightChild = new GameNode<String>(newRightValue, false);
		
		this.gameTree.editCurrNode(newQuestion, true, newLeftChild, newRightChild);

		this.resetGame();
	}

}
