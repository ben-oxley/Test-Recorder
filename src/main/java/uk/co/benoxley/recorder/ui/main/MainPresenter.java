package uk.co.benoxley.recorder.ui.main;

import com.airhacks.afterburner.views.FXMLView;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import uk.co.benoxley.recorder.ui.splash.SplashView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ben on 14/10/2016.
 */
public class MainPresenter implements Initializable{
    @FXML
    private TitledPane filePane, codePane, testTitlePane;
    @FXML
    private TreeView<File> testFiles;
    @FXML
    private ToggleButton record;
    @FXML
    private Button load;
    @FXML
    private BorderPane window;

    private Stage primaryStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filePane.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.FILE));
        codePane.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.CODE));
        testTitlePane.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.PLAY));
        load.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.FOLDER_OPEN));
        record.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.DOT_CIRCLE_ALT));
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    @FXML
    public void load(ActionEvent e){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        SplashView view  = new SplashView();
        Scene dialogScene = new Scene(view.getView(), 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }
}
