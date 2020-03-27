/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import DataModel.SimilerProject.SimilerTableColumnDataPop;
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
import protopdectator.AllStaticVariable;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.TableColumnDataPop;
/**
 *
 * @author MartinsEagleEyes
 */
public class SimilerProQueryProTopicData extends Task<ObservableList<SimilerTableColumnDataPop>> implements AllStaticVariable{
    
    
    
   static  SimpleStringProperty sad = new SimpleStringProperty();
    Connection    con;
    Statement st;
     ResultSet eQuery;
     ObservableList<SimilerTableColumnDataPop> Project_Topic = FXCollections.observableArrayList();
     ObservableList<String> f_name = FXCollections.observableArrayList();
     ObservableList<String> s_name = FXCollections.observableArrayList();
     ObservableList<String> reg_no = FXCollections.observableArrayList();
   
     
     ObservableList<String> prolec = FXCollections.observableArrayList();
     ObservableList<String> group = FXCollections.observableArrayList();
     ObservableList<String> dept = FXCollections.observableArrayList();
   
     
 public ObservableList<SimilerTableColumnDataPop>  listDataloader(){
     
//      public ObservableList<TableColumnDataPop>   listDataloader(){

   
                      
         
         while(true){              
                         
                          
                            try {
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                try {
                                  
String s = String.format("SELECT * FROM projectdec where Cat_id=(select Cat_id from  proj_category where Category like '%s')",sad.get());
                                            
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
        
                                        System.out.println("query succesfull");

//    Project_Topic.add(eQuery.getString("First_Name")+" "+eQuery.getString("Sur_Name")+" "+eQuery.getString("Reg_No")+" "+eQuery.getString("Project_Lec")+" "+eQuery.getString("Group")+" "+eQuery.getString("Project_Topic")+" "+eQuery.getString("Department"));
    Project_Topic.add( new SimilerTableColumnDataPop( Integer.parseInt(eQuery.getString("S_N")),eQuery.getString("First_Name"),eQuery.getString("Sur_Name"),eQuery.getString("Reg_No"), eQuery.getString("Project_Lec"),eQuery.getString("Department"),eQuery.getString("Project_Topic"),eQuery.getString("Project_Score")));

    lst.getItems().clear();
    lst.getItems().addAll(Project_Topic);
//    lst.setItems();
//       f_name.add();
//    s_name.add();
//    reg_no.add();
////    prolec.add(eQuery.getString("Project_Lec"));
//    group.add(eQuery.getString("Group"));
//        dept.add(eQuery.getString("Department"));


    updateValue(FXCollections.<SimilerTableColumnDataPop>unmodifiableObservableList(Project_Topic));
    
}//end of while loop
 
 
                            }  
 catch (SQLException ex) {
                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                
//   }
               
         
               return Project_Topic;
              
     
      
 }     
 }
 


               

    @Override
    protected ObservableList<SimilerTableColumnDataPop> call() throws Exception {
//          protected ObservableList<TableColumnDataPop> call() throws Exception {

    
        return listDataloader();
    }
    public static void stringVal (String sd){
    sad.set(sd);
    }

}
                         
        
         

    
    
 

