package edu.westga.cs3151.project3.model;

import java.util.Random;

import edu.westga.cs3151.project3.utils.LoadFromXML;
import edu.westga.cs3151.project3.utils.SaveToXML;

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
	
	/**
	 * Advances curr node to proper child based on answer to question.
	 * 
	 * @precondition none
	 * @postcondition gameTree.currNode==gameTree.currNode.left || gameTree.currNode==gameTree.currNode.right
	 *
	 * @param answer true if "yes", false if "no"
	 */
	public void setNodeAfterAnswer(boolean answer) {
		if (answer) {
			this.gameTree.goToRightChild();
		} else {
			this.gameTree.goToLeftChild();
		}
		
	}
	
	/**
	 * Sets curr node back to root.
	 * 
	 * @precondition none
	 * @postcondition this.gameTree.currNode==this.gameTree.root
	 */
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
	 * @param newAnimalName the new animal
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
	
	/**
	 * Saves game tree to given file.
	 * 
	 * @precondition none
	 * @postcondition file written if no errors
	 *
	 * @param filename the filename
	 */
	public void saveGame(String filename) {
		SaveToXML.writeGameTreeToXML(this.gameTree, filename);
	}
	
	/**
	 * Loads game tree from given file.
	 * 
	 * @precondition none
	 * @postcondition game tree loaded if no errors
	 *
	 * @param filename the filename
	 */
	public void loadGame(String filename) {
		GameTree<String> gameTree = LoadFromXML.loadGameTreeFromXML(filename);
		this.gameTree = gameTree;
		this.resetGame();
	}

}
