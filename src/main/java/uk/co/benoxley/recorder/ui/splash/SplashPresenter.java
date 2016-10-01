package uk.co.benoxley.recorder.ui.splash;

import com.sun.javafx.event.EventHandlerManager;
import com.sun.javafx.scene.EnteredExitedHandler;
import com.sun.javafx.scene.NodeEventDispatcher;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by ben on 12/07/2016.
 */
public class SplashPresenter implements Initializable {

    @FXML
    ComboBox<Class> classesCmb;

    @Inject
    Stage stage;

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loadJar(ActionEvent action){
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Java archives","*.jar"));

        File file = chooser.showOpenDialog(stage);
        if (file !=null) {
            ObservableList<Class> applications = FXCollections.observableArrayList();
            Enumeration<JarEntry> e;

            URLClassLoader cl;
            try (JarFile jarFile = new JarFile(file.getPath())) {
                e = jarFile.entries();
                URL[] urls = {new URL("jar:file:" + file.getPath() + "!/")};
                cl = URLClassLoader.newInstance(urls);

                while (e.hasMoreElements()) {
                    JarEntry je = e.nextElement();
                    if (je.isDirectory() || !je.getName().endsWith(".class")) {
                        continue;
                    }
                    // -6 because of .class
                    String className = je.getName().substring(0, je.getName().length() - 6);
                    className = className.replace('/', '.');
                    Class c = cl.loadClass(className);
                    if (Application.class.isAssignableFrom(c)) {
                        applications.add(c);
                    }



                }
                classesCmb.setItems(applications);
                System.out.println("Loaded "+applications.size()+" classes.");
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }


    }

    @FXML
    public void run(ActionEvent action) throws Exception {
        if (classesCmb.getSelectionModel().getSelectedItem()!=null){
            Class selectedItem = classesCmb.getSelectionModel().getSelectedItem();
            Application o = (Application)selectedItem.newInstance();
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            o.start(stage);

            stage.getScene().getRoot().setEventDispatcher(new EventDispatcherListener(stage.getScene().getRoot()));
            //hide this current window (if this is whant you want
            //((Node)(action.getSource())).getScene().getWindow().hide();
        }
    }

    class EventDispatcherListener extends NodeEventDispatcher{

        public EventDispatcherListener(Object eventSource) {
            super(eventSource);
        }

        public EventDispatcherListener(EnteredExitedHandler enteredExitedHandler, EventHandlerManager eventHandlerManager) {
            super(enteredExitedHandler, eventHandlerManager);
        }

        @Override
        public Event dispatchEvent(Event event, EventDispatchChain tail) {
            if (event instanceof MouseEvent) {
                MouseEvent mouseEvent = (MouseEvent) event;
                if (!mouseEvent.getEventType().equals(MouseEvent.MOUSE_MOVED)) {
                    Node intersectedNode = mouseEvent.getPickResult().getIntersectedNode();
                    System.out.println(mouseEvent.getSceneX() + "," + mouseEvent.getSceneY() + "," + intersectedNode != null ? intersectedNode.toString() : "null");

                }
            }
            return super.dispatchEvent(event, tail);
        }
    }
}
