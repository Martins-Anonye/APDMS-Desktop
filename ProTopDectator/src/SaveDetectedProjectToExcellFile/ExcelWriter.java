/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveDetectedProjectToExcellFile;

import ExcellWriter.CreatExcellColumnMker;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import protopdectator.AllStaticVariable;
import static protopdectator.AllStaticVariable.tableViewsearch;
import protopdectator.AutoCompTableColumnDataPop;

/**
 *
 * @author Martins
 */
public class ExcelWriter implements AllStaticVariable{

   // Initializing employees data to insert into the excel file
    

    public static void man(String filename) throws IOException, InvalidFormatException {
        //  initialize tableview and columns
        
        
        ObservableList<TableColumn<AutoCompTableColumnDataPop, ?>> columns = AllStaticVariable.tableViewsearch.getColumns();
    
//       TableColumn<AutoCompTableColumnDataPop, ?> getS_n = columns.get(0);
//       TableColumn<AutoCompTableColumnDataPop, ?> getFirst_Name = columns.get(1);
//       TableColumn<AutoCompTableColumnDataPop, ?> getLast_Name = columns.get(2);
//         TableColumn<AutoCompTableColumnDataPop, ?> sur_name = columns.get(3);
//         TableColumn<AutoCompTableColumnDataPop, ?> Reg_no = columns.get(3);
//           TableColumn<AutoCompTableColumnDataPop, ?> Project_Supervisor = columns.get(4);
//            TableColumn<AutoCompTableColumnDataPop, ?> department = columns.get(5);
//             TableColumn<AutoCompTableColumnDataPop, ?> Project_Topic = columns.get(6);
       ObservableList<AutoCompTableColumnDataPop> items = tableViewsearch.getItems();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Project Topic Data");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row that will act as the header Cell and add value to them,  as they will act as header row  
        Row headerRow = sheet.createRow(0);
          
        
       

        // Create cells 
        
        int asn =3;
        for(int i = 0; i < columns.size()-1;  i++ ) {
           
          new CreatExcellColumnMker(headerRow,headerCellStyle,i,columns);
           }
           
        

        // Create Cell Style for formatting Date
//        CellStyle dateCellStyle = workbook.createCellStyle();
//        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(AutoCompTableColumnDataPop projectinfor: items) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(projectinfor.getS_N());
/// jump button Column
           row.createCell(1) .setCellValue(projectinfor.getF_name());

            Cell surname = row.createCell(2);
            surname.setCellValue(projectinfor.getS_name());
           // surname.setCellStyle(dateCellStyle);

            row.createCell(3)
                    .setCellValue(projectinfor.getReg_no());
              row.createCell(4)
                    .setCellValue(projectinfor.getPro_lec());
                row.createCell(5)
                    .setCellValue( projectinfor.getDepartment());
                row.createCell(6)
                    .setCellValue( projectinfor.getPro_topic());
                   row.createCell(7)
                    .setCellValue(projectinfor.getCategorie());
                   
                    row.createCell(8)
                    .setCellValue(projectinfor.getProject_score());
                      
                  
                 
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
    
    
}