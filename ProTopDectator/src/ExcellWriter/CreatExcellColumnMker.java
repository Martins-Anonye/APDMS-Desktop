/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcellWriter;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.TableColumnDataPop;

/**
 *
 * @author Martins
 */
public class CreatExcellColumnMker {

    public CreatExcellColumnMker(Row headerRow, CellStyle headerCellStyle,int i,ObservableList<TableColumn<AutoCompTableColumnDataPop, ?>> columns) {
        
         Cell cell = headerRow.createCell(i);
            
           if(i==0){
           
                   cell.setCellValue(columns.get(0).getText());
            cell.setCellStyle(headerCellStyle);
               }
            if(i==1){
           
                   cell.setCellValue(columns.get(2).getText());
            cell.setCellStyle(headerCellStyle);
          
           }
           if(i==2){
          
                   
           cell.setCellValue(columns.get(3).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
           if(i==3){
          
                   
           cell.setCellValue(columns.get(4).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
         if(i==4){
          
                   
           cell.setCellValue(columns.get(5).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          if(i==5){
          
                   
           cell.setCellValue(columns.get(6).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          
          
          if(i==6){
          
                   
           cell.setCellValue(columns.get(7).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          if(i==7){
          
                   
           cell.setCellValue(columns.get(8).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           if(i==8){
          
                   
           cell.setCellValue(columns.get(9).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
    }
    
    





 public CreatExcellColumnMker( CellStyle headerCellStyle,Row headerRow,int i,ObservableList<TableColumn<TableColumnDataPop, ?>> columns) {
        
         Cell cell = headerRow.createCell(i);
            
           if(i==0){
           
                   cell.setCellValue(columns.get(0).getText());
            cell.setCellStyle(headerCellStyle);
               }
            if(i==1){
           
                   cell.setCellValue(columns.get(2).getText());
            cell.setCellStyle(headerCellStyle);
          
           }
           if(i==2){
          
                   
           cell.setCellValue(columns.get(3).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
           if(i==3){
          
                   
           cell.setCellValue(columns.get(4).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
         if(i==4){
          
                   
           cell.setCellValue(columns.get(5).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          if(i==5){
          
                   
           cell.setCellValue(columns.get(6).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          
          
          if(i==6){
          
                   
           cell.setCellValue(columns.get(7).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
          if(i==7){
          
                   
           cell.setCellValue(columns.get(8).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           if(i==8){
          
                   
           cell.setCellValue(columns.get(9).getText());
            cell.setCellStyle(headerCellStyle);
           
           }
           
    }
}
    
