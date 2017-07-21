package view; 

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.control.MenuBar; 
import javafx.scene.control.Menu; 
import javafx.scene.control.ListView; 
import javafx.collections.ObservableList; 
import javafx.collections.FXCollections; 
import javafx.scene.layout.GridPane; 
import org.hibernate.service.ServiceRegistry; 
import org.hibernate.SessionFactory; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import org.hibernate.cfg.Configuration;

public class GradeBookView extends Application implements Observer
{ 
	public static void main(String[] args)  
	{
        
    }

	@Override
	public void update(Observable arg0, Object arg1)  
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception  
	{
		BorderPane border = new BorderPane(); 
        border.setPrefSize(400, 400); 
        
        //All menu bar stuff 
        //The menu bar 
        MenuBar menuBar = new MenuBar(); 
        
        //The submenus in the bar  
        Menu menuFile = new Menu("File");  
        Menu menuEdit = new Menu("Edit");  
        
        //adding the menus to the bar
        menuBar.getMenus().addAll(menuFile, menuEdit); 
        border.setTop(menuBar); 
        
        //All todo list stuff 
        //The list view for the current todo 
        ListView<String> list = new ListView<String>(); 
        
        //the part of the list that allows it to dynamically change when changes are made to the 
        //model list 
        ObservableList<String> items = FXCollections.observableArrayList (
            "Single", "Double", "Suite", "Family App"); 
        
        //putting the list items in the list 
        list.setItems(items); 
       
        //setting the width to a prefered size 
        list.setPrefWidth(100); 
        
        //all the other buttons and statuses
        GridPane grid = new GridPane(); 
        
        Text course1 = new Text("Math"); 
        Text course2 = new Text("English"); 
        Text course3 = new Text("CompSci"); 
        Text course4 = new Text("Art"); 
        
        grid.add(course1, 1, 0); 
        grid.add(course2, 1, 1); 
        grid.add(course3, 1, 2); 
        grid.add(course4, 1, 3);
        
        //setting the list to UI 
        border.setLeft(list); 
        border.setCenter(grid); 
       
        
        
        
        
        Scene scene = new Scene(border); 
        
        stage.setTitle("GradeBook");
        stage.setScene(scene); 
        stage.show();
		
	}

}
