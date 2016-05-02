/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import java.io.File;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author saqua
 */
public class CommandPane extends HBox{
    //Buttons for the CommandPane that were placed at the bottom of the screen.
    private Button btnStart = new Button("Start");
    private Button btnPause = new Button("Pause");
    private Button btnRestart = new Button("Restart");
    private Button btnExit = new Button("Exit");
    private GreedyGobbler ggobbler;
   
    
    public CommandPane(final GreedyGobbler ggobbler){
        //Adds buttons to the HBox
        this.getChildren().add(btnStart);
        this.getChildren().add(btnPause);
        this.getChildren().add(btnRestart);
        this.getChildren().add(btnExit);
        //Makes it so that the buttons do not take over focus from the gobbler arrow keys wise
        btnStart.setFocusTraversable(false);
        btnPause.setFocusTraversable(false);
        btnRestart.setFocusTraversable(false);
        btnExit.setFocusTraversable(false);
        this.setPadding(new Insets(10, 10, 10, 10));
        //Places the buttons in the center
        this.setAlignment(Pos.BOTTOM_CENTER);
        
        class MyHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle( ActionEvent e)
        {
	    //e.getSource() returns the button that was clicked.
            Button b = (Button) e.getSource();

            if (b.getText().equals("Start")) {
             ggobbler.getTimer().start(); //Starts the game aka the animation timer
                

            }
            else if (b.getText().equals("Pause")) {
                //exit the application
                ggobbler.getTimer().stop(); //Pauses the game aka stops the animation timer
              

            }
            else if(b.getText().equals("Restart")){ //a maze button was clicked
                //System.exit(0);
                ggobbler.restart(); //restarts the game using a created method in the main
              
                
            
            }
            else if(b.getText().equals("Exit")){ //a maze button was clicked
                System.exit(0); //Closes the program
                
              
                
            
            }
        }
    }
        btnStart.setOnAction(new MyHandler());
        btnPause.setOnAction(new MyHandler());
        btnRestart.setOnAction(new MyHandler());
        btnExit.setOnAction(new MyHandler());
       
    }
     
    
}
