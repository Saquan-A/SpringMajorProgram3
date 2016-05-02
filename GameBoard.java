/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;


import java.util.Random;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author saqua
 */
//Gameboard class that sets up the treats in a grid
public class GameBoard extends GridPane{
    StatusPane sPane = new StatusPane();
    Gobbler gob = new Gobbler(49);
    private double posX = 0;
    private double posY = 0;
    private GridPane grid = new GridPane();
    private Treat treat;
    int score = 0;
    private int numRows = 10;
    private int numCols = 10;
    private int numTreats = 0;
    private int numEaten = 0;
    private Treat[][] treats = new Treat[13][18]; // creats a treats 2d of 13x18
    private Obstacles obstacle;
    private Obstacles[][] obstacles = new Obstacles[13][18];
    private Treat[] treaty;
    private int blockSize = 0;
    private Rectangle rec = new Rectangle();
    //private int treat = 1;
    int i = 0;
    Random random = new Random();
    int rand = 0;
    
    public GameBoard(int blockSize){
        
//        numRows = blockSize;
//        numCols = blockSize;
        
        //Treat circle = new Treat();
        
       // numTreats = random.nextInt(30);
        //treats = new Treat[numCols][numRows];
        //treaty = new Treat[numRows];
//        for(int i = 0; i< numCols; i++){
//            for(int j = 0; i< numRows; i++){
//                Treat circle = new Treat();
//                treats[i][j] = circle;
//                this.getChildren().add(treats[i][j]);
//                
//            }
//        }
        
//        for(int i = 0; i<numRows; i++){
//            Treat circle = new Treat();
//                treaty[i] = circle;
//                this.getChildren().add(treaty[i]);
//        }
      //for(int i = 0; i < 10; i++){
          
                  rand = random.nextInt(120)+50; //sets a random number to determain how many treats to remove from the board
                
                  for(int x=0; x<18; x++){
                     for (int y=0; y<13; y++){
                       obstacle = new Obstacles();
                       obstacles[y][x] = obstacle;
                      // GridPane.setHalignment(treat, HPos.CENTER);
                      // GridPane.setValignment(treat, VPos.CENTER);
                 // this.setPrefSize(blockSize, blockSize);
                    grid.add(obstacles[y][x], x, y);
                  
                  
                     }
                  }
                  //Adds treats to the gameboard in a grid fashion
                    for(int x=0; x<18; x++){
                     for (int y=0; y<13; y++){
                       treat = new Treat();
                       treats[y][x] = treat;
                       GridPane.setHalignment(treat, HPos.CENTER);
                       GridPane.setValignment(treat, VPos.CENTER);
                 // this.setPrefSize(blockSize, blockSize);
                  this.add(treats[y][x], x, y);
                  
                     }
                     
                     
                  }
                    //removes random amounts of treats, in random locations
                  while(i != rand){
                      int x = random.nextInt(18);
                      int y = random.nextInt(13);
                      posX = treats[y][x].getCenterX();
                      posY = treats[y][x].getCenterY();
                     obstacles[y][x].setLayoutX(posX);
                     obstacles[y][x].setLayoutY(posY);
                      
                      this.getChildren().remove(treats[y][x]);
                     // this.getChildren().add(obstacles[y][x]);
                     
                              
                      i++;
                      
                  }
                 
          //this.getChildren().add(grid);
          //Adds everything to game board and sets its postion and spacing
          this.setAlignment(Pos.CENTER);
          grid.setVgap(blockSize);
          grid.setHgap(blockSize);
          this.setVgap(blockSize);
          this.setHgap(blockSize);
         // this.getChildren().add(grid);
//              Treat streat = new Treat();
//              //treaty[i] = streat;
//        this.setPrefSize(blockSize, blockSize);
//      treaty[i] = streat;
//        
//        this.getChildren().add(treaty[i]);
//        i++;
          
      //}
      
        
        //treaty[i] = streat;
        //i++;
        

        
        
    }
    //Method to eat Treats by passing in gobbler 
    public void eatTreat(Gobbler gobbler, StatusPane sPane){
        boolean collision = false;
//        for(int i=0;i<numCols;i++){
//            for(int j = 0; j<numRows;j++){
//               if(gobbler.getBoundsInParent().intersects(treats[i][j].getBoundsInParent())){
//            treats[i][j].setFill(Color.RED);
//                   
//                   
//        } 
//               
//            }
//        }
        
            
//        for(int i = 0; i<1; i++){
//            
//            Treat circle = new Treat();
//              if(gobbler.getBoundsInParent().intersects(treaty[i].getBoundsInParent())){
//            
//            this.getChildren().remove(treaty[i]);
//            score += 10;
//            sPane.getLblScore().setText("Score " + score);
//            String newScore = sPane.getLblScore().getText();
//            
//            
//            
//                   
//                   
//        } 
//        }
//       
//      for(int i = 0; i < 10; i++){
//          for(int j = 0; j <10; j++){
//             if(treats[i][j].getBoundsInParent().intersects(gobbler.getBoundsInParent())){
//                 this.getChildren().remove(treats[i][j]);
//             }
//        
//          }
//      }
        //loop to see if a gobbler intersects a treat and if it does increment the score by 10 also removing the treat from board and array
       for(int x=0; x<18; x++){
            for (int y=0; y<13; y++){
             if(gobbler.getBoundsInParent().intersects(treats[y][x].getBoundsInParent())){ //intersects creates a rectanglar border around images or shapes and checks and see if those shapes collide
                 
                 this.getChildren().remove(treats[y][x]);
                 treats[y][x] = new Treat();
                 treats[y][x].setCenterX(700);
                 treats[y][x].setCenterY(700);
                         ;
                 score += 10;
                 sPane.getLblScore().setText("Score " + score);
                 String newScore = sPane.getLblScore().getText();
                
            
             }
            }
      }
       
//        if(gobbler.getBoundsInParent().intersects(this.getTreat().getBoundsInParent())){
//          
//            this.getTreat().setFill(Color.RED);
//            //grid.getChildren().remove(game);
//        }
    }

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @param numRows the numRows to set
     */
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     * @return the numCols
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * @param numCols the numCols to set
     */
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    /**
     * @return the numTreats
     */
    public int getNumTreats() {
        return numTreats;
    }

    /**
     * @param numTreats the numTreats to set
     */
    public void setNumTreats(int numTreats) {
        this.numTreats = numTreats;
    }

    /**
     * @return the numEaten
     */
    public int getNumEaten() {
        return numEaten;
    }

    /**
     * @param numEaten the numEaten to set
     */
    public void setNumEaten(int numEaten) {
        this.numEaten = numEaten;
    }

    /**
     * @return the treats
     */
    public Treat[][] getTreats() {
        return treats;
    }

    /**
     * @param treats the treats to set
     */
    public void setTreats(Treat[][] treats) {
        this.treats = treats;
    }

    /**
     * @return the blockSize
     */
    public int getBlockSize() {
        return blockSize;
    }

    /**
     * @param blockSize the blockSize to set
     */
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * @param treat the treat to set
     */
    public void setTreat(Treat treat) {
        this.treat = treat;
    }

    /**
     * @return the treat
     */
    public Treat getTreat() {
        return treat;
    }

    /**
     * @return the posX
     */
    public double getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(double posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public double getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(double posY) {
        this.posY = posY;
    }
    
}
