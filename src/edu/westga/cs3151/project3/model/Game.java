package edu.westga.cs3151.project3.model;

import java.util.Random;

/**
 * Controls the Game.
 *
 * @author John Chittam
 */
public class Game {
	
	private GameTree<String> gameTree;
	private static final String[] INITIAL_ANIMAL_CHOICES = {"frog", "liger", "sloth", "cat", "koala", "human"};
	
	/**
	 * Instantiates a new game.
	 * 
	 * @precondition gameTree is instantiated
	 * @postcondition none
	 */
	public Game() {
		Random random = new Random();
		int animalChoiceIndex = random.nextInt(7);
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
	public GameTree<String> getGameTree() {
		return this.gameTree;
	}
	
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
		return this.getCurrNode().hasLeftChild() || this.getCurrNode().hasRightChild();
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
	public void addAnimalAfterWrongGuess(String newAnimal, String newQuestion, boolean questionIsTrue) {
		if (newAnimal == null || newAnimal.isBlank()) {
			throw new IllegalArgumentException("New animal cannot be null or blank");
		}
		if (newQuestion == null || newQuestion.isBlank()) {
			throw new IllegalArgumentException("New question cannot be null or blank");
		}
		
		GameNode<String> oldAnimalNode = this.getCurrNode();
		GameNode<String> newQuestionNode = new GameNode<String>(newQuestion, true);
		GameNode<String> newAnimalNode = new GameNode<String>(newAnimal, false);
		
		if (questionIsTrue) {
			newQuestionNode.setLeftChild(newAnimalNode);
			newQuestionNode.setRightChild(oldAnimalNode);
		} else {
			newQuestionNode.setLeftChild(oldAnimalNode);
			newQuestionNode.setRightChild(newAnimalNode);
		}

		this.gameTree.setRoot(newQuestionNode);
	}

}
