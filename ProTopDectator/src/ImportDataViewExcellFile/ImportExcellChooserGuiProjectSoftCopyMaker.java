package ImportDataViewExcellFile;

import DataModel.MyscsConneectionString;
import ImportOperationForDatabase.ImportExcellFileMakerForQuery;
import ImportOperationForDatabase.ImportSqlStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.lang.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import protopdectator.AllStaticVariable;
import static protopdectator.AllStaticVariable.notifier;

public  class ImportExcellChooserGuiProjectSoftCopyMaker extends BorderPane implements AllStaticVariable{
static Stage myOwnStage;
    protected final VBox vBox;
    protected final Button button;
    protected final Button button0;
    protected final VBox vBox0;
    protected final Text text;
    protected final HBox hBox;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
   static   TextArea  importTextAreaDeteted = new TextArea();
   static String chooseFileselected ;

    public ImportExcellChooserGuiProjectSoftCopyMaker() {

        vBox = new VBox();
        button = new Button();
        button0 = new Button();
        vBox0 = new VBox();
        text = new Text();
        hBox = new HBox();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
       

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
importTextAreaDeteted.setPrefHeight(100);
        button.setMnemonicParsing(false);
        button.setText("Select File-Source Location ");
        button.setFont(new Font(15.0));
         button.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
                // import excell file Selector logic goes here
                 chooseFileselected = new ExcellFileChooser().chooseFile(importTextAreaDeteted);
            
            }
        }
        );

        button0.setMnemonicParsing(false);
        button0.setText("Import");
        
        button0.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
                
                
                if( chooseFileselected!=null){
                
                    FileInputStream file = null;
                    
                        Statement DBDriverStatementLoader = new MyscsConneectionString().DBDriverStatementLoader();
                   
                                       try {
                                           
//                                           DBDriverStatementLoader.executeUpdate("commit");
                                           int executeUpdate = DBDriverStatementLoader.executeUpdate(ImportSqlStatement.deletAllValueFromTheTableOperation()); // for drop Statement
//                                        DBDriverStatementLoader.executeUpdate("commit");
                                            
                                           notifier.setText("Distroying All Data in Data_View Table");
                                         System.out.println("Distroying All Data in Data_View Table");
//                                           if(executeUpdate!=0){
                                           notifier.setText(" Destroy Opearation Complited");
                                           System.out.println("Destroy Opearation Complited");
//                                           int executeUpdatecreated = DBDriverStatementLoader.executeUpdate(ImportSqlStatement.createTableStatemt()); // for drop Statement
//                                        DBDriverStatementLoader.executeUpdate("commit");
//                                          
//                                            if(executeUpdatecreated!=0){
                                           notifier.setText(" creat Opearation Complited");
                                           System.out.println("creat Opearation Complited");
                                           
                                           

                                                           try {
                                                        file = new FileInputStream(chooseFileselected);
                                                    } catch (FileNotFoundException ex) {
                                                        Logger.getLogger(ImportExcellChooserGuiProjectSoftCopyMaker.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                        new ImportExcellFileMakerForQuery(file);
                                                    try {
                                                        file.close();
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(ImportExcellChooserGuiProjectSoftCopyMaker.class.getName()).log(Level.SEVERE, null, ex);
                                                    }

                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                                         
//                                            }
//                                           }
                                       
                                       } catch (SQLException ex) {
                                            Logger.getLogger(ImportExcellChooserGuiProjectSoftCopyMaker.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                        
                                        
                                            

                 
                  

                       
                               
                  


                }
                
        else{

             Alert notExcellFile = new Alert(Alert.AlertType.ERROR);

            notExcellFile.setContentText("pls select an Excell File (.xlsx)");
            notExcellFile.setTitle("not a valid file");
            notExcellFile.show();


        }

            }
        }
        );
        VBox.setMargin(button0, new Insets(50.0, 0.0, 0.0, 0.0));
        vBox.setOpaqueInsets(new Insets(0.0));
        vBox.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        setCenter(vBox);

        text.setFill(javafx.scene.paint.Color.valueOf("#254ac3"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Import Excell Data ");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(594.36279296875);
        text.setFont(new Font(39.0));

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("EXCELL FILE FORMAT:");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(332.13671875);
        text0.setFont(new Font("Arial Black", 25.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#a42525"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("(.xlsx)");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(176.16796875);
        text1.setFont(new Font(18.0));

        text2.setLayoutX(10.0);
        text2.setLayoutY(127.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Pls make sure you export the current data in the dataview table (using the Export Manager); because , these opperation will auto replace / override the data in the dataview_table (Database).");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        text2.setWrappingWidth(596.4375);
        text2.setFont(new Font("System Bold Italic", 16.0));
        VBox.setMargin(text2, new Insets(10.0, 0.0, 0.0, 0.0));

        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Selected excell file location");
        VBox.setMargin(text3, new Insets(20.0, 0.0, 0.0, 0.0));

        importTextAreaDeteted.setPrefHeight(31.0);
        importTextAreaDeteted.setPrefWidth(537.0);
        importTextAreaDeteted.setPromptText("selected excell file detector");
        importTextAreaDeteted.setFont(new Font(15.0));
        VBox.setMargin(importTextAreaDeteted, new Insets(10.0, 0.0, 0.0, 0.0));
        setTop(vBox0);

        vBox.getChildren().add(button);
        vBox.getChildren().add(button0);
        vBox0.getChildren().add(text);
        hBox.getChildren().add(text0);
        hBox.getChildren().add(text1);
        vBox0.getChildren().add(hBox);
        vBox0.getChildren().add(text2);
        vBox0.getChildren().add(text3);
        vBox0.getChildren().add(importTextAreaDeteted);
        
       Scene  scene = new Scene(this);
       myOwnStage.setScene(scene);
        myOwnStage.show();
    }
    public static void importExcellChooserGuiProjectSoftCopyStageMaker(Stage mystage, Stage parent){
    
    
    myOwnStage= mystage;
    myOwnStage.initModality(Modality.APPLICATION_MODAL);
    
    myOwnStage.initOwner(parent);
    myOwnStage.setResizable(false);
    
    }
}
