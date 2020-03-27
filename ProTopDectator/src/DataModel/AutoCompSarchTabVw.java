
package DataModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import protopdectator.AllStaticVariable;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.TableColumnDataPop;

/**
 *
 * @author Martins
 */
public class AutoCompSarchTabVw  extends Task< ObservableList<AutoCompTableColumnDataPop>> implements AllStaticVariable{
    
         ObservableList<AutoCompTableColumnDataPop> emptyarrya = FXCollections.observableArrayList();
static String stringval;
String tab;
int getstringno;
ResultSet executeQuery ;
public void loadMyAutoCompDriver(){
    
     
        try {
            try {
                Class.forName("org.controlsfx").newInstance();
            } catch (InstantiationException ex) {
//                Logger.getLogger(AutoCompSarchTabVw.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
//                Logger.getLogger(AutoCompSarchTabVw.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AutoCompSarchTabVw.class.getName()).log(Level.SEVERE, null, ex);
        }
                              
    
    }

    @Override
    protected  ObservableList<AutoCompTableColumnDataPop> call() throws Exception {
        
 
//        return null;

           
         MyscsConneectionString sd = new MyscsConneectionString();
//             String s = String.format("select %s from %s", colname,tab);
//             String s = String.format("select Project_Topic from projectdec where Project_Topic like '%soler%' ");
                                                 String sg ="'%";
                                                 String sdf = "%'";
                                                 
//             String s = String.format("SELECT * FROM projectdec WHERE Project_Topic  LIKE '%s%s%s'",sg,stringval,sdf);
       



       

    
//  String stringval =  fig.get();
    
//    String op = sg+stringval+sdf;
                                       String s = String.format("SELECT * FROM projectdec WHERE Project_Topic  LIKE %s order by Project_Topic",stringval);
//SELECT * FROM `projectdec` where Project_Topic like '%solar%' order by Project_Topic
//                          String s = String.format("SELECT * FROM projectdec WHERE Project_Topic  LIKE '%%s%'",stringval);
//                                         String s = "SELECT * FROM projectdec WHERE Project_Topic  LIKE" +stringval;

//                          String s = "SELECT * FROM projectdec WHERE Project_Topic  LIKE '%solar%'";
//                String s = "SELECT * FROM projectdec WHERE S_N  = 1";

              executeQuery = sd.DBDriverStatementLoader().executeQuery(s);
                               
//   }




while(executeQuery.next() ){
           if (this.isCancelled() || stringval.contains(" "))
                {
            break;
            }
           
          
//    smpt.add(eQuery.getString(1));
////    smpt1.add(eQuery.getString(2));
////    smpt2.add(eQuery.getString(3));
//    
    
      colmn.addAll(new AutoCompTableColumnDataPop(Integer.parseInt(executeQuery.getString(1)),
                executeQuery.getString("First_Name"),
                executeQuery.getString("Sur_Name"),
                executeQuery.getString("Reg_No"),
              executeQuery.getString("Project_Lec"),
//               executeQuery.getString("Group"),
              executeQuery.getString("Department"),
              executeQuery.getString("Project_Topic"),
//            executeQuery.getString("Category")
              
              executeQuery.getString("Project_Score")
                 ));

//      colmn.addAll(new AutoCompTableColumnDataPop(1,"sed","das","gam","make","Dome","gam","make"));
//                    tableViewsearch.setItems(colmn);
//                    tableViewsearch.getItems().addAll(colmn);
//           tableViewsearch.getItems().clear();

 System.out.println(stringval);
//  if (this.stringval.contains("\\s"))  {
//updateValue
//      updateValue(FXCollections.<AutoCompTableColumnDataPop>unmodifiableObservableList(emptyarrya));
//           tableViewsearch.getItems().clear();

//            break;

//            }
//  else{
      updateValue(FXCollections.<AutoCompTableColumnDataPop>unmodifiableObservableList(colmn));

                   
                                  }
               
        return colmn;
        
        
        
        
        
//       }
    
    
    
    
    
    
  
    }
//    
      public  void getStringVal(String col){
    
    
   this.stringval= col;
    }
    
}
