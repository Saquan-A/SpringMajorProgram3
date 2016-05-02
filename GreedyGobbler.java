/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmajorprogram3;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author saqua
 */
public class GreedyGobbler extends Application{
    //private Gobbler gobbler;
    private Gobbler gobbler = new Gobbler(50.0f); //creates the gobbler
 
    private GameBoard game = new GameBoard(50); //creates the gameboard
    private BaddyPants[] baddyPanes = new BaddyPants[4]; //makes an array of baddy pants
    private CommandPane commandPane = new CommandPane(this); //Creates commandpane
    private StatusPane statusPane = new StatusPane(); // creates the status pane
    private Stage stage;
    private GridPane grid = new GridPane();
    private Group root = new Group();
    private BorderPane border = new BorderPane(); //creates the border pane
    //Size of the screen
    private final int WIDTH = 980;
    final int HEIGHT = 720;
    private int radius;
    Image image = new Image("/Images/GhostR.png");
    ImageView iV = new ImageView();
    private int lives = 3;
  
    
        //AnimationTimer that keeps everything constantly moving on the screen as well as constantly checking to see if anything collides with each other
       private AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
               baddyPanes[0].move();
               baddyPanes[1].move();
               baddyPanes[2].move();
               baddyPanes[3].move();
               gobbler.move();
               game.eatTreat(gobbler, statusPane);
               checkCollision();
              // baddyPanes[0].rotateMouth(0);
            }
           
       };
    
    
    //Restart method that will reset the game
   public void restart(){
       
       //Removes everything from the panes
        for(int i=0;i<4;i++){
            getRoot().getChildren().remove(getBaddyPanes()[i]);
        }
       
     this.getBorder().getChildren().remove(this.getRoot());
       getRoot().getChildren().remove(getGobbler());
        getRoot().getChildren().remove(getGame());
        getRoot().getChildren().remove(getStatusPane());
     //Creates new objects
     gobbler = new Gobbler(50);
     game = new GameBoard(50);
     statusPane = new StatusPane();
     
     //re-adds everything back into the game
     this.setGobbler(gobbler);
     this.setGame(game);
     this.setStatusPane(statusPane);
     
      for(int i=0;i<4;i++){
            BaddyPants baddy = new BaddyPants(i);
            getBaddyPanes()[i] = baddy;
            getRoot().getChildren().add(getBaddyPanes()[i]);
        }
     
      getRoot().getChildren().add(this.getGobbler());
      getRoot().getChildren().add(this.getGame());
      //getRoot().getChildren().add(this.getStatusPane());
      //sets lives back to 3
      this.setLives(3);
      
     
     this.getBorder().getChildren().add(this.getRoot());
     this.getBorder().setTop(this.getStatusPane());
     //start(stage);
     timer.stop();
        
        
        
        
        
   }
   
   public void newLevel(){
       
   }
   public void chase(){
       
   }
   //Method that checks and sees if a gobbler is hit by a baddypantw
   public void checkCollision(){
       
       if(getLives() <= 0){
           // getTimer().stop();
           //Allows the palyer to to choose if they want to restart the game or exit if they run out of lives
            String options[] = {"Yes","No"};
            int prompt = JOptionPane.showOptionDialog(null, "Would you like to Restart Game?", null, lives, lives, null, options, iV);
            
            
            
            if(prompt == JOptionPane.YES_OPTION){
            
            restart();
           } else if (prompt == JOptionPane.NO_OPTION) {
               System.exit(0);
           }
            
            
           
           
       }
       //If statsments to see to see if a baddypants intersects a gobbler.
       if(getGobbler().getBoundsInParent().intersects(getBaddyPanes()[0].getBoundsInParent())){
            getGobbler().setCenterX(490);
            getGobbler().setCenterY(360);
            setLives(getLives() - 1);
            getStatusPane().getLblLives().setText("Lives "+getLives());
           
           
       }
       if(getGobbler().getBoundsInParent().intersects(getBaddyPanes()[1].getBoundsInParent())){
            getGobbler().setCenterX(490);
            getGobbler().setCenterY(360);
            setLives(getLives() - 1);
            getStatusPane().getLblLives().setText("Lives "+getLives());
       }
       if(getGobbler().getBoundsInParent().intersects(getBaddyPanes()[2].getBoundsInParent())){
            getGobbler().setCenterX(490);
            getGobbler().setCenterY(360);
            setLives(getLives() - 1);
            getStatusPane().getLblLives().setText("Lives "+getLives());
       }
       if(getGobbler().getBoundsInParent().intersects(getBaddyPanes()[3].getBoundsInParent())){
            getGobbler().setCenterX(490);
            getGobbler().setCenterY(360);
            setLives(getLives() - 1);
            getStatusPane().getLblLives().setText("Lives "+getLives());
       }
   }
    
          public static void main(String[] args) {
        Application.launch(GreedyGobbler.class, args);
    }
    
    @Override
    public void start(Stage primary) throws Exception{
        for(int i=0;i<4;i++){ //adds baddypants to to the array
            BaddyPants baddy = new BaddyPants(i);
            getBaddyPanes()[i] = baddy;
            getRoot().getChildren().add(getBaddyPanes()[i]);
        }
//        
//    iV.setImage(image);
//    iV.setX(400);
//    iV.setY(400);
    //final BaddyPants ghostRed = new BaddyPants(iV);
    //baddyPanes = new BaddyPants[]{ghostRed};
    
    
//     for(int x=0; x<10; x++){
//            for (int y=0; y<7; y++){
//                 game = new GameBoard(100, x, y);
//                 
//                 grid.add(game, x, y);
//                 
//                 
//        
//        
//            }
//        }
     
   //  grid.setAlignment(Pos.CENTER);
    // root.getChildren().add(grid);
        
        getRoot().getChildren().add(getGobbler());
        getRoot().getChildren().add(getGame());
        
        getRoot().getChildren().add(getStatusPane());
        
        
        
  //   root.getChildren().add(commandPane);
     //root.set
     
    // border.setTop(statusPane);
     // border.setCenter(game);
     // border.getChildren().add(game);
     //border.getChildren().add(gobbler);
     //border.setCenter(gobbler);
    
    
     //border.setBottom(commandPane);
     
    
//       AnimationTimer timer = new AnimationTimer() {
//
//            @Override
//            public void handle(long l) {
//               baddyPanes[0].move();
//               baddyPanes[1].move();
//               baddyPanes[2].move();
//               baddyPanes[3].move();
//               gobbler.move();
//               game.eatTreat(gobbler, statusPane);
//               checkCollision();
//              // baddyPanes[0].rotateMouth(0);
//            }
//           
//       };
     
    
//    root.getChildren().add(game);
//    root.getChildren().add(gobbler);
//    root.getChildren().add(statusPane);
   
    
    
    
    //root.getChildren().addAll(baddyPanes);
    // root.getChildren().add(iV);
        getBorder().getChildren().add(getRoot());
        //getRoot().requestFocus();
        getBorder().setBottom(getCommandPane());
        
        //getBorder().setFocusTraversable(false);
       
  
    
    primary.setTitle("PacMan Spring Game");
  
      Scene scene = new Scene(getBorder(), WIDTH, HEIGHT, Color.BLACK);
      scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
       
        @Override
        public void handle(KeyEvent event) { //handler to move the gobbler using either the arrow keys or WASD
            //To change body of generated methods, choose Tools | Templates.
            //game.eatTreat(gobbler, statusPane);
            
        if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W){
           
           
            //gobbler.move();
                    getGobbler().rotateMouth(1);
           // game.eatTreat(gobbler, statusPane);
            
            
            
           
            
            
        
    }
        if(event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S){
            //gobbler.move();
                    getGobbler().rotateMouth(3);
            //game.eatTreat(gobbler, statusPane);
    }
        if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D){
            //gobbler.move();
                    getGobbler().rotateMouth(0);
            //game.eatTreat(gobbler, statusPane);
            
        
    }
        if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A){
            // gobbler.move();
                    getGobbler().rotateMouth(2);
           // game.eatTreat(gobbler, statusPane);
        
    }
        }
    });
      
//      Timeline line = new Timeline();
//      line.setCycleCount(Animation.INDEFINITE);
//      line.setAutoReverse(true);
//      
//      KeyValue start = new KeyValue(gobbler.startAngleProperty(),0);
//      KeyValue stop = new KeyValue(gobbler.lengthProperty(), 360);
//      
//      KeyFrame key = new KeyFrame(Duration.millis(40),start,stop);
//      line.getKeyFrames().add(key);
//      line.play();
              
   
    primary.setScene(scene);
    primary.show();
    getTimer().stop();
    primary.setResizable(false);
   

        
    }

    /**
     * @return the gobbler
     */
    public Gobbler getGobbler() {
        return gobbler;
    }

    /**
     * @param gobbler the gobbler to set
     */
    public void setGobbler(Gobbler gobbler) {
        this.gobbler = gobbler;
    }

    /**
     * @return the game
     */
    public GameBoard getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(GameBoard game) {
        this.game = game;
    }

    /**
     * @return the baddyPanes
     */
    public BaddyPants[] getBaddyPanes() {
        return baddyPanes;
    }

    /**
     * @param baddyPanes the baddyPanes to set
     */
    public void setBaddyPanes(BaddyPants[] baddyPanes) {
        this.baddyPanes = baddyPanes;
    }

    /**
     * @return the commandPane
     */
    public CommandPane getCommandPane() {
        return commandPane;
    }

    /**
     * @param commandPane the commandPane to set
     */
    public void setCommandPane(CommandPane commandPane) {
        this.commandPane = commandPane;
    }

    /**
     * @return the statusPane
     */
    public StatusPane getStatusPane() {
        return statusPane;
    }

    /**
     * @param statusPane the statusPane to set
     */
    public void setStatusPane(StatusPane statusPane) {
        this.statusPane = statusPane;
    }

    /**
     * @return the grid
     */
    public GridPane getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    /**
     * @return the root
     */
    public Group getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * @return the border
     */
    public BorderPane getBorder() {
        return border;
    }

    /**
     * @param border the border to set
     */
    public void setBorder(BorderPane border) {
        this.border = border;
    }

    /**
     * @return the timer
     */
    public AnimationTimer getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
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
    
    
    
    
    
}
