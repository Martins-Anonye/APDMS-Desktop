/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportOperationForDatabase;

import DataModel.MyscsConneectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Martins
 */

public class ImportSqlStatement {
   static  int checkero=0;
   static  ResultSet executequerrymetadata;
    
   
    public static String  deletAllValueFromTheTableOperation(){
    String dropper = "delete from 'projectdec'";
    return dropper;
    }
   
//      public static String  dropTableAllValueFromTheTableOperation(){
//    String dropper = "drop table 'projectdec'";
//    return dropper;
//    }
    
    
    
    public  static int querryDbForAperticulerCtaegory(String categoryValueFromExcel){
    
    
    String categoryGeterr = String.format("select Cat_id from proj_category where \"Category\"='%s'", categoryValueFromExcel);
       Statement dBDriverStatementLoader = new MyscsConneectionString().DBDriverStatementLoader();
       try {
        ResultSet executeQuery = dBDriverStatementLoader.executeQuery(categoryGeterr);
        while(executeQuery.next()){
        int sn = Integer.parseInt(executeQuery.getString("Cat_id"));
        return sn;
        
        }
       } catch (SQLException ex) {
           Logger.getLogger(ImportSqlStatement.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 0;
   
    }   
    public static String createTableStatemt(){
    String createtab ="CREATE TABLE [projectdec] (\n" +
"  [S_N] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
"  [First_Name] [VARCHAR(15)] NOT NULL COLLATE BINARY, \n" +
"  [Sur_Name] [VARCHAR(20)] NOT NULL COLLATE BINARY, \n" +
"  [Reg_No] [VARCHAR(20)] NOT NULL COLLATE BINARY, \n" +
"  [Project_Lec] [VARCHAR(20)] NOT NULL COLLATE BINARY, \n" +
"  [Department] [VARCHAR(20)] NOT NULL COLLATE BINARY, \n" +
"  [Project_Topic] TEXT NOT NULL COLLATE BINARY, \n" +
"  [Cat_Id] INT NOT NULL CONSTRAINT [projectdec_ibfk_1] REFERENCES [proj_category]([Cat_Id]) ON DELETE RESTRICT ON UPDATE RESTRICT, \n" +
"  [Project_Score] [VARCHAR2(0, 5)])";
    
    return createtab;
    
    }
    
   
  public static void  insertInToTableUsingValueFromExcellFile(int newwest,String fnam,String snam,String regn,String proLec,String  depar,String proTopi,String categoryvalueFromEcxel,String scorevalueFromEcxel){
    
      // we check if scorevalueFromEcxel have value or empty
      
      ObservableList<ObservableList> listDataloader = new  QuerryCategoryTableToMatchValue().listDataloader();
      
      if ((!scorevalueFromEcxel.isEmpty()) ||(!scorevalueFromEcxel.equals(""))||(!scorevalueFromEcxel.equals(" ")) ){
          
          // we check for value in the category to match with the excell
          ObservableList<Integer> sn = listDataloader.get(0);
           ObservableList<String> category = listDataloader.get(1);
          for (int a =0;a<sn.size();a++){
              
              Integer catSn = sn.get(a);
              String getCat = category.get(a);
             
              //if(checkero<=3){
                       System.out.println(newwest+" "+fnam +" "+snam+" "+regn+proLec+" "+depar+" "+proTopi+" "+catSn+" "+" "+scorevalueFromEcxel);
                   //   System.out.println(getCat    +"   "+categoryvalueFromEcxel);
//             checkero++;
//              }
              if(getCat.equalsIgnoreCase(categoryvalueFromEcxel)){
                 // Integer catSn = catarray.getCatSn();
                                                   String s =String.format("insert into projectdec VALUES(%d,'%s','%s','%s','%s','%s','%s',%d,'%s')",newwest,fnam,snam,regn,proLec,depar,proTopi,catSn,scorevalueFromEcxel);

    
                                                   
                            //       String s =String.format("insert into projectdec VALUES('%s','%s','%s','%s','%s','%s',%d,'%s')",fnam,snam,regn,proLec,depar,proTopi,catSn,scorevalueFromEcxel);
                   
                  try {                                Statement DBDriverStatementLoader = new MyscsConneectionString().DBDriverStatementLoader();
//                                                                   DBDriverStatementLoader.executeUpdate("commit");
                    ImportExcellFileMakerForQuery.executeUpdate    = DBDriverStatementLoader.executeUpdate(s);
//                    DBDriverStatementLoader.executeUpdate("commit");
                  } catch (SQLException ex) {
                      Logger.getLogger(ImportSqlStatement.class.getName()).log(Level.SEVERE, null, ex);
                  }
              
                  
                  }
              
                  
          }
    }
      else{ // we check for value in the category to match with the excell
           ObservableList<Integer> sn = listDataloader.get(0);
           ObservableList<String> category = listDataloader.get(0);
          for (int a =0;a<sn.size();a++){
              Integer catSn = sn.get(a);
              String getCat = category.get(a);
              if(getCat.equalsIgnoreCase(categoryvalueFromEcxel)){
                 // Integer catSn = catarray.getCatSn();
               String s =String.format("insert into projectdec VALUES(%d,'%s','%s','%s','%s','%s','%s',%d,null)",newwest,fnam,snam,regn,proLec,depar,proTopi,catSn,scorevalueFromEcxel);
                    
//                              String s =String.format("insert into projectdec VALUES('%s','%s','%s','%s','%s','%s',%d,null)",fnam,snam,regn,proLec,depar,proTopi,catSn,scorevalueFromEcxel);

               
               try {
                    ImportExcellFileMakerForQuery.executeUpdate    = new MyscsConneectionString().DBDriverStatementLoader().executeUpdate(s);
                  } catch (SQLException ex) {
                      Logger.getLogger(ImportSqlStatement.class.getName()).log(Level.SEVERE, null, ex);
                  }
             
              
             
              }
          }
      }
                         
                           
    }
  
  
  public static Boolean  qurryDBMetaDataToCheckIfprojecdeskTableExist(){
      
      String metadatqurry ="select name,tbl_name,type from sqlite_master where \"name\"='projectdec'";
  
       
       try {
           executequerrymetadata    = new MyscsConneectionString().DBDriverStatementLoader().executeQuery(metadatqurry);
       } catch (SQLException ex) {
           Logger.getLogger(ImportSqlStatement.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       System.out.println(executequerrymetadata);
    try {
      while(executequerrymetadata.next()){
          return true;
      }
    } catch (SQLException ex) {
           Logger.getLogger(ImportSqlStatement.class.getName()).log(Level.SEVERE, null, ex);
       }

       return false;
      
      
      
  
  }
}
