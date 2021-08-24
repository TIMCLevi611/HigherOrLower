/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package higher.or.lower;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 *
 * @author lsnyder
 */
public class HigherOrLower extends Application {
    Random rnd = new Random();
    private int rndNumber = (int)(rnd.nextDouble() * 100);
    
    Image questionMark = new Image("Images/Q.png");
    Image higher = new Image("Images/Higher.png");
    Image lower = new Image("Images/Lower.png");
    Image correct = new Image("Images/Correct.png");
    
    @Override
    public void start(Stage primaryStage) 
    {
        ImageView imageView = new ImageView(questionMark);
        imageView.setLayoutX(120);
        imageView.setLayoutY(20);
        
        TextField textField = new TextField();
        textField.setLayoutY(110);
        textField.setLayoutX(75);
        
        Label text = new Label();
        text.setLayoutY(80);
        text.setLayoutX(40);
        text.setText("");
        
        Label instructions = new Label();
        instructions.setLayoutX(80);
        instructions.setText("Guess a random number.");
        
        Button btn = new Button();
        btn.setLayoutY(150);
        btn.setLayoutX(120);
        btn.setText("Guess");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                int userGuess = Integer.parseInt(textField.getText());
                if(rndNumber == userGuess)
                {
                    text.setText("You guessed Correctly.");
                    imageView.setImage(correct);
                }
                
                else if (rndNumber > userGuess)
                {
                    text.setText("Your guess is lower then the right number.");
                    imageView.setImage(lower);
                }
                
                else
                {
                    text.setText("Your guess is Higher then the right number.");
                    imageView.setImage(higher);
                }
            }
        });
        
        Button btnReset = new Button();
        btnReset.setLayoutY(180);
        btnReset.setLayoutX(121);
        btnReset.setText("Reset");
        btnReset.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                rndNumber = (int)(rnd.nextDouble() * 100);
                imageView.setImage(questionMark);
                text.setText("");
            }
        });
        
        Button btnExit = new Button();
        
        
        Group root = new Group();
        root.getChildren().addAll(btn, text, textField, instructions, btnReset, btnExit, imageView);
        
        Scene scene = new Scene(root, 300, 250);
        
        btnExit.setLayoutY(210);
        btnExit.setLayoutX(125);
        btnExit.setText("Exit");
        btnExit.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.close();
            }
        });
        
        primaryStage.setTitle("Higher or Lower!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
