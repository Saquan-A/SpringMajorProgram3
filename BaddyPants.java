/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author saqua
 */
//Creates the baddypants by extending predator
public class BaddyPants extends Predator{
    
    private static final Image ghostR = new Image("Images/GhostR.png");
    
    private static final Image ghostP = new Image("Images/GhostP.png");
    
    private static final Image ghostB = new Image("Images/GhostB.png");
    
    private static final Image ghostO = new Image("Images/GhostO.png");
    
    ImageView iV = new ImageView();
    
     private static final Image[] ghosts = new Image[] {
    ghostR,
    ghostP,
    ghostB,
    ghostO
  };

    
    private int mode = 0;
    private int steps = 10;
    private int blockSize = 0;
    private Random random = new Random();
    
    //Creates baddypants and passes an int to dertmain the color of the baddypants
    public BaddyPants(int type){
         super(50);
        // super.setCenterX(random.nextInt(940));
        // super.setCenterY(random.nextInt(700));
        if(type == 0){
         super.setFill(Color.RED);
         
        }
        if(type == 1){
           super.setFill(Color.PINK);
          
        }
        if(type == 2){
            super.setFill(Color.BLUE);
           
        }
        if(type == 3){
            super.setFill(Color.ORANGE);
           
        }
    }
    
    public BaddyPants(){
        
    }
    
    public void setRandomDirection(){
        super.rotateMouth(random.nextInt(4));
        
    }
    public void resetSteps(){
        Random rand = new Random();
        steps = rand.nextInt(30)+10;
    }
    @Override
    //AI for the the baddypants
    public void move(){
       super.move();
       steps--;
       if(steps == 0){
           setRandomDirection();
           resetSteps();
       }
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * @return the steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     * @param steps the steps to set
     */
    public void setSteps(int steps) {
        this.steps = steps;
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
    
    
}
