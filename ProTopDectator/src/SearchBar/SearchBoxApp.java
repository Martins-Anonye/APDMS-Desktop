/* ....Show License.... */
package SearchBar;
 
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/**
 * A sample that demonstrates use of CSS to create a search box.
 */
public class SearchBoxApp  {
 
    public Parent createContent() {
        final String searchBoxCss =
            getClass().getResource("SearchBox.css").toExternalForm();
        final VBox vbox = new VBox();
        vbox.getStylesheets().add(searchBoxCss);
        vbox.setPrefWidth(300);
        vbox.setMaxWidth(Control.USE_PREF_SIZE);
        vbox.getChildren().add(new SearchBox());
        return vbox;
    }
 
  
}