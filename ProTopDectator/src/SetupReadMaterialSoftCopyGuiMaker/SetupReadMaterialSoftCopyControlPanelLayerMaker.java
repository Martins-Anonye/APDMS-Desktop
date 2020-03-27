/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetupReadMaterialSoftCopyGuiMaker;

import ImportToExcellControlPanel.*;
import SaveToExcellControlPanelGuiLayer.*;
import SaveDataViewProjectToExcellFile.DirectoryChooser_1ForDataViewSaver;
//import static SetupReadMaterialSoftCopyGuiMaker.DirectoryChoserForSoftCopyTextField.dirshowTextfd;
import static SetupReadMaterialSoftCopyGuiMaker.DirectoryChoserForSoftCopyTextField.textFielddirchoser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Martins
 */

public class SetupReadMaterialSoftCopyControlPanelLayerMaker implements DirectoryChoserForSoftCopyTextField{

    public  VBox SetupReadMaterialSoftCopyControlPanelLayerMaker() {
          VBox vbxDataViewSetupReadMaterialDir = new VBox();
        
        
                         vbxDataViewSetupReadMaterialDir.setSpacing(5);
                         Text tSetupReadMaterialDir  = new Text("Setup 'Directory Location' To\n Read Project Soft Copy/Writeup ");
                         tSetupReadMaterialDir.setFill(Paint.valueOf("blue"));
                         tSetupReadMaterialDir.setFont(Font.font(16));
                         
                         Button setupReadMaterialDirBtn = new Button("Setup");
                       //  dirshowTextfd.textProperty().bind(textFielddirchoser.textProperty());
                          ImageView imageViewIsetupReadMaterialDir = new ImageView(this.getClass().getResource("/images/icons/SetupReadMaterialDirectory.png").toExternalForm());
        imageViewIsetupReadMaterialDir.setFitHeight(30);
        imageViewIsetupReadMaterialDir.setFitWidth(30);
                         setupReadMaterialDirBtn.setGraphic(imageViewIsetupReadMaterialDir);
                         setupReadMaterialDirBtn.setStyle("-fx-background-color:gray; -fx-background-radius:10;");
                         
                         setupReadMaterialDirBtn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                
                              new DirectoryChooserGuiProjectSoftCopyMaker();
                              
                               }
                        });
                         
                        
                         
                         ScrollPane scrop = new ScrollPane();
                         
                         textara.setEditable(false);
                                 textara.setWrapText(true);
                                 textara.setPrefWidth(500);
                                 textara.setPrefHeight(200);
                                 scrop.setContent(textara);
                        
                         vbxDataViewSetupReadMaterialDir.getChildren().addAll(tSetupReadMaterialDir,scrop,setupReadMaterialDirBtn);
                         
                         
        
        return vbxDataViewSetupReadMaterialDir;
        
    }
    
}
