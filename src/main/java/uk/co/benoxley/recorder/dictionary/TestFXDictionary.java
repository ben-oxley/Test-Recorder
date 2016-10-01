package uk.co.benoxley.recorder.dictionary;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.testfx.api.FxRobot;

import java.util.Iterator;
import java.util.Set;

/**
 public FxRobotInterface clickOn(Node node,
 MouseButton... buttons);
 public FxRobotInterface rightClickOn(Node node);
 public FxRobotInterface doubleClickOn(Node node,
 MouseButton... buttons);
 public FxRobotInterface drop();
 public FxRobotInterface dropBy(double x,
 double y);
 public FxRobotInterface drag(Node node,
 MouseButton... buttons);
 public FxRobotInterface dropTo(Node node);
 public FxRobotInterface press(KeyCode... keys);
 public FxRobotInterface release(KeyCode... keys);
 public FxRobotInterface press(MouseButton... buttons);
 public FxRobotInterface release(MouseButton... buttons);
 public FxRobotInterface moveTo(Node node);
 public FxRobotInterface scroll(int amount,
        VerticalDirection direction);
 public FxRobotInterface scroll(VerticalDirection direction);
 public FxRobotInterface push(KeyCode... combination);
 public FxRobotInterface type(KeyCode... keys);
 public FxRobotInterface eraseText(int characters);
 public FxRobotInterface write(String text);
 */

/**
 * Created by ben on 30/09/2016.
 */
public class TestFXDictionary implements Dictionary {

    @Override
    public String translate(Event event) {
        return null;
    }

    public String translate(MouseEvent event){
        StringBuilder sb = new StringBuilder();
        if (!event.isDragDetect()) {
            if (event.isPrimaryButtonDown()) {
                sb.append("clickOn(");
            } else if (event.isSecondaryButtonDown()) {
                sb.append("rightClickOn(");
            }
        }
        sb.append(getNodeDescriptor(getIntersectedNode(event)));
        sb.append(");");
    }

    public String translate(DragEvent event){

        return null;
    }

    public String translate(KeyEvent event){

        return null;
    }

    public Node getIntersectedNode(MouseEvent event){
        return event.getPickResult().getIntersectedNode();
    }

    public Node getIntersectedNode(DragEvent event){
        return event.getPickResult().getIntersectedNode();
    }

    public String getNodeDescriptor(Node node){
        if (node.getId()!=""){
            return "#"+node.getId();
        } else if (node instanceof Labeled){
            Labeled labeled = (Labeled) node;
            String text = labeled.getText();
            if (text != ""){
                return text;
            }
        } else if (!node.getStyleClass().isEmpty()){
            FxRobot robot = new FxRobot();
            Iterator<String> iterator = node.getStyleClass().iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                Set<Node> nodes = robot.from(node.getScene().getRoot()).lookup("." + next).queryAll();
                if (nodes.size()==1){
                    //We've found a unique css identifier for the
                    return "."+next;
                }
            }



        }
    }
}
