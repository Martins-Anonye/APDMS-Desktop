/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import protopdectator.AllStaticVariable;

/**
 *
 * @author Martins
 */
public class UpdatingRowNumberOperations implements AllStaticVariable{
    TextArea notifi;
    Integer equel; 
                        MyscsConneectionString gfh = new MyscsConneectionString();

 public UpdatingRowNumberOperations(TextArea notifi,TextField tfrowno,ChoiceBox chb,TextField fname,TextField sname,TextField regno ,TextField proLect,TextField depart,TextField category,TextArea proTopic){
 Integer rowno = Integer.parseInt(tfrowno.getText());
   String fnam = fname.getText();
        String snam = sname.getText();
        String regn = regno.getText();
        String proLec = proLect.getText();
//        String grou = group.getText();
        String depar = depart.getText();
        String categor = category.getText();
        String proTopi = proTopic.getText();
        this.notifi=notifi;
        //for all
        
              InsertingIntoDatabasForNewRow few = new InsertingIntoDatabasForNewRow();
       Integer category1 = few.getCategory(categor);
             
       
       if(!rowno.equals(null)){
                                       
                                    if((fnam.isEmpty()) && (snam.isEmpty()) && (regn.isEmpty()) && (proLec.isEmpty())  && (depar.isEmpty()) && (category1.equals(null))   && (proTopi.isEmpty()) ){
                                    
                                notifi.clear();
                          notifi.setText("All Entry are Empty ");
                                                                                                 
                                    
                                    }
                                    else{
                                       
                                         if( chb.getSelectionModel().isSelected(0)){ 

                                             if((fnam.isEmpty()) || (snam.isEmpty()) || (regn.isEmpty()) || (proLec.isEmpty()) || (depar.isEmpty()) || (category1.equals(null))   || (proTopi.isEmpty()) ){
                                                                                        String s =String.format("update  projectdec set First_Name = '%s',set Sur_Name = '%s',set Reg_No = '%s',set Project_Lec = '%s', set Department='%s',set Project_Topic = '%s', set Cat_Id = %d, where  	S_N = %d)",fnam,snam,regn,proLec,depar,proTopi,category1,rowno);


                                                                       try {
                                                                           equel= gfh.DBDriverStatementLoader().executeUpdate(s);

                                                                           if(equel!=0){

                                                                                           //clear TextField for reuse purpose
                                                                                                     fname.clear();
                                                                                                     sname.clear();
                                                                                                     regno.clear();
                                                                                                     proLect.clear();
//                                                                                                     group.clear();
                                                                                                     depart.clear();
                                                                                                     category.clear();
                                                                                                     proTopic.clear();
                                                                                                     notifi.clear();
                                                                                                     notifi.setText("All Changes ... taking Place \n Table Updated");
                                                                                                     tableView.refresh();
                                                                                                     sdp.reset();
                                                                                                     sdp.start();
                                                                           }
                                                                           else{

                                                                           }
                                                                       } catch (SQLException ex) {
                                                                           Logger.getLogger(UpdatingRowNumberOperations.class.getName()).log(Level.SEVERE, null, ex);

                                                                       }

                                         }


                                       }




                                         //for first name
                                          if( chb.getSelectionModel().isSelected(1)){ 




                                               individuateExecutionforString("First_Name",fnam,"First Name",rowno);
                                                                 fname.clear();

                                          }

                                          //for Sur name


                                        if( chb.getSelectionModel().isSelected(2)){ 


                                              individuateExecutionforString("Sur_Name",snam,"Sur Name ",rowno);
                                                                 sname.clear();



                                        }


                                        //Reg no

                                         if( chb.getSelectionModel().isSelected(3)){ 



                                              individuateExecutionforString("Reg_No",regn,"Reg_No",rowno);
                                        regno.clear();
                                        }





                                         //project  lect

                                         if( chb.getSelectionModel().isSelected(4)){ 


                                               individuateExecutionforString("Project_Lec",proLec,"Project lecturer",rowno);
                                                                 proLect.clear();


                                        }






                                         //Group

//                                         if( chb.getSelectionModel().isSelected(5)){ 
//
//
//                                               individuateExecutionforString("Group",grou,"Group..",rowno);
////                                                                 group.clear();
//
//
//                                        }






                                         //department
                                         if( chb.getSelectionModel().isSelected(6)){ 



                                               individuateExecutionforString("Department",depar,"Department",rowno);
                                                                depart.clear();

                                        }
















                                 //Category
                                 if( chb.getSelectionModel().isSelected(7)){ 
                                                    //                individuateExecutionforString("Cat_Id","Catigory",category1,rowno);

                                                    if(!category1.equals(null)){
                                                            String s =String.format("update  projectdec set Cat_Id = %d where S_N = %d",category1,rowno);



                                                                      try {
                                                               equel= gfh.DBDriverStatementLoader().executeUpdate(s);

                                                               if(equel!=0){

                                                     //clear TextField for reuse purpose
                                                                                  notifi.setText( "New Category"+category1+"... is  Placed For a User \n Table Updated...");
                                                                                       category.clear();
                                                                                        tableView.refresh();
                                                                                        sdp.reset();
                                                                                        sdp.start();

                                                               }
                                                               else{

                                                               }
                                                           } catch (SQLException ex) {
                                                               Logger.getLogger(UpdatingRowNumberOperations.class.getName()).log(Level.SEVERE, null, ex);

                                                           }
                                                    }

                                                     else{


                                               }



                                  }






                                        if( chb.getSelectionModel().isSelected(8)){ 
                            //                individuateExecutionforString("Cat_Id","Catigory",category1,rowno);


                                         individuateExecutionforString("Project_Topic",proTopi,"Project Topic",rowno);
                                                                                   proTopic.clear();


                                        }


                                   }




        }


  else{
                                                                     notifi.setText(" Row Number Is Empty");


  }



             
             
            
             
             
 }   
 
 private void individuateExecutionforString(String col,String val,String ordinary,int rowno){
 
       if(!val.isEmpty()){

                                                   String s =String.format("update  projectdec set %s = '%s' where S_N = %d",col,val,rowno);



                              try {
                       equel= gfh.DBDriverStatementLoader().executeUpdate(s);

                       if(equel!=0){

                                                                    notifi.clear(); 
                                                             notifi.setText("New Value: "+val+"  has been taking Place \n Table Updated");
                                                                tableView.refresh();   
                                                                sdp.reset();
                                                                sdp.start();
                       }
                       else{
                                                        notifi.clear();
                                                    notifi.setText("Operation Not successfull");

                       }
                   } catch (SQLException ex) {
                       Logger.getLogger(UpdatingRowNumberOperations.class.getName()).log(Level.SEVERE, null, ex);
                                       notifi.clear();
                                         notifi.setText("Operation Not successfull");

                   }

 
    }
       else{
       
                                                    notifi.clear();

                  notifi.setText("Value is Empty \n Operation Not successfull");

       }
 }
}
