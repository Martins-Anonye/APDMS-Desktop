/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import static DataModel.SimilerProQueryProTopicData.stringVal;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import protopdectator.AutoCompTableColumnDataPop;
import protopdectator.TableColumnDataPop;

/**
 *
 * @author Martins
 */
public class SearviveclassBuild4MainTabVwDataVw  extends Service<ObservableList<TableColumnDataPop>>{

            
    @Override
      protected Task<ObservableList<TableColumnDataPop>> createTask()
                    {
//                        
//                       AutoCompSarchTabVw fg = new AutoCompSarchTabVw();
                                      MyscsConneectionString val = new MyscsConneectionString();

                       
//                       fg.getStringVal(getColn());
//                        generic service ...Task<ObservableList<String>> == SimilerProQueryProTopicData extends Task<ObservableList<String>>  
                    return val;
                    }
                    }
    
    
    

