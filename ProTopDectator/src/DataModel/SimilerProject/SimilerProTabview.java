/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel.SimilerProject;

import protopdectator.*;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Martins
 */
public class SimilerProTabview implements AllStaticVariable{
//     protected final TableView<TableColumnDataPop> tableView;
    protected final TableColumn<SimilerTableColumnDataPop,Integer> tableColumn  = new TableColumn();
    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn0  = new TableColumn();
    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn1  = new TableColumn();
    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn2  = new TableColumn();
    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn3 = new TableColumn();
//    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn4  = new TableColumn();
    protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn5 = new TableColumn();
   
         protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn6  = new TableColumn();
  protected final TableColumn<SimilerTableColumnDataPop,String> tableColumn7score  = new TableColumn();
       
         static Stage  simpleOPeratnStag;
         public  void simpleTableViewMk(){
            
//            tableColumn
//        tableColumn0 = new TableColumn();
//        tableColumn1 = new TableColumn();
//        tableColumn2 = new TableColumn();
//        tableColumn3 = new TableColumn();
//        tableColumn4 = new TableColumn();
//        tableColumn5 = new TableColumn();
//        tableColumn6 = new TableColumn();
//        tableColumn7 = new TableColumn();

                    tableViewsearch.setPrefHeight(121.0);
        tableViewsearch.setPrefWidth(494.0);
//#my-table
        tableViewsearch.getStyleClass().add("my-table");
        tableColumn.setPrefWidth(75.0);
        tableColumn.setText("S/N");

        tableColumn0.setPrefWidth(75.0);
        tableColumn0.setText("First Name");

        tableColumn1.setPrefWidth(75.0);
        tableColumn1.setText("Sur Name");

        tableColumn2.setPrefWidth(100.0);
        tableColumn2.setText("Reg No");

        tableColumn3.setPrefWidth(100.0);
        tableColumn3.setText("Project Lecturer");
//
//        tableColumn4.setPrefWidth(75.0);
//        tableColumn4.setText("Group");

        tableColumn5.setPrefWidth(75.0);
        tableColumn5.setText("Department");

        tableColumn6.setMaxWidth(Double.MAX_VALUE);
        tableColumn6.setMinWidth(100);
        tableColumn6.setPrefWidth(200);
        tableColumn6.setText("Project Topic");
        
                  tableColumn7score.setMaxWidth(Double.MAX_VALUE);
        tableColumn7score.setMinWidth(100);
        tableColumn7score.setPrefWidth(200);
        tableColumn7score.setText("Project Score");

            
//
//        tableColumn7.setMaxWidth(Double.MAX_VALUE);
//        tableColumn7.setMinWidth(100);
//        tableColumn7.setPrefWidth(200);
//        tableColumn7.setText("Project Topic");

         

        lst.getColumns().addAll(tableColumn,tableColumn0,tableColumn1,tableColumn2,tableColumn3,tableColumn5,tableColumn6,tableColumn7score);


        
        tableColumn.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,Integer>("s_N"));
         tableColumn0.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("f_name"));
                 tableColumn1.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("s_name"));
 tableColumn2.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("reg_no"));
         tableColumn3.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("Pro_lec"));
//                 tableColumn4.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("group"));
                 tableColumn5.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("department"));
     
                 
                  tableColumn6.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("pro_topic"));
                      tableColumn7score.setCellValueFactory(new PropertyValueFactory<SimilerTableColumnDataPop,String>("project_score"));


            }
            
            
            
     
    
            
    
}
