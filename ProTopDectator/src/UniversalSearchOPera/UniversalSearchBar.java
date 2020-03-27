/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversalSearchOPera;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import protopdectator.AllStaticVariable;
import static protopdectator.AllStaticVariable.universaltextBox;
import protopdectator.ProjectTopicDic;

/**
 *
 * @author Martins
 */
public class UniversalSearchBar  implements AllStaticVariable{
                     UniversalSearchGen universalSearchjkl = new UniversalSearchGen();

    public UniversalSearchBar() {

           
                 SimpleIntegerProperty st = new SimpleIntegerProperty();
//        st.bind(choiceBox1.getSelectionModel().selectedIndexProperty());
       choiceBox1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                     @Override
                     public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
 
                st.set(newValue.intValue());
                         universaltextBox.clear();
                                             tableViewsearch.getItems().clear();
                
                                             
                                             colmn.clear();
                                             
                                                    universalSearchjkl.specialBkgrndTrackEventForProjectTopicDictator(universaltextBox);
      accordion0.setExpandedPane(titledPane2);
                                             
                                             if(choiceBox1.getSelectionModel().isSelected(0)){
                universalSearchjkl.setColumnValue("Reg_No");
                                             } 

                                             
      if(choiceBox1.getSelectionModel().isSelected(1)){
                universalSearchjkl.setColumnValue("Project_Topic");

                
    }
      
      if(choiceBox1.getSelectionModel().isSelected(2)){
                                       universalSearchjkl.setColumnValue("Project_Lec");

      
      }
      
              if(choiceBox1.getSelectionModel().isSelected(3)){

//             dfg.reset();
//                dfg.setValuessech("Department");
                        universalSearchjkl.setColumnValue("Department");

//               dfg.start();
              
              }
        }
                 }); 
      
       
        
    
    }


}