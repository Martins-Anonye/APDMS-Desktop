/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveToExcellControlPanelGuiLayer;

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

public class SaveToExcellControlPanelGuiLayerMaker {

    public  VBox SaveToExcellControlPanelLayerMaker() {
          VBox hbxDataViewsaveToExcell = new VBox();
        
        
                         hbxDataViewsaveToExcell.setSpacing(5);
                         Text tsaveDataToexcell  = new Text("Export Data View Table");
                         tsaveDataToexcell.setFill(Paint.valueOf("blue"));
                         tsaveDataToexcell.setFont(Font.font(16));
                         
                         Button savetoExcellDataVIEW = new Button("export");
                         
                          ImageView imageViewsavetoExcellDataVIEW = new ImageView(this.getClass().getResource("/images/icons/Publish.png").toExternalForm());
        imageViewsavetoExcellDataVIEW.setFitHeight(30);
        imageViewsavetoExcellDataVIEW.setFitWidth(30);
                         savetoExcellDataVIEW.setGraphic(imageViewsavetoExcellDataVIEW);
                         savetoExcellDataVIEW.setStyle("-fx-background-color:gray; -fx-background-radius:10;");
                         
                         savetoExcellDataVIEW.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                
                                DirectoryChooser_1ForDataViewSaver.DirectoryChooser_1StageViewer();
                               }
                        });
                         
                         
                         hbxDataViewsaveToExcell.getChildren().addAll(tsaveDataToexcell,savetoExcellDataVIEW);
                         
                         
        
        return hbxDataViewsaveToExcell;
        
    }
    
}
