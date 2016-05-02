/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author saqua
 */
public class Gobbler extends Predator {
    
    private final SimpleIntegerProperty currentDir = new SimpleIntegerProperty(1);

    //creats the gobbler or main player
    public Gobbler(float radius) {
        super(radius);
        super.setCenterX(50);
        super.setCenterY(50);
        super.setStyle("-fx-stroke: black");//creates a black line showing the direction of the mouth.
    }
    
    
    @Override
    public void move(){
        super.move();
    }
    
    
}
