/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportOperationForDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import javafx.scene.control.Alert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Martins
 */
public class ImportExcellFileMakerForQuery {
    
public static  int executeUpdate;//check no of row affect in the importsqlstatement class
    String fnam,lastname, regno,projectsupervisor,department,topic,category,score;
    int sn;
    StringBuffer projectTopic = new StringBuffer();
     int checkmycolumn=0;
    Integer checkmyrowForRowHeader =0;//hold the headerrow so that we can jump it;
    public ImportExcellFileMakerForQuery(FileInputStream file) {
        try
        {
           // FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
         //   sheet.get
            while (rowIterator.hasNext()){
                
                
                  
                                        Row row = rowIterator.next();
                                         if(!checkmyrowForRowHeader.equals(0)){
                                        //For each row, iterate through all the columns
                                        Iterator<Cell> cellIterator = row.cellIterator();
                                        //
                                       
                                       
                                       // for(Cell  cell :row){
                                          while (cellIterator.hasNext()){
                                            Cell cell = cellIterator.next();
                                            //Check the cell type and format accordingly
                                            CellType cellType = cell.getCellType();
                                          
                                          
                                          int columnIndex = cell.getColumnIndex();

                                                
                                           switch(columnIndex){

                                           case 0: //for sn
                                               if(cellType == CellType.NUMERIC){
                                               sn= Math.round((float)cell.getNumericCellValue());
                                               }
                                               if(cellType == CellType.STRING){
                                               sn= Math.round(new Integer(cell.getStringCellValue()));
                                               }
                                                 if(cellType == CellType._NONE){
                                               sn= Math.round((float)cell.getNumericCellValue());
                                               }
                                                         
                                           break;
                                           case 1: //for fname

                                           fnam = cell.getStringCellValue();
                                            break;



                                           case 2://for surname
                                                 lastname = cell.getStringCellValue();

                                           break;

                                           case 3://reg no
                                           regno = cell.getStringCellValue();

                                           break;
                                           case 4://project supervisor
                                            projectsupervisor = cell.getStringCellValue();

                                           break;

                                           case 5://department
                                           department = cell.getStringCellValue();

                                            break;

                                            case 6://project topic
                                          Cell cella =  row.getCell(6);
                                          projectTopic.append(cella.getStringCellValue());
                                                             topic = cella.getStringCellValue();
                                                             //cell.getRichStringCellValue()
                                                             if(cellType == CellType.NUMERIC){
                                                               topic= ""+cell.getNumericCellValue();
                                                               }
                                                               if(cellType == CellType.STRING){
                                                               topic= cell.getStringCellValue();
                                                               }
                                                                 if(cellType == CellType._NONE){
                                                               topic= cell.getStringCellValue();
                                                               }
                                                                 if(cellType == CellType.ERROR){
                                                               topic= cell.getStringCellValue();
                                                               } 
                                                                  if(cellType == CellType.BLANK){
                                                               topic= cell.getStringCellValue();
                                                               } 
                                                                  if(cellType == CellType.FORMULA){
                                                               topic= cell.getStringCellValue();
                                                               } 
                                                                      

                                            break;
                                            
                                            
                                            case 7://category
                                               
                                           category = cell.getStringCellValue();
                                                 // cell1.getStringCellValue();
                                            break;

                                            case 8: //score
                                          
                                               
                                        /// score = ""+cell.getNumericCellValue();
                                                
                                                              if(cellType == CellType.NUMERIC){
                                                               score= ""+cell.getNumericCellValue();
                                                               }
                                                               if(cellType == CellType.STRING){
                                                               score=cell.getStringCellValue();
                                                               }
                                                                 if(cellType == CellType._NONE){
                                                               score= cell.getStringCellValue();
                                                               } 
                                                                 if(cellType == CellType.ERROR){
                                                               score= cell.getStringCellValue();
                                                               } 
                                                                  if(cellType == CellType.BLANK){
                                                               score= cell.getStringCellValue();
                                                               } 
                                                                   if(cellType == CellType.FORMULA){
                                                               score= cell.getStringCellValue();
                                                               } 
                                                                  if(cellType == CellType.BOOLEAN){
                                                               score= cell.getStringCellValue();
                                                               } 
                                              System.out.println("Check the value for "+score);
                                            break;

                                            default:
                                             break;
                                           }

                                        
                                           
                                           if(checkmycolumn==8){//when the switch has complited per each row
                                       String portop =   projectTopic.toString();
                                            System.out.println(sn+" "+fnam +" "+lastname+" "+regno+projectsupervisor+" "+department+" "+portop+" "+category+" "+" "+score);
   
                                        ///we insert all the value from excell file in to the database
                                        ImportSqlStatement.insertInToTableUsingValueFromExcellFile(sn, fnam, lastname, regno, projectsupervisor, department, portop, category, score);
          fnam="";lastname="";regno="";projectsupervisor="";department="";topic="";category="";score="";
 projectTopic.delete(0, projectTopic.length());
                                        checkmycolumn=0;
                                          } 
                                         checkmycolumn++;
                                      
                              
                 
                                        
                                       
                                        }
                                       
                                        
                                          }
                   

checkmyrowForRowHeader++;
                                        
            }
             if(executeUpdate!=0){

                      Alert alet = new Alert(Alert.AlertType.CONFIRMATION);
                      alet.setContentText("Successfully Inserted");
                      alet.setTitle("succes info");
                      alet.show();
                   }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
