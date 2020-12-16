package simpleUserInterface;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.*;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

////////////////////////////////////////
// This program was modified by       //
// adding additional colors to change //
// the background to.                 //
////////////////////////////////////////


public class UserInterfaceI extends Application { 
  
    // launch the application 
    public void start(Stage s) 
    { 
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        // set title for the stage 
        s.setTitle("Working menubar"); 
  
        //Creating the menu and the menubar
        Menu m = new Menu("Menu"); 
        MenuBar mb = new MenuBar(); 
  
        //Creating the separate items/buttons for the menu bar
        MenuItem m1 = new MenuItem("display date"); 
        MenuItem m2 = new MenuItem("print text file"); 
        MenuItem m3 = new MenuItem("change color green");
        MenuItem m5 = new MenuItem("change color red");
        MenuItem m6 = new MenuItem("change color blue");
        MenuItem m4 = new MenuItem("exit program");
  
        //adding the items to the bar
        m.getItems().add(m1); 
        m.getItems().add(m2); 
        m.getItems().add(m3); 
        m.getItems().add(m5); 
        m.getItems().add(m6); 
        m.getItems().add(m4);
  
        //Creating a label to display 
        Label l = new Label("\t\t\t\t"
                            + "no menu item selected"); 
  
        
        
        //adding the menu drop down to the menu bar
        mb.getMenus().add(m); 
        
        //Creating the visual display to handle the menu and the label
        VBox vb = new VBox(mb, l); 
  
        //Creating the scene to display the VBox
        Scene sc = new Scene(vb, 500, 300); 
        
        
        //Setting event for first menu item clicked
        EventHandler<ActionEvent> firstEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	LocalDateTime now = LocalDateTime.now();
                l.setText("\t\t\t\t" + dtf.format(now)); 
            } 
        }; 
        
        
        //Setting even for second menu item clicked
        EventHandler<ActionEvent> secondEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                String output = l.getText(); 
                PrintWriter out;
				try {
					out = new PrintWriter("log.txt");
					out.println(output);
	                out.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            } 
        }; 
        
        //Setting event for third menu item clicked
        EventHandler<ActionEvent> thirdEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	int r = 0;
            	int b = 0;
            	int g = (int) ((Math.random() * (255 - 55)) + 55);
            	
            	vb.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
            } 
        }; 
        
        //Setting even for last menu item clicked
        EventHandler<ActionEvent> fourthEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	System.exit(0); 
            } 
        }; 
        
        EventHandler<ActionEvent> fifthEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	int g = 0;
            	int b = 0;
            	int r = (int) ((Math.random() * (255 - 55)) + 55);
            	
            	vb.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
            } 
        }; 
        
        EventHandler<ActionEvent> sixthEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	int r = 0;
            	int g = 0;
            	int b = (int) ((Math.random() * (255 - 55)) + 55);
            	
            	vb.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
            } 
        }; 
        
        
        
        //Adding the event listeners to the menu items
        m1.setOnAction(firstEvent); 
        m2.setOnAction(secondEvent); 
        m3.setOnAction(thirdEvent); 
        m4.setOnAction(fourthEvent);
        m5.setOnAction(fifthEvent);
        m6.setOnAction(sixthEvent);
  
               
  
        //Setting the stage and displaying it
        s.setScene(sc); 
  
        s.show(); 
    } 
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 
