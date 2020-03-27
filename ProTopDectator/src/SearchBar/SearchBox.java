/* ....Show License.... */
package SearchBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Region;
import protopdectator.AllStaticVariable;
import protopdectator.ProjectTopicDic;
 
public class SearchBox extends Region implements AllStaticVariable{
 
    private Button clearButton;
 
    public SearchBox() {
        setId("SearchBox");
        getStyleClass().add("search-box");
        setMinHeight(30);
        setPrefSize(300, 50);
        setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        clearButton = new Button();
        clearButton.setVisible(false);
        clearButton.setOnAction((ActionEvent actionEvent) -> {
            universaltextBox.setText("");
            universaltextBox.requestFocus();
        });
      
        universaltextBox.setPromptText("Search");
        universaltextBox.getStyleClass().add("textbox");
        final ChangeListener<String> textListener =
            (ObservableValue<? extends String> observable,
             String oldValue, String newValue) -> {
                clearButton.setVisible(universaltextBox.getText().length() != 0);
            };
        universaltextBox.textProperty().addListener(textListener);
        
        getChildren().addAll(universaltextBox, clearButton);
        
        
    
       
    }
       @Override
     protected void layoutChildren() {
        universaltextBox.resize(getWidth(), getHeight());
    clearButton.resizeRelocate(getWidth() - 18, 6, 12, 13);
    }
}