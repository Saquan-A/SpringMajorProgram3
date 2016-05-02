/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

/**
 *
 * @author saqua
 */
//extends the arc
public abstract class Predator extends Arc{
    private static final int increment = 7;
    private float mouthAngle = 0.0f;
    
    private int xdirection;
    public Circle cirle = new Circle();
  
    private int ydirection;
    
    private int x;
    private int y;
    
    private static final int MOVING = 5; // how fast the exteded predators will move across the screen
    private static final int STOPPED = 0;
  
    private static final int MOVE_WEST = 2;
    private static final int MOVE_NORTH = 1;
    private static final int MOVE_EAST = 0;
    private static final int MOVE_SOUTH = 3;
    private Random rand = new Random();
    
    
    public Predator(float radius){
        
        this.setCenterX(500);
        this.setCenterY(500);
        this.setRadiusX(radius/2);
        this.setRadiusY(radius/2);
        this.setStartAngle(45.0f);
        this.setLength(270.0f);
        this.setType(ArcType.ROUND); 
        this.setFill(Color.YELLOW);
        //this.setStyle("-fx-stroke: black");
        
    }
    
    public Predator(){
        
    }
    public void rotateMouth(int dir){
        //changes the mouth depending on the number between 0 - 3
        switch(dir){
            case 3: if(this.getLength() == 270){
                this.setStartAngle(-45);
            } else {
                this.setStartAngle(-90);
            } setXdirection(3); break;
            
            case 2: if(this.getLength() == 270){
                this.setStartAngle(-135);
            } else {
                this.setStartAngle(180);
            } setXdirection(2); break;
                
            case 1: if(this.getLength() == 270){
                this.setStartAngle(135);
            } else {
                this.setStartAngle(90);
            } setXdirection(1); break;
            
            case 0: if(this.getLength() == 270){
                this.setStartAngle(45);
            } else {
                this.setStartAngle(0);
            } setXdirection(0); break;    
        }
    }
    public void AnimateMouth(){
        //opens and closes the mouth based on the current direction of the gobbler
        switch(getXdirection()){
            case 3: if(this.getStartAngle() == -90){
                
            }
                
            
        }
    }
    public void move(){
     //Moves the predator and also creates bounds since my screen is 980 by 720 my bounds are set to similar limits
        switch(getXdirection()){
            case 3: if(this.getLength() == 270){
                this.setLength(360);//360
               
                this.setStartAngle(-90);//-90
                if(this.getCenterY()+50 + MOVING < 720 + 5){
                this.setCenterY(this.getCenterY()+MOVING);
                }
            } else {
                this.setStartAngle(-45);
                this.setLength(270);
            } break;
            
            case 2: if(this.getLength() == 270){
                this.setLength(360);//360
                this.setStartAngle(180);//180
                if(this.getCenterX()+50 - MOVING > 70){
                this.setCenterX(this.getCenterX()-MOVING);
                }
                
            } else {
                this.setStartAngle(-135);
                this.setLength(270);
            } break;
                
            case 1: if(this.getLength() == 270){
                this.setLength(360);//360
                this.setStartAngle(90);//90
                if(this.getCenterY()+50 - MOVING > 70){
                this.setCenterY(this.getCenterY()-MOVING);
                } else {
                    this.setCenterY(this.getCenterY() + STOPPED);
                }
            } else {
                this.setStartAngle(135);
                this.setLength(270);
            } break;
            
            case 0: if(this.getLength() == 270){
                this.setLength(360);//360
                this.setStartAngle(0);//0
                if(this.getCenterX()+50 + MOVING < 980 +40){
                this.setCenterX(this.getCenterX()+MOVING);
                }
            } else {
                this.setStartAngle(45);
                this.setLength(270);
            } break;    
        }
        
      
    }

    /**
     * @return the increment
     */
    public int getIncrement() {
        return increment;
    }

    /**
     * @param increment the increment to set
     */
//    public void setIncrement(int increment) {
//        this.increment = increment;
//    }

    /**
     * @return the mouthAngle
     */
    public float getMouthAngle() {
        return mouthAngle;
    }

    /**
     * @param mouthAngle the mouthAngle to set
     */
    public void setMouthAngle(float mouthAngle) {
        this.mouthAngle = mouthAngle;
    }

    /**
     * @return the xdirection
     */
    public int getXdirection() {
        return xdirection;
    }

    /**
     * @param xdirection the xdirection to set
     */
    public void setXdirection(int xdirection) {
        this.xdirection = xdirection;
    }

    /**
     * @return the direction
     */
//    public int getDirection() {
//        return direction;
//    }
//
//    /**
//     * @param direction the direction to set
//     */
//    public void setDirection(int direction) {
//        this.direction = direction;
//    }
    
    
}
