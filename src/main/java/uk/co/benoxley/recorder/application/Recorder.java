package uk.co.benoxley.recorder.application;/**
 * Created by ben on 12/07/2016.
 */

import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.co.benoxley.recorder.ui.main.MainView;
import uk.co.benoxley.recorder.ui.splash.SplashView;

public class Recorder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getView());
        mainView.getPresenter().setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
        Injector.setModelOrService(Stage.class,primaryStage);

    }
}
