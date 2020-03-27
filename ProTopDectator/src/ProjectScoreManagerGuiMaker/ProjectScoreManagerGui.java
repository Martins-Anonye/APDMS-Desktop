/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectScoreManagerGuiMaker;

import DataModel.MyscsConneectionString;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static protopdectator.AllStaticVariable.sdp;
import static protopdectator.AllStaticVariable.tableView;

/**
 *
 * @author Martins
 */
public class ProjectScoreManagerGui {
static Stage stagegui;
int equel;
int equel1;
    public ProjectScoreManagerGui() {
        
        
//    Scoreguimaker.initModality(Modality.WINDOW_MODAL);
  
stagegui.setAlwaysOnTop(true);

Scene sne = new Scene(setScoregui(),500,500);
stagegui.setScene(sne);
stagegui.show();


    }
  private  VBox setScoregui(){
    VBox vbxforall = new VBox();
    vbxforall.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
    vbxforall.setPadding(new Insets(20,0,20,0));
    vbxforall.setAlignment(Pos.CENTER);
     Text txManager = new Text("PROJECT SCORE MANAGER");
     txManager.setFill(Paint.valueOf("red"));
     txManager.setFont(Font.font(20));
     
    
    VBox vbxadd = new VBox();
    VBox.setMargin(vbxadd, new Insets(30,0,30,0));
    vbxadd.setAlignment(Pos.CENTER);
    Text txtv = new Text("Add Project Score");
    txtv.setFill(Paint.valueOf("blue"));
     txtv.setStrokeWidth(20);
//     txtv.setStrokeType(StrokeType.INSIDE);
//     txtv.setStroke(Paint.valueOf("red"));
   txtv.setFont(Font.font(16));
     
    Text txtvSN = new Text("S/N :"); 
    txtvSN.setFill(Paint.valueOf("white"));
     txtvSN.setFont(Font.font(14));
     
    TextField tfd = new TextField();
    tfd.setPrefSize(50, 20);
     HBox hbk = new HBox();
     hbk.setAlignment(Pos.CENTER);
     hbk.setSpacing(30);
    hbk.getChildren().addAll(txtvSN,tfd);
    VBox.setMargin(hbk, new Insets(0,0,0,-50));
    vbxadd.getChildren().addAll(txtv);
   
     Text txtvval = new Text("Value :");
     txtvval.setFill(Paint.valueOf("white"));
     txtvval.setFont(Font.font(14));
    TextField tfvval = new TextField();
    tfvval.setPrefSize(100, 20);
     HBox hbkval = new HBox();
     hbkval.setSpacing(30);
      hbkval.setAlignment(Pos.CENTER);
      
     
    hbkval.getChildren().addAll(txtvval,tfvval);
    
    
     HBox hold2hbox = new HBox();
     hold2hbox.setSpacing(30);
      hold2hbox.setAlignment(Pos.CENTER);
    hold2hbox.getChildren().addAll(hbk,hbkval);
        Button btnadd =new Button("Add");
btnadd.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
             MyscsConneectionString gfh = new MyscsConneectionString();
         int rowno =   Integer.parseInt( tfd.getText());
       String  val =  tfvval.getText();
         
        String s =String.format("update  projectdec set Project_Score = '%s' where S_N = %d",val,rowno);

            try {
                equel= gfh.DBDriverStatementLoader().executeUpdate(s);
            } catch (SQLException ex) {
                Logger.getLogger(ProjectScoreManagerGui.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                if(equel!=0){
                    
                    
                            Alert sd = new Alert(Alert.AlertType.INFORMATION);
                    sd.setContentText("Value Successfully Updated");
                    sd.setTitle("Update Value");
                    sd.initModality(Modality.NONE);
                    sd.initOwner(stagegui);
                    sd.show();
                    tfd.setText(" ");
                    tfvval.setText(" ");
                    
                   tableView.refresh();
                          
                    tableView.setItems(sdp.getValue());
                               
                
                }
                else{
                Alert afd = new Alert(Alert.AlertType.ERROR);
                afd.setContentText("No Value Added");
                afd.setTitle("Error exist while adding");
                afd.show();
                     
                    tableView.setItems(sdp.getValue());
                           
                }
                                                                           
                    }
    });
     
        vbxadd.getChildren().addAll(hold2hbox,btnadd);
 vbxadd.setSpacing(15);
     vbxadd.setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), CornerRadii.EMPTY, Insets.EMPTY)));

    
    VBox vbdel = new VBox();
Text txtdel = new Text("Delete Project Score");
txtdel.setFill(Paint.valueOf("blue"));

     txtdel.setFont(Font.font(16));
     
    Text txtdelSN = new Text("S/N"); 
    txtdelSN.setFill(Paint.valueOf("white"));
     txtdelSN.setFont(Font.font(14));
    TextField tfddel = new TextField();
     tfddel.setPrefSize(100, 20);
    
    HBox hbkdel = new HBox();
    hbkdel.setAlignment(Pos.CENTER);
     hbkdel.setSpacing(30);
    hbkdel.getChildren().addAll(txtdelSN,tfddel);
        
    Button btndel =new Button("delete");
    
    
    btndel.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
             MyscsConneectionString gfh = new MyscsConneectionString();
         int valrowno =   Integer.parseInt( tfddel.getText());
      
         
        String s =String.format("update  projectdec set Project_Score = ' ' where S_N = %d",valrowno);

            try {
                equel1= gfh.DBDriverStatementLoader().executeUpdate(s);
            } catch (SQLException ex) {
                Logger.getLogger(ProjectScoreManagerGui.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
         if(equel1!=0){
            Alert sd = new Alert(Alert.AlertType.INFORMATION);
            sd.setContentText("Value Successfully Cleared");
            sd.setTitle("Clear Value");
            sd.initModality(Modality.NONE);
            sd.initOwner(stagegui);
            sd.show();
            tfddel.setText("");
            tableView.refresh();
 tableView.setItems(sdp.getValue());
            }
         else{
          Alert sd = new Alert(Alert.AlertType.INFORMATION);
            sd.setContentText("Not Successfully Cleared");
            sd.setTitle("Clear Value");
            sd.initModality(Modality.NONE);
            sd.initOwner(stagegui);
            sd.show();
            tableView.refresh();
                    tableView.setItems(sdp.getValue());

         
         }
                                                                           
                    }
    });
     
    vbdel.getChildren().addAll(txtdel,hbkdel,btndel);
         vbdel.setSpacing(15);
         vbdel.setAlignment(Pos.CENTER);
         vbdel.setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), CornerRadii.EMPTY, Insets.EMPTY)));

    vbxforall.getChildren().addAll(txManager,vbxadd,vbdel);
    
   return vbxforall;
    }
    
  public static void scoreStageMaker(Stage stageguigero, Stage myparent){
        stagegui=stageguigero;

//    stagegui.initModality(Modality.WINDOW_MODAL);
  stagegui.initOwner(myparent);
//    
    }
    
    
}
