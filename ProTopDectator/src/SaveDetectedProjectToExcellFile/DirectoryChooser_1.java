/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveDetectedProjectToExcellFile;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Martins
 */
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.geometry.*; 
import javafx.scene.paint.*; 
import javafx.scene.canvas.*; 
import javafx.scene.text.*; 
import javafx.scene.Group; 
import javafx.scene.shape.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser; 
import javafx.stage.Modality;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import protopdectator.AllStaticVariable;
import protopdectator.AutoCompTableColumnDataPop;

  
public class DirectoryChooser_1 implements AllStaticVariable{ 
 static  File file;
    // launch the application 
             ImageView imageView1setToClick = new ImageView(this.getClass().getResource("/images/icons/Publish.png").toExternalForm());

   static Stage selectdirectorystag;
    public static void DirectoryChooser_1SatgeViewer() 
    { 
  
        try { 
  
            // set title for the stage 
            selectdirectorystag.setTitle("Export To Excell File (.xlsx)"); 
  
            // create a Directory chooser 
            DirectoryChooser dir_chooser = new DirectoryChooser(); 
            TextField nameoffile = new TextField();
            nameoffile.setPrefSize(200, 10);
            
            Text txtname = new Text("Name of File");
            txtname.setFill(Paint.valueOf("red"));
            txtname.setFont(Font.font(30));
            
             Text txtnameFormat = new Text("File Format : excell_Workbook (.xlsx)");
            txtnameFormat.setFill(Paint.valueOf("red"));
            txtnameFormat.setFont(Font.font(16));
            
            HBox xboc = new HBox(txtname,nameoffile);
            xboc.setSpacing(12);
            xboc.setAlignment(Pos.CENTER);
            // create a Label 
            Label label = new Label("no Destination selected"); 
             label.setVisible(false);
             label.setTextFill(Paint.valueOf("red"));
             label.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
            // create a Button 
            Button button = new Button("Choose Destination"); 
             button.setStyle("-fx-background-color:red;-fx-background-radius:10");
            button.setTextFill(Paint.valueOf("white"));
             // create an Event Handler 
            EventHandler<ActionEvent> eventtochoosedir =  
            new EventHandler<ActionEvent>() { 
  
                public void handle(ActionEvent e) 
                { 
  
                    // get the file selected 
                   file = dir_chooser.showDialog(selectdirectorystag); 
                    if (file != null) { 
                        label.setText(file.getAbsolutePath() + "  selected"); 
                        label.setVisible(true);
                     }
                    else{
                         label.setText( "  No Destination selected");
                     label.setVisible(true);
                    }
                   
                } 
            }; 
  
            
            
            
            
            
            
             EventHandler<ActionEvent> event =  
            new EventHandler<ActionEvent>() { 
  
                public void handle(ActionEvent e) 
                { 
   
                        StringBuffer dirAndFileName = new StringBuffer(file.getAbsolutePath()) ; 
                        StringBuffer append = dirAndFileName.append("\\"+nameoffile.getText()+".xlsx");
                       File fileexist = new File(append.toString());
                       if(!fileexist.exists()){
                        fileSavingMethod(append.toString());
                       }
                       else{
                       label.setText("File already exist, pls use a unique name "); 
                        label.setVisible(true);
                       }
                  
                } 
            }; 
  
            
            button.setOnAction(eventtochoosedir); 
  
            // create a VBox 
            
            Button setToClick = new Button("");
            setToClick.setStyle("-fx-background-color:blue;-fx-background-radius:10");
    DirectoryChooser_1 haveAccessToNonStaticMember  =new DirectoryChooser_1();
    haveAccessToNonStaticMember.imageView1setToClick.setFitHeight(30);
       haveAccessToNonStaticMember. imageView1setToClick.setFitWidth(30);
        setToClick.setGraphic( haveAccessToNonStaticMember. imageView1setToClick);
            setToClick.setTextFill(Paint.valueOf("white"));
             setToClick.setOnAction(event); 
            VBox vbox = new VBox(30, label,xboc,txtnameFormat,button,setToClick); 
  
            // set Alignment 
            vbox.setAlignment(Pos.CENTER); 
               vbox.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));

            // create a scene 
            Scene scene = new Scene(vbox, 500, 300); 
  
            // set the scene 
            selectdirectorystag.setScene(scene); 
  
            selectdirectorystag.show(); 
        } 
  
        catch (Exception e) { 
  
            System.out.println(e.getMessage()); 
        } 
    } 
  
    // Main Method 
    public static void directoryChooser_1StageMaker(Stage selectdirectorystagForInitialization, Stage myparent){
        selectdirectorystag=selectdirectorystagForInitialization;

    selectdirectorystag.initModality(Modality.WINDOW_MODAL);
    selectdirectorystag.initOwner(myparent);
    
    }
    
    
    public static void fileSavingMethod(String dirAndFilename){
       
      // int size = items.size();
      
//      Service sfg = new Service(){
       
       
//          @Override
//          protected Task createTask() {
           
           try {
              ExcelWriter.man(dirAndFilename);
            Alert sd = new Alert(Alert.AlertType.INFORMATION);
            sd.setContentText("Successfully Created");
            sd.setTitle("Create an Excell file!!!!  in  '.xlsx' format");
            sd.initModality(Modality.NONE);
            sd.initOwner(selectdirectorystag);
            sd.show();
        } catch (IOException ex) {
            Logger.getLogger(DirectoryChooser_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(DirectoryChooser_1.class.getName()).log(Level.SEVERE, null, ex);
        }
             // return null;

       
      // }
       
//      };
       
       
//       sfg.start();
       
       
    }
    }
 