/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
import protopdectator.AllStaticVariable;
import protopdectator.TableColumnDataPop;
/**
 *
 * @author MartinsEagleEyes
 */
public class MyscsConneectionString extends Task<ObservableList<TableColumnDataPop>> implements  AllStaticVariable{
    

    
    Connection    con;
    Statement st;
     ResultSet eQuery;
     ObservableList<String> project_lec = FXCollections.observableArrayList();
     ObservableList<String> group = FXCollections.observableArrayList();
     ObservableList<String> category = FXCollections.observableArrayList();
     ObservableList<String> department = FXCollections.observableArrayList();
//     ObservableList<String> smpt5 = FXCollections.observableArrayList();
//     ObservableList<String> smpt6 = FXCollections.observableArrayList();
//     ObservableList<String> smpt7 = FXCollections.observableArrayList();
//     ObservableList<String> smpt8 = FXCollections.observableArrayList();
//     ObservableList<String> smpt9= FXCollections.observableArrayList();
     ObservableList<TableColumnDataPop> smptcontaner = FXCollections.observableArrayList();
          ObservableList<ObservableList> allArrymak = FXCollections.observableArrayList();

        URL fyt;
     public  Statement DBDriverStatementLoader(){
//     "com.mysql.jdbc.Driver"
         
         
         String forN = "org.sqlite.JDBC";
                           try {
                                                 
                               try {
                                   Class.forName(forN).newInstance();
                               } catch (InstantiationException ex) {
                                   Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                               } catch (IllegalAccessException ex) {
                                   Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                               }
                                               
                                             } catch (ClassNotFoundException ex) {
                                                 Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                                             }




                                         try {
//                                             PorjectTopicDicOko.db
            
            con = DriverManager.getConnection("jdbc:sqlite:PorjectTopicDicOko.db");
                                         } 
                                         catch (SQLException ex) {
                                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                                         }
                                         
        try {
            st=  con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
        }

                                       
     return  st;
     
     }
 public ObservableList<TableColumnDataPop>   listDataloader(){
     
//      public ObservableList<TableColumnDataPop>   listDataloader(){

     
   
                      
         
                       
                         
                          
                            try {
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                try {
                                  
String s = "SELECT projectdec.S_N,projectdec.First_Name,projectdec.Sur_Name,projectdec.Reg_No,projectdec.Project_Lec,projectdec.Department,projectdec.Project_Topic,proj_category.Category,projectdec.Project_Score FROM projectdec join proj_category \n" +
"on projectdec.Cat_id = proj_category.cat_id  ";
                                            
//                                            String.format("select * from projectdec");
//

eQuery = DBDriverStatementLoader().executeQuery(s);
                                } catch (SQLException ex) {
                                    notifier.clear();
                                    notifier.setText("SQL ERROR");
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
        
    
    project_lec.add("Project_Lec");
//            con = DriverManager.getConnection("jdbc:sqlite:/protopdectator/PorjectTopicDicOko.db");
//    group.add("Group");
    
    category.add("Category");
    department.add("Department");
    
    
    smptcontaner.add(new TableColumnDataPop(Integer.parseInt(eQuery.getString(1)),
                eQuery.getString("First_Name"),
                eQuery.getString("Sur_Name"),
                eQuery.getString("Reg_No"),
              eQuery.getString("Project_Lec"),
//               eQuery.getString("Group"),
              eQuery.getString("Department"),
              eQuery.getString("Project_Topic"),
            eQuery.getString("Category"),
           eQuery.getString("Project_Score")
                 ));
    
    
}//end of while loop
 
 allArrymak.addAll(project_lec,category,department,smptcontaner);

//smptcontaner.addAll(smpt,smpt1,smpt2,smpt3,smpt4,smpt5,smpt6,smpt7,smpt8,smpt9);
                                         tableView.setItems(smptcontaner);


                            }  
 catch (SQLException ex) {
                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                
//   }
               
        return smptcontaner;
                      
       }
      
          
 
 


                public Statement connectionDriverStatementGetter(){
                  return st;
                }

    @Override
    protected ObservableList<TableColumnDataPop> call() throws Exception {
//          protected ObservableList<TableColumnDataPop> call() throws Exception {

    
        return listDataloader();
    }

}
                         
        
         

    
    
 

