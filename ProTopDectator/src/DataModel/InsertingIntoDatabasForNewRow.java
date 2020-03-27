/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import RowCounter.RowCounts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import protopdectator.AllStaticVariable;

/**
 *
 * @author Martins
 */
public class InsertingIntoDatabasForNewRow  implements AllStaticVariable{
    Integer equel;
     ResultSet categoryget;
     Integer val;
       TextArea notifi;
     public InsertingIntoDatabasForNewRow(){
     
     }
     
   public  InsertingIntoDatabasForNewRow(TextField sn,TextArea notifi,TextField fname,TextField sname,TextField regno ,  TextField proLect,TextField depart,TextField category,TextArea proTopic ){
       this.notifi=notifi;
       String sn1 =sn.getText();
       String fnam = fname.getText();
        String snam = sname.getText();
        String regn = regno.getText();
        String proLec = proLect.getText();
////        String grou = group.getText();
        String depar = depart.getText();
        String categor = category.getText();
        String proTopi = proTopic.getText();
                 if(                        ((!sn1.isEmpty())&&(!fnam.isEmpty()) && (!snam.isEmpty()) && (!regn.isEmpty())&& (!proLec.isEmpty()) ) &&(!depar.isEmpty()) &&(!proTopi.isEmpty())      ){
                 
                       if(!categor.equals(" ")){
                        final   int category1 = getCategory(categor);
                        Integer newwest = Integer.parseInt(sn1);
//                        RowCounts   autorow = new RowCounts();
                            
//                          final int autoRowNo = autorow.presentdbrowcounter();
//                        int newwest  = autoRowNo+1;
                           MyscsConneectionString gfh = new MyscsConneectionString();
//                       String s =String.format("insert into projectdec(S_N,First_Name,Sur_Name,Reg_No,Project_Lec,Group,Department,Project_Topic,Cat_Id)VALUES(%d,'%s','%s','%s','%s','%s','%s','%s',%d)",autoRowNo,fnam,snam,regn,proLec,grou,depar,proTopi,category1);
//                                                  String s =String.format("insert into projectdec VALUES(%d,'%s','%s','%s','%s','%s','%s','%s',%d)",autoRowNo,fnam,snam,regn,proLec,grou,depar,proTopi,category1);
                       String s =String.format("insert into projectdec VALUES(%d,'%s','%s','%s','%s','%s','%s',%d,null)",newwest,fnam,snam,regn,proLec,depar,proTopi,category1);

                           try {
                               equel= gfh.DBDriverStatementLoader().executeUpdate(s);
                           if(equel!=0){
                                  //Textfiel clear for reuse purpoe  
                                  sn.clear();
                                  fname.clear();
                                     sname.clear();
                                     regno.clear();
                                     proLect.clear();
//                                     group.clear();
                                     depart.clear();
                                     category.clear();
                                     proTopic.clear();   
                                               tableView.refresh();
                                               sdp.reset();
                                               sdp.start();
                                               
                                               
                                               
                                             notifi.clear();
                                                             notifi.setText("new Row Added Succefully \n Row Number"+newwest);

                           }
                              else{
                                notifi.clear();
                                                             notifi.setText("No Row Added  \n Row Number"+newwest);

                              }
                           } catch (SQLException ex) {
                               Logger.getLogger(InsertingIntoDatabasForNewRow.class.getName()).log(Level.SEVERE, null, ex);
                           //     
                            notifi.clear();
                                                             notifi.setText("Error exist while adding a new Row");

                           }
                             
                           

                       }
                       
                       
                       else{
                       
                       
                       }
                 }
                 
                 else{
                 
                 
                 }
                 
    
    
}
    
    public int getCategory(String s){
     MyscsConneectionString gfh = new MyscsConneectionString();
String ss = "select Cat_Id from proj_category where Category='"+s+"'";
        try {
          categoryget=  gfh.DBDriverStatementLoader().executeQuery(ss);
        } catch (SQLException ex) {
            Logger.getLogger(InsertingIntoDatabasForNewRow.class.getName()).log(Level.SEVERE, null, ex);
        }
     try {
            while(categoryget.next()){
                Integer asd = Integer.parseInt(categoryget.getString(1));
               
              if(asd.equals(null)){                             
               break;
              }  
              else{
                           val=asd;

              }          
            }
        } catch (SQLException ex) {
                                           notifi.clear();

                  notifi.setText("Error In Category");
  }
        
                    
        return val;
    
    
    }
}
