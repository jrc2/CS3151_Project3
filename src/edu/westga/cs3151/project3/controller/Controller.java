package edu.westga.cs3151.project3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3151.project3.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
    }
    
    @FXML
    private void correctGuessClick(ActionEvent event) {
    	this.hideAllButPane(this.startPane);
    	this.showIWonMessage();
    }
    
    @FXML
    private void incorrectGuessClick(ActionEvent event) {
    	if (!this.game.hasChildren()) {
    		this.hideAllButPane(this.youWonPane);
    	} else {
    		//TODO
    	}
    }
    
    @FXML
    private void submitNewAnimalClick(ActionEvent event) {
    	String newAnimalName = this.animalThinkingOfField.getText();
    	String distinguishingQuestion = this.animalQuestionField.getText();
    	boolean questionIsTrue = this.answerYesRadioButton.isSelected();
    }
    
    private void hideAllButPane(Pane pane) {
    	this.animalGuessPane.setVisible(false);
    	this.youWonPane.setVisible(false);
    	pane.setVisible(true);
    }
    
    private void showIWonMessage() {
    	this.welcomeMessageText.setVisible(false);
    	this.iWonText.setVisible(true);
    }
    
    private void setAnimalGuess(String animalName) {
    	this.animalGuessText.setText("Is your animal a " + animalName + "?");
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
        this.setAnimalGuess(this.game.getCurrNode().getValue());
    }
}
