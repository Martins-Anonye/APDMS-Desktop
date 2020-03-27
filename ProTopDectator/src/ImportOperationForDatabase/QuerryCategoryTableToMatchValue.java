/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportOperationForDatabase;

import DataModel.MyscsConneectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Martins
 */
public class QuerryCategoryTableToMatchValue {
    ResultSet eQuery;
   ObservableList<Integer> sncontainer =  FXCollections.observableArrayList();
    ObservableList<String> catContainaner =  FXCollections.observableArrayList();
     ObservableList<ObservableList> categoryContainerArray =  FXCollections.observableArrayList();
 public ObservableList<ObservableList>   listDataloader(){
     
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
sncontainer.add(Integer.parseInt(eQuery.getString("Cat_Id")));
catContainaner.add(eQuery.getString("Category"));
   
   
    System.out.println("getting value from category table for excelloperation");
}//end of while loop
 
  categoryContainerArray.addAll(sncontainer,catContainaner);
//smptcontaner.addAll(smpt,smpt1,smpt2,smpt3,smpt4,smpt5,smpt6,smpt7,smpt8,smpt9);


                            }  
 catch (SQLException ex) {
                             Logger.getLogger(MyscsConneectionString.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                
//   }
               
        return categoryContainerArray;
                      
       }
   
    
}
