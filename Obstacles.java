/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author saqua
 */
public class Obstacles extends Rectangle {
    
    public Obstacles(){
        //this.setArcHeight(10);
       // this.setArcWidth(10);
        this.setHeight(12);
        this.setWidth(16);
        this.setFill(Color.GREEN);
        this.setStyle("-fx-stroke: black");
    }
    
}
