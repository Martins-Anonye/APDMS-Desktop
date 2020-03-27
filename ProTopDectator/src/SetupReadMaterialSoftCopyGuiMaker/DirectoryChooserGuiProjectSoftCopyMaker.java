package SetupReadMaterialSoftCopyGuiMaker;

import static SetupReadMaterialSoftCopyGuiMaker.DirectoryChoserForSoftCopyTextField.textFielddirchoser;
import java.io.File;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.lang.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import static protopdectator.AllStaticVariable.notifier;

public  class DirectoryChooserGuiProjectSoftCopyMaker extends BorderPane  implements DirectoryChoserForSoftCopyTextField{
    static Stage stamaker;

    protected final VBox vBox;
    protected final Button button;
    protected final VBox vBox0;
    protected final Text text;
    protected final HBox hBox;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
 

    public DirectoryChooserGuiProjectSoftCopyMaker() {
  DirectoryChooser dir_chooser = new DirectoryChooser(); 
        vBox = new VBox();
        button = new Button();
        vBox0 = new VBox();
        text = new Text();
        hBox = new HBox();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        //textFielddirchoser = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        button.setMnemonicParsing(false);
        button.setText("Select Source Location ");
        button.setFont(new Font(15.0));
        vBox.setOpaqueInsets(new Insets(0.0));
        vBox.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        setCenter(vBox);

        text.setFill(javafx.scene.paint.Color.valueOf("#254ac3"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Directory Chooser for Project Soft Copy Viewer.");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(594.36279296875);
        text.setFont(new Font(39.0));

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("FILE FORMAT");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(191.13671875);
        text0.setFont(new Font("Arial Black", 25.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#a42525"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText(".doc / .docx / .pdf");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(176.16796875);
        text1.setFont(new Font(18.0));

        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Pls make sure that the Project Soft Copy is Saved Using Reg_No.");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        text2.setWrappingWidth(600.2890625);
        text2.setFont(new Font("System Bold Italic", 16.0));

        text3.setLayoutX(10.0);
        text3.setLayoutY(127.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("For Instance: When Reg_no is FPOCEHA17067, the file name should be  FPOCEHA17067.doc or FPOCEHA17067.pdf or FPOCEHA17067.docx. Also make sure that their is microsoft word or adobe reader(third  party ) are  installed in the System.");
        text3.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        text3.setWrappingWidth(596.4375);
        text3.setFont(new Font("System Bold Italic", 16.0));
        VBox.setMargin(text3, new Insets(10.0, 0.0, 0.0, 0.0));
textFielddirchoser.setEditable(false);
        textFielddirchoser.setPrefHeight(31.0);
        textFielddirchoser.setPrefWidth(537.0);
        textFielddirchoser.setPromptText("directory detector");
        textFielddirchoser.setFont(new Font(15.0));
        VBox.setMargin(textFielddirchoser, new Insets(10.0, 0.0, 0.0, 0.0));
        setTop(vBox0);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           //textFielddirchoser.setText();
            
              
       
               File file = dir_chooser.showDialog(stamaker); 
  
                    if (file != null) { 
                        textFielddirchoser.setText(file.getAbsolutePath()); 
                        textara.setText(textFielddirchoser.getText());
                        notifier.clear();
                        notifier.setText("Selected directory for project soft copy .....\n"+textFielddirchoser.getText());
                    } 
                    
            
            
            }
        });
        
        vBox.getChildren().add(button);
        vBox0.getChildren().add(text);
        hBox.getChildren().add(text0);
        hBox.getChildren().add(text1);
        vBox0.getChildren().add(hBox);
        vBox0.getChildren().add(text2);
        vBox0.getChildren().add(text3);
        ScrollPane scroler = new ScrollPane();
        Text txdir = new Text("Selected Diretory :");
        VBox vbdir = new VBox(txdir,textFielddirchoser);
        vbdir.setPadding(new Insets(20,0,0,0));
        scroler.setContent(vbdir);
        vBox0.getChildren().add(scroler);
        scroler.setFitToHeight(true);
        scroler.setFitToWidth(true);
        
        Scene sce = new Scene(this);
        stamaker.setScene(sce);
        stamaker.show();
        
        stamaker.setResizable(false);

    }
    public static void setStageForSoptCopyDirectoryChooser(Stage fromStartMethod,Stage parent){
    
    stamaker = fromStartMethod;
stamaker.initOwner(parent);
    stamaker.setAlwaysOnTop(true);
    
    }
}
