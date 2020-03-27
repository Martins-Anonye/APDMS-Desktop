/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebviewDisplay;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static protopdectator.AllStaticVariable.pri;

/**
 *
 * @author Martins
 */
public class webContentsDisplay {
   static WebView webvw = new WebView();
    
  static   Stage sdcate;
   public webContentsDisplay(){
        
    }
    
    
     public static void myarticleTageMaker(Stage cat,Stage pri){
        sdcate=cat;

    sdcate.initModality(Modality.WINDOW_MODAL);
    sdcate.initOwner(pri);
    StackPane st = new StackPane(webvw);
        sdcate.setScene(new Scene(st));

    }
    public  void showMyarticlestageMaker(String url){
       WebEngine engine = webvw.getEngine();
       engine.load(url);
    sdcate.setResizable(false);
    sdcate.show();
    }
}
