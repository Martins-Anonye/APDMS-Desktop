
package DataModel;

import DataModel.MyscsConneectionString;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import protopdectator.AllStaticVariable;

/**
 *
 * @author Martins
 */
public class DeletingOfTableRow implements AllStaticVariable{
                            MyscsConneectionString gfh = new MyscsConneectionString();

  public  DeletingOfTableRow(Button bt, TextField td,TextArea notif){
    bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
                Integer sd = Integer.parseInt(td.getText());

            try {
                String s = String.format("delete  from projectdec where S_N =%d",sd);
                Integer  executeUpdate = gfh.DBDriverStatementLoader().executeUpdate(s);
                if((!executeUpdate.equals(null)) || (!executeUpdate.equals(0))){
                  notif.clear();
                    notif.setText("Value ...Succesfully Deleted");
                    tableView.refresh();
                    sdp.reset();
                    sdp.start();
                }
                else{
                   notif.clear();
                   notif.setText("Value ...does not exist");

                }
            } catch (SQLException ex) {
                Logger.getLogger(DeletingOfTableRow.class.getName()).log(Level.SEVERE, null, ex);
                                                              notif.setText("Error Occured");

            }

        }
    });
    
    }
    
}
