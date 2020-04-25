package edu.westga.cs3151.project3.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3151.project3.model.Game;
import edu.westga.cs3151.project3.model.GameNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * The Class GUICodeBehind.
 * 
 * @author John Chittam
 */
public class Controller {
	
	private Game game;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane startPane;

    @FXML
    private Text welcomeMessageText;

    @FXML
    private Text iWonText;

    @FXML
    private Pane animalGuessPane;

    @FXML
    private Text animalGuessText;

    @FXML
    private Button correctAnimalGuessButton;

    @FXML
    private Button incorrectAnimalGuessButton;
    
    @FXML
    private Pane youWonPane;

    @FXML
    private TextField animalThinkingOfField;

    @FXML
    private TextField animalQuestionField;

    @FXML
    private RadioButton answerYesRadioButton;

    @FXML
    private ToggleGroup answerRadioButtons;

    @FXML
    void startButtonAction(ActionEvent event) {
    	this.animalGuessPane.setVisible(true);
    	this.setGuess(this.game.getCurrNode());
    }
    
    @FXML
    private void correctGuessClick(ActionEvent event) {
    	if (!this.game.hasChildren()) {
    		this.game.resetGame();
    		this.hideAllButPane(this.startPane);
        	this.showIWonMessage();
    	} else {
    		this.game.setNodeAfterAnswer(true);
    		this.setGuess(this.game.getCurrNode());
    	}
    }
    
    @FXML
    private void incorrectGuessClick(ActionEvent event) {
    	if (!this.game.hasChildren()) {
    		this.hideAllButPane(this.youWonPane);
    	} else {
    		this.game.setNodeAfterAnswer(false);
    		this.setGuess(this.game.getCurrNode());
    	}
    }
    
    @FXML
    private void submitNewAnimalClick(ActionEvent event) {
    	String newAnimalName = this.animalThinkingOfField.getText();
    	String distinguishingQuestion = this.animalQuestionField.getText();
    	boolean questionIsTrue = this.answerYesRadioButton.isSelected();
    	try {
    		this.game.addAnimalAfterWrongGuess(newAnimalName, distinguishingQuestion, questionIsTrue);
        	this.animalThinkingOfField.clear();
        	this.animalQuestionField.clear();
        	this.hideAllButPane(this.startPane);
        	this.welcomeMessageText.setVisible(true);
        	this.iWonText.setVisible(false);
    	} catch (IllegalArgumentException exception) {
    		Alert errorPopup = new Alert(AlertType.ERROR);
    		 
    		errorPopup.setTitle("Error");
    		errorPopup.setHeaderText("Invalid Input");
    		errorPopup.setContentText(exception.getMessage());
    		 
    		errorPopup.showAndWait();
    	}
    }
    
    private void hideAllButPane(Pane pane) {
    	this.animalGuessPane.setVisible(false);
    	this.youWonPane.setVisible(false);
    	this.startPane.setVisible(false);
    	pane.setVisible(true);
    }
    
    private void showIWonMessage() {
    	this.welcomeMessageText.setVisible(false);
    	this.iWonText.setVisible(true);
    }
    
    private void setGuess(GameNode<String> node) {
    	if (node.getIsQuestionNode()) {
    		this.animalGuessText.setText(node.getValue());
    	} else {
    		this.animalGuessText.setText("Is your animal a " + node.getValue() + "?");
    	}
    	
    }
    
    @FXML
    void saveGameAction(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Game Save File");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Animal Tree File", "*.atf"));
		File selectedFile = fileChooser.showSaveDialog(null);
		
		if (selectedFile != null) {
			this.game.saveGame(selectedFile.getPath());
		}
    	
    }
    
    @FXML
    void loadGameClick(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Game Save File");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Animal Tree File", "*.atf"));
		File selectedFile = fileChooser.showOpenDialog(null);
		
		if (selectedFile != null) {
	    	this.game.loadGame(selectedFile.getPath());
		}
		
    	
    }

    @FXML
    void initialize() {
    	assert this.startPane != null : "fx:id=\"startPane\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.welcomeMessageText != null : "fx:id=\"welcomeMessageText\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.iWonText != null : "fx:id=\"iWonText\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.animalGuessPane != null : "fx:id=\"animalGuessPane\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.animalGuessText != null : "fx:id=\"animalGuessText\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.correctAnimalGuessButton != null : "fx:id=\"correctAnimalGuessButton\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.incorrectAnimalGuessButton != null : "fx:id=\"incorrectAnimalGuessButton\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.youWonPane != null : "fx:id=\"youWonPane\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.animalThinkingOfField != null : "fx:id=\"animalThinkingOfField\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.animalQuestionField != null : "fx:id=\"animalQuestionField\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.answerYesRadioButton != null : "fx:id=\"answerYesRadioButton\" was not injected: check your FXML file 'GUI.fxml'.";
        assert this.answerRadioButtons != null : "fx:id=\"answerRadioButtons\" was not injected: check your FXML file 'GUI.fxml'.";

        this.game = new Game();
    }
}
