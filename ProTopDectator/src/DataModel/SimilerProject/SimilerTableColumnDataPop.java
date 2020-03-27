/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel.SimilerProject;

import protopdectator.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author JULIET
 */
public class SimilerTableColumnDataPop  {
final SimpleIntegerProperty s_N ;
 SimpleStringProperty f_name = new  SimpleStringProperty();
 SimpleStringProperty s_name = new  SimpleStringProperty();

 SimpleStringProperty reg_no= new  SimpleStringProperty();
 SimpleStringProperty pro_lec = new  SimpleStringProperty();
// SimpleStringProperty group = new  SimpleStringProperty();
 SimpleStringProperty department = new  SimpleStringProperty();
 SimpleStringProperty pro_topic = new  SimpleStringProperty();
 SimpleStringProperty categorie = new  SimpleStringProperty();
 SimpleStringProperty project_score = new  SimpleStringProperty();

  


    
    public SimilerTableColumnDataPop(Integer   s_N,String  F_name,String  S_name,String  Reg_no,String  Pro_lec,
                          String department,String pro_topic,String project_scor)
     {
         
        this.s_N = new  SimpleIntegerProperty(s_N);
//        this.s_N.set(s_N);
        this.f_name.set(F_name);
        this.s_name.set(S_name);
        this.reg_no.set(Reg_no);
         
         
     this.pro_lec.set(Pro_lec);
//     this.group.set(group);

     this.department.set(department);
     this.pro_topic.set(pro_topic);
//          this.categorie.set(categorie);
project_score.set(project_scor);


    }
    
    
    //
    
    
    public void setS_n(Integer  s_N){
        this.s_N.set(s_N);
        
    }
    
    public Integer getS_N(){
     
    return s_N.get();
        
    }

    //
    
    
    
    
  
    
    
    public void setF_name(String  F_name){
        this.f_name.set(F_name);
        
    }
    
    public String getF_name(){
     
    return f_name.get();
        
    }
    
    
    
    public void setS_name(String  S_name){
        this.s_name.set(S_name);
        
    }
    
    public String getS_name(){
     
    return s_name.get();
        
    }
    
    
     public void setReg_no(String Reg_no){
        this.reg_no.set(Reg_no);
        
    }
    
    public String getReg_no(){
     
    return reg_no.get();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
      public void setPro_lec(String Pro_lec){
        this.pro_lec.set(Pro_lec);
        
    }
    
    public String getPro_lec(){
     
    return pro_lec.get();
        
    }
    
    
    
//    public void setGroup(String group){
//        this.group.set(group);
//        
//    }
//    
//    public String getGroup(){
//     
//    return group.get();
//        
//    }
    
    
     public void setDepartment(String department){
        this.department.set(department);
        
    }
    
    public String getDepartment(){
     
    return department.get();
        
    
    }


    
    
    
  public void setPro_topic(String  pro_topic){
        this.pro_topic.set(pro_topic);
        
    }
    
    public String  getPro_topic(){
     
    return pro_topic.get();
        
    }
    

     public String getProject_score() {
        return project_score.get();
    }

    public void setProject_score(String project_score) {
        this.project_score.set(project_score);
    }
    


  public void setCategorie(String  categorie){
        this.categorie.set(categorie);
        
    }
    
    public String  getCategorie(){
     
    return categorie.get();
        
    }
    
    
}
