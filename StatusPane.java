/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author saqua
 */
public class StatusPane extends HBox {
    private int score = 0;
    ;
   // private final SimpleStringProperty scoreing = new SimpleStringProperty("Score"+Score);
    
    //Creating and instaniating the labels for the game
    private Label lblScore = new Label("Score " + score);
    
    
    private int level = 1;
    private Label lblLevel = new Label("Level "+level);
    private int lives = 3;
    private Label lblLives = new Label("Lives "+lives);
    
    public StatusPane(){
        //Adds the labels and sets there fonts and color
        lblScore.setFont(new Font("Arial", 20));
        lblScore.setTextFill(Color.WHITE);
        
        lblLevel.setFont(new Font("Arial", 20));
        lblLevel.setTextFill(Color.BLUE);
        
        lblLives.setFont(new Font("Arial", 20));
        lblLives.setTextFill(Color.RED);
       // lblScore.textProperty().bind(lblScore.textProperty());
        this.getChildren().add(lblScore);
        this.getChildren().add(lblLevel);
        this.getChildren().add(lblLives);
        this.setPadding(new Insets(10,10,10,10));
        this.setAlignment(Pos.BOTTOM_LEFT);
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score =+ score;
    }

    /**
     * @return the lblScore
     */
    public Label getLblScore() {
        return lblScore;
    }

    /**
     * @param lblScore the lblScore to set
     */
    public void setLblScore(Label lblScore) {
        this.lblScore = lblScore;
        //score += 10;
        //this.lblScore.setText("Score "+score);
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level -= level;
    }

    /**
     * @return the lblLevel
     */
    public Label getLblLevel() {
        return lblLevel;
    }

    /**
     * @param lblLevel the lblLevel to set
     */
    public void setLblLevel(Label lblLevel) {
        this.lblLevel = lblLevel;
    }

    /**
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * @return the lblLives
     */
    public Label getLblLives() {
        return lblLives;
    }

    /**
     * @param lblLives the lblLives to set
     */
    public void setLblLives(Label lblLives) {
        this.lblLives = lblLives;
    }
    
    
}
