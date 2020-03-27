/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDFandDocandDocxOPenner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Martins
 */
public class OpenAProjectFile{
 //   Stage

    public OpenAProjectFile(String st) {
        
        File pdfFile = new File(st);
        if(pdfFile.exists()){
           // switch()
                 if(Desktop.isDesktopSupported()){

                     try {
                        // pdfFile.
                        
                         Desktop.getDesktop().open(pdfFile);
                     } catch (IOException ex) {
                         Logger.getLogger(OpenAProjectFile.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 else{
                 Alert das = new Alert(Alert.AlertType.ERROR);
                 das.setContentText("MSword or Adobe Reader not Installed");
                 das.setTitle("Missing Compnnent");
                 das.show();

                 }
                 
        
        }
        
        else{
        Alert das = new Alert(Alert.AlertType.ERROR);
                 das.setContentText("Fil not Found");
                 das.setTitle("Fil not Found");
                 das.show();

        
        }
    }
    
}
