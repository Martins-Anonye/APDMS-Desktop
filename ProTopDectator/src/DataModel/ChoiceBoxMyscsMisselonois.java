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
public class ChoiceBoxMyscsMisselonois extends Task<ObservableList> {
    
//     project_lec.add("Project_Lec");
//    project_lec.add("Group");
//    
//    project_lec.add("Category");
//    project_lec.add("Department");
//    
    
    
    
    Connection    con;
    Statement st;
     ResultSet eQuery;
     ObservableList<String> project_lec = FXCollections.observableArrayList();
//     ObservableList<String> group = FXCollections.observableArrayList();
     ObservableList<String> category = FXCollections.observableArrayList();
     ObservableList<String> department = FXCollections.observableArrayList();
////     ObservableList<String> smpt5 = FXCollections.observableArrayList();
////     ObservableList<String> smpt6 = FXCollections.observableArrayList();
////     ObservableList<String> smpt7 = FXCollections.observableArrayList();
////     ObservableList<String> smpt8 = FXCollections.observableArrayList();
////     ObservableList<String> smpt9= FXCollections.observableArrayList();
//     ObservableList<TableColumnDataPop> smptcontaner = FXCollections.observableArrayList();
          ObservableList<ObservableList> allArrymak = FXCollections.observableArrayList();

     
 public ObservableList<ObservableList>   listDataloader(){
     
//      public ObservableList<TableColumnDataPop>   listDataloader(){

     
   
                      
         
                       
                         
                          
                            try {
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                try {
                                  
String s = "SELECT projectdec.S_N,projectdec.First_Name,projectdec.Sur_Name,projectdec.Reg_No,projectdec.Project_Lec,projectdec.Department,projectdec.Project_Topic,proj_category.Category FROM projectdec join proj_category \n" +
"on projectdec.Cat_id = proj_category.Cat_id  ";
                                            
//                                            String.format("select * from projectdec");
//

MyscsConneectionString sd = new MyscsConneectionString();
eQuery = sd.DBDriverStatementLoader().executeQuery(s);
                                } catch (SQLException ex) {
                                    System.out.println("query not valid............., Unsuccesfull");
                                }
                                
//   }




while(eQuery.next() ){
//    smpt.add(eQuery.getString(1));
////    smpt1.add(eQuery.getString(2));
////    smpt2.add(eQuery.getString(3));
//    
//    
//        smpt3.add(eQuery.getString(4));
//        
        
    
    project_lec.add(eQuery.getString("Project_Lec"));
//    group.add(eQuery.getString("Group"));
    
    category.add(eQuery.getString("Category"));
    department.add(eQuery.getString("Department"));
    
   
    
    
}//end of while loop
 
 allArrymak.addAll(project_lec,category,department);

//smptcontaner.addAll(smpt,smpt1,smpt2,smpt3,smpt4,smpt5,smpt6,smpt7,smpt8,smpt9);


                            }  
 catch (SQLException ex) {
                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                
//   }
               
        return allArrymak;
                      
       }
      
          
 
 


               

    @Override
    protected ObservableList<ObservableList> call() throws Exception {
//          protected ObservableList<TableColumnDataPop> call() throws Exception {

    
        return listDataloader();
    }

}
                         
        
         

    
    
 

