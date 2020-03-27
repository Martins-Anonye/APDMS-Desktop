/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversalSearchOPera;

import DataModel.MyscsConneectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import static protopdectator.AllStaticVariable.colmn;
import static protopdectator.AllStaticVariable.notifier;
import static protopdectator.AllStaticVariable.tableViewsearch;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.ProjectTopicDic;

/**
 *
 * @author Martins
 */
public class UniversalSearchGen {
    
    ResultSet executeQuery;
   static SimpleStringProperty searchtableviewcolumn = new SimpleStringProperty();

    
   
   
   
   
   
   
   
   
       
    public void specialBkgrndTrackEventForProjectTopicDictator(TextArea textArea){
    
        

                     textArea.setOnKeyTyped(new EventHandler<KeyEvent>() {
                         int b = 0;
                                 int a = 0;

                         @Override

                             public void handle(KeyEvent event) {
                                 String toString = event.getCharacter().toString();
                //                  String character = newValue.toString();

                String text9 = textArea.getText();

                ////

                    if(toString.contains(" ")){
                     String val;
                     if(a==0){
                     val = text9.substring(a);
                     //filter out words
                          if(val.contains("of") || val.contains("and")||val.contains("if")||val.contains("the")||val.contains("is")||val.contains("for")){
                         
                              notifier.clear();
                                    notifier.setText("for, is, the, if,e.t.c are not inclided in the Search operation ");
                           }//end of filter
                     }
                     else{
                         String[] split = text9.split(" ");
                       int as=  split.length;
                    int news = as-1;
                         String name = split[news];
                            val = name;

                     }


                             String hapi = "'%"+val+"%'";
                                                  //filter out words

                         if(hapi.contains("of") || hapi.contains("and")||hapi.contains("if")||hapi.contains("the")||hapi.contains("is")||hapi.contains("for")){
                 
                                      notifier.clear();
                                    notifier.setText("for, is, the, if,e.t.c are not inclided in the Search operation ");
                          }//end fo filter
                         
                 else{
                    makeQuery(hapi);
                System.out.println("b "+b);
                System.out.println("a "+a);

                System.out.println(hapi);

                a++;
                 }
        

                }





                }






                         });


    
    }
    
    public void makeQuery( String fog){
        
        String tablecoln = searchtableviewcolumn.get();

      MyscsConneectionString sd = new MyscsConneectionString();
                                  String s = String.format("SELECT * FROM projectdec WHERE  %s LIKE %s order by %s ",tablecoln,fog,tablecoln);
    try {
executeQuery = sd.DBDriverStatementLoader().executeQuery(s);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTopicDic.class.getName()).log(Level.SEVERE, null, ex);
        }
                               
//   }
        try {
            while(executeQuery.next() ){
                
                


colmn.addAll(new AutoCompTableColumnDataPop(Integer.parseInt(executeQuery.getString(1)),
        executeQuery.getString("First_Name"),
        executeQuery.getString("Sur_Name"),
        executeQuery.getString("Reg_No"),
        executeQuery.getString("Project_Lec"),
//        executeQuery.getString("Group"),
        executeQuery.getString("Department"),
        executeQuery.getString("Project_Topic"),
        
        executeQuery.getString("Project_Score")
        
//            executeQuery.getString("Category")
));

//      colmn.addAll(new AutoCompTableColumnDataPop(1,"sed","das","gam","make","Dome","gam","make"));
//                    tableViewsearch.setItems(colmn);
notifier.clear();
notifier.setText("Search Operation on Progress......................Search Completed.");
//      
           tableViewsearch.getItems().clear();

                    tableViewsearch.getItems().addAll(colmn);
 








            }   }
        catch (SQLException ex) {
            Logger.getLogger(ProjectTopicDic.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void setColumnValue(String s){
    searchtableviewcolumn.set(s);
            }
}
