/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javax.swing.JOptionPane;
import protopdectator.TableColumnDataPop;
/**
 *
 * @author MartinsEagleEyes
 */
public class CategoriesQuery extends Task<ObservableList> {
    
 
    
    Connection    con;
    Statement st;
     ResultSet eQuery;
  ObservableList<String> category = FXCollections.observableArrayList();
     ObservableList<String> department = FXCollections.observableArrayList();

 public ObservableList<String>   listDataloader(){
     
//      public ObservableList<TableColumnDataPop>   listDataloader(){

     
   
                      
         
                       
                         
                          
                            try {
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                try {
                                  
String s = "SELECT * from proj_category";
                                            
//                                            String.format("select * from projectdec");
//

MyscsConneectionString sd = new MyscsConneectionString();
eQuery = sd.DBDriverStatementLoader().executeQuery(s);
                                } catch (SQLException ex) {
                                    System.out.println("query not valid............., Unsuccesfull");
                                }
                                
//   }




while(eQuery.next() ){

    category.add(eQuery.getString("Category"));
   
    
}//end of while loop
 
 
//smptcontaner.addAll(smpt,smpt1,smpt2,smpt3,smpt4,smpt5,smpt6,smpt7,smpt8,smpt9);


                            }  
 catch (SQLException ex) {
                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                
//   }
               
        return category;
                      
       }
      
          
 
 


               

    @Override
    protected ObservableList<String> call() throws Exception {
//          protected ObservableList<TableColumnDataPop> call() throws Exception {

    
        return listDataloader();
    }

}
                         
        
         

    
    
 

