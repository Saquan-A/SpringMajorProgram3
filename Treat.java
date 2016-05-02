/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author saqua
 */
//Extends the circle class and creates treats
public class Treat extends Circle{
    private int points = 0;
    private int treatType = 0;
        
    Random rand = new Random();
    public Treat(){
        int random = rand.nextInt(800);
//        this.setCenterX(rand.nextInt(800)+40);
//        this.setCenterY(rand.nextInt(600)+40);
        this.setRadius(3);
        this.setFill(Color.AQUA); //Creates treats and sets the colors
        
    }
    public Treat(boolean stuff){
        
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the treatType
     */
    public int getTreatType() {
        return treatType;
    }

    /**
     * @param treatType the treatType to set
     */
    public void setTreatType(int treatType) {
        this.treatType = treatType;
    }
    
}
