
package DataModel;

import static DataModel.SimilerProQueryProTopicData.stringVal;
import DataModel.SimilerProject.SimilerTableColumnDataPop;
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
public class SearviveclassBuild4QueryProTopicData  extends Service<ObservableList<SimilerTableColumnDataPop>>{

            static    private StringProperty newtext = new SimpleStringProperty();
            public final void setNewtext(String value) {
            newtext.set(value);
            }
            public static final String getNewtext() {
            return newtext.get();
            }
            public final StringProperty newtextProperty() {
            return newtext;
            }
    
    
    @Override
      protected Task<ObservableList<SimilerTableColumnDataPop>> createTask()
                    {
                        
                        
                       stringVal(getNewtext()); 
//                        generic service ...Task<ObservableList<String>> == SimilerProQueryProTopicData extends Task<ObservableList<String>>  
                    return new SimilerProQueryProTopicData();
                    }
                    }
    
    
    

