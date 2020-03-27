/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataViewExcellFile;

import DataModel.MyscsConneectionString;
import ImportOperationForDatabase.ImportSqlStatement;
import java.awt.Desktop;
import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author Martins
 */
public final class ExcellFileChooser extends ImportExcellChooserGuiProjectSoftCopyMaker{
   
    final  static FileChooser fileChooser = new FileChooser();
    
    public    String  chooseFile(TextArea te) {
       
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("excell",".xlsx"));
        
               
File file = fileChooser.showOpenDialog(myOwnStage);
String fileres = file.getAbsolutePath().toString();


if (file != null) {
    if(fileres.contains(".xlsx")){
    
    notifier.setText("Excell file-name-selected    "+fileres);
    te.setText("Excell file-name-selected    "+fileres);
        


        return fileres;
        
    }
    
    else{
    
    Alert notExcellFile = new Alert(Alert.AlertType.ERROR);
    
    notExcellFile.setContentText("pls select an Excell File and try again");
    notExcellFile.setTitle("not a valid file");
    notExcellFile.show();
    return null;
    }

}
else{
 Alert notExcellFile = new Alert(Alert.AlertType.ERROR);
    
    notExcellFile.setContentText("pls select an Excell File");
    notExcellFile.setTitle("not a valid file");
    notExcellFile.show();
return null;

}
       
        
    }


}      