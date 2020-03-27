/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel.CategoryModel;

import DataModel.MyscsConneectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import protopdectator.AllStaticVariable;
import static protopdectator.AllStaticVariable.notifier;

/**
 *
 * @author Martins
 */
public class CategoryModeling implements AllStaticVariable{
   static  Stage sdcate;
    ResultSet eQuery;
    Integer eQuery1;
   
   MyscsConneectionString msd = new MyscsConneectionString();
    public void operatOnCategory(ChoiceBox cating){
        cating.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    //add

if(newValue.equals(0)){
addCategory();


}
//delte
if(newValue.equals(1)){

delcategory();

}

//update
if(newValue.equals(2)){

updateCategory();

}

            }
        });
//        view
    
    
    
    
//    del
   
    
    
    }
    private void addCategory(){
        
VBox bd = new VBox();
    bd.setAlignment(Pos.CENTER);

            bd.setSpacing(10);
bd.setPadding(new Insets(5));
Text tsx = new Text("Enter values to add new Row in Category Table");
tsx.setFill(Paint.valueOf("blue"));
tsx.setFont(Font.font(20));
Text sv = new Text("S N");
Text sv1 = new Text("Category");

TextField tfg = new TextField();
tfg.setPromptText("S_N");
tfg.setMaxWidth(100);

TextField tfg1 = new TextField();
tfg1.setPromptText("Category");

Button addn = new Button("Add Cat..");

bd.getChildren().addAll(tsx,sv,tfg,sv1,tfg1,addn);

addn.setOnMouseClicked(new  EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) 
    { Integer lit = Integer.parseInt(tfg.getText());
   String catval = tfg1.getText();
        if(lit>0){
   String s= String.format("insert into proj_category values(%s,'%s')",lit,catval);      
        try {
            eQuery1 = msd.DBDriverStatementLoader().executeUpdate(s);
            if(eQuery1 !=0){
               notifier.clear();
               notifier.setText("New Row Added Succecfully,  \n Row Number"+lit+ "   value:"+catval);
     
            }
              else{
            notifier.clear();
               notifier.setText("No New Row Added  May be   \n Row Number"+lit+ " or  value:"+catval+"\n Not a Valide Value");
     
            }      
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModeling.class.getName()).log(Level.SEVERE, null, ex);
            notifier.clear();
            notifier.setText(" Error value "+catval+".... Not Add \n Check your input(s)");
        }

    }
        
        else{
         notifier.clear();
            notifier.setText(" Error value "+catval+".... Not Add \n Check your input(s)");
       
        
        }
    }
});






        showCatestageMaker(bd);




        
    
    
    }
    private void updateCategory(){
    
    VBox bd = new VBox();
    bd.setAlignment(Pos.CENTER);
    Text tsx = new Text("Enter values to UpdateRow in Category Table");
tsx.setFill(Paint.valueOf("blue"));
Text sv = new Text("S N");
Text sv1 = new Text("Category");

TextField tfg = new TextField();
tfg.setMaxWidth(100);
tfg.setPromptText("S_N");
TextField tfg1 = new TextField();
tfg1.setPromptText("Category");
Button bt = new Button("Update");

bd.getChildren().addAll(tsx,sv,tfg,sv1,tfg1,bt);
bd.setPadding(new Insets(5));

            bd.setSpacing(10);

bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
 Integer lit = Integer.parseInt(tfg.getText());
   String catval = tfg1.getText();
   String updat = String.format("update proj_category set proj_category = '%s' where S_N = %s",catval,lit);
        try {
            eQuery1 = msd.DBDriverStatementLoader().executeUpdate(updat);
             if(eQuery1 !=0){
               notifier.clear();
               notifier.setText(" Row Succecfully Updated,  \n Row Number"+lit+ "   value:"+catval);
     
            }
              else{
            notifier.clear();
               notifier.setText(" No Row is Updated May be   \n Row Number"+lit+ " or  value:"+catval+"\n Not a Valide Value");
     
            }    
        } catch (SQLException ex) {
            
             notifier.clear();
               notifier.setText(" Error exist while  Updating Row May be   \n Row Number"+lit+ " or  value:"+catval+"\n Not a Valide Value");
     
            Logger.getLogger(CategoryModeling.class.getName()).log(Level.SEVERE, null, ex);
           
        }
           
         }
});
        showCatestageMaker(bd);

    }
    
    public void viewCategory(Button viewcat){
    viewcat.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

  String s = "select * from proj_category";
        try {
            eQuery = msd.DBDriverStatementLoader().executeQuery(s);
        } catch (SQLException ex) {
            
            
             notifier.clear();
               notifier.setText("Errory Exist During  Operation");
     
//            Logger.getLogger(CategoryModeling.class.getName()).log(Level.SEVERE, null, ex);
        }
         ListView  sn = new ListView();
    ListView<String>  lst = new ListView();
        try {
            while(eQuery.next()){
                sn.getItems().add(eQuery.getString("Cat_Id"));
                lst.getItems().add(eQuery.getString("Category"));
               notifier.clear();
               notifier.setText("Query Succecfully");
     
            }
        } catch (SQLException ex) {
          
//            Logger.getLogger(CategoryModeling.class.getName()).log(Level.SEVERE, null, ex);
              notifier.clear();
               notifier.setText("Errory Exist During  Operation");
     
        }
    
    HBox bx = new HBox(sn,lst);
    showCatestageMaker(bx);
   
    

        }
    });
        
    }
    private void delcategory(){
    
        Text tx = new Text("Enter Row Number Delete");
        tx.setFill(Paint.valueOf("blue"));
        tx.setFont(Font.font(15));
    TextField txtf = new TextField();
    txtf.setMaxWidth(100);

    Button bte = new Button("Delete");
            bte.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                             if(!txtf.getText().isEmpty()){

                try {
                    Integer it =  Integer.parseInt(txtf.getText());
                    String s = "delete from proj_category where Cat_Id ="+it;
                    eQuery1 = msd.DBDriverStatementLoader().executeUpdate(s);
                    if(eQuery1 !=0){
               notifier.clear();
               notifier.setText("Row Number"+it+" Deleted Succecfully");
     
            }
              else{
            notifier.clear();
               notifier.setText("No Row Deleted");
     
            } 
                    
                    
                    
                 
                } catch (SQLException ex) {
                      notifier.clear();
               notifier.setText("Error No Row Deleted");
     
                    Logger.getLogger(CategoryModeling.class.getName()).log(Level.SEVERE, null, ex);
              
                }
                }
                             
                                else{
                    notifier.clear();
               notifier.setText("Error No Row Deleted \n  Check your Input and try again ");
     
                    }
                
            }
        });
            
            
            
            VBox vbx = new VBox(tx,txtf,bte);
            vbx.setSpacing(10);
                vbx.setAlignment(Pos.CENTER);
         vbx.setPadding(new Insets(5));
        showCatestageMaker(vbx);

    
    
    
    }
    public static void CategoryTageMaker(Stage cat){
        sdcate=cat;

    sdcate.initModality(Modality.WINDOW_MODAL);
    sdcate.initOwner(pri);
    
    }
    public void showCatestageMaker(Parent nd){
                nd.getStylesheets().add(this.getClass().getResource("/css/CategoryTageMaker.css").toExternalForm());

    sdcate.setScene(new Scene(nd));
    sdcate.setResizable(false);
    sdcate.show();
    }
    
}
