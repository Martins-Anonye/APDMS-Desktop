/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadProjectSoftCopyButonTableSearchTableView;

import ReadProjectSoftCopyButonTableDaataView.*;
import PDFandDocandDocxOPenner.OpenAProjectFile;
import SetupReadMaterialSoftCopyGuiMaker.DirectoryChoserForSoftCopyTextField;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import protopdectator.AllStaticVariable;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.TableColumnDataPop;

/**
 *
 * @author Martins
 */
public class TableViewMainSearchButtonImageColumn implements AllStaticVariable{
    public void addButtonToTable() {
TableColumn<AutoCompTableColumnDataPop, Void> colBtn = new TableColumn("Read SoftCopy_WriteUp");
Callback<TableColumn<AutoCompTableColumnDataPop, Void>, TableCell<AutoCompTableColumnDataPop, Void>> cellFactory = new Callback<TableColumn<AutoCompTableColumnDataPop, Void>, TableCell<AutoCompTableColumnDataPop, Void>>() {
@Override
public TableCell<AutoCompTableColumnDataPop, Void> call(final TableColumn<AutoCompTableColumnDataPop, Void> param) {
final TableCell<AutoCompTableColumnDataPop, Void> cell = new TableCell<AutoCompTableColumnDataPop, Void>() {
private final Button btn = new Button("Read");

{
btn.setOnAction((ActionEvent event) -> {
AutoCompTableColumnDataPop data = getTableView().getItems().get(getIndex());
//TableColumnDataPop data = getTableView().getItems().get(getIndex());
    String text = DirectoryChoserForSoftCopyTextField.textFielddirchoser.getText();
    StringBuffer stdgforDoc = new StringBuffer(text);
    stdgforDoc.append("//"+data.getReg_no()+".doc");
    File docFile = new File(stdgforDoc.toString());
    
    StringBuffer stdgforDocX = new StringBuffer(text);
    stdgforDocX.append("//"+data.getReg_no()+".docx");
    File docxFile = new File(stdgforDocX.toString());
    
    StringBuffer stdgforPdf = new StringBuffer(text);
    stdgforPdf.append("//"+data.getReg_no()+".pdf");
    File pdfFile = new File(stdgforPdf.toString());
    
    
    
    
      StringBuffer stdgforPpt = new StringBuffer(text);
    stdgforPpt.append("//"+data.getReg_no()+".ppt");
    File pptFile = new File(stdgforPpt.toString());
        
        StringBuffer stdgforPptx = new StringBuffer(text);
    stdgforPptx.append("//"+data.getReg_no()+".pptx");
    File pptxFile = new File(stdgforPptx.toString());
    
    if(docFile.exists()){
    new OpenAProjectFile(docFile.toString());
    System.out.println("selectedData: " + data.getReg_no());
     }
    else if(docxFile.exists()){
     new OpenAProjectFile(docxFile.toString());
    System.out.println("selectedData: " + data.getReg_no());
   

    }
    else if(pdfFile.exists()){
     new OpenAProjectFile(pdfFile.toString());
    System.out.println("selectedData: " + data.getReg_no());
   

    }
     else if(pptFile.exists()){
     new OpenAProjectFile(pptFile.toString());
    System.out.println("selectedData: " + data.getReg_no());
   

    }
     else if(pptxFile.exists()){
     new OpenAProjectFile(pptxFile.toString());
    System.out.println("selectedData: " + data.getReg_no());
   

    }
        else{
        Alert nofilfoundAlert = new Alert(Alert.AlertType.ERROR);
        nofilfoundAlert.setContentText("No File Found");
        nofilfoundAlert.setTitle("File Error");
        nofilfoundAlert.show();
    
    }
});
}
@Override
public void updateItem(Void item, boolean empty) {
super.updateItem(item, empty);
if (empty) {
setGraphic(null);
} else {
    ImageView readicon = new ImageView(this.getClass().getResource("/images/icons/readBook.png").toExternalForm());
readicon.setFitHeight(30);
readicon.setFitWidth(25);

btn.setStyle("-fx-background-color:black; -fx-background-radius:20");
    btn.setGraphic(readicon);
setGraphic(btn);
}
}
};
return cell;
}
};
colBtn.setCellFactory(cellFactory);
AllStaticVariable.tableViewsearch.getColumns().add(colBtn);
}
    
}
