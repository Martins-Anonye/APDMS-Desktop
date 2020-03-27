/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportToExcellControlPanel;

import ImportDataViewExcellFile.ImportExcellChooserGuiProjectSoftCopyMaker;
import SaveToExcellControlPanelGuiLayer.*;
import SaveDataViewProjectToExcellFile.DirectoryChooser_1ForDataViewSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Martins
 */

public class ImportToExcellDBControlPanelGuiLayerMaker {

    public  VBox ImportToExcellControlPanelLayerMaker() {
          VBox hbxDataViewImportToExcellDb = new VBox();
        
        
                         hbxDataViewImportToExcellDb.setSpacing(5);
                         Text timportDataToexcell  = new Text("Import Data View Table");
                         timportDataToexcell.setFill(Paint.valueOf("blue"));
                         timportDataToexcell.setFont(Font.font(16));
                         
                         Button ImportToExcellDataVIEW = new Button("import");
                         
                          ImageView imageViewImportToExcellDataVIEW = new ImageView(this.getClass().getResource("/images/icons/importimg.jpg").toExternalForm());
        imageViewImportToExcellDataVIEW.setFitHeight(30);
        imageViewImportToExcellDataVIEW.setFitWidth(30);
                         ImportToExcellDataVIEW.setGraphic(imageViewImportToExcellDataVIEW);
                         ImportToExcellDataVIEW.setStyle("-fx-background-color:gray; -fx-background-radius:10;");
                         
                         ImportToExcellDataVIEW.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                new ImportExcellChooserGuiProjectSoftCopyMaker();
                               
                               }
                        });
                         
                         
                         hbxDataViewImportToExcellDb.getChildren().addAll(timportDataToexcell,ImportToExcellDataVIEW);
                         
                         
        
        return hbxDataViewImportToExcellDb;
        
    }
    
}
