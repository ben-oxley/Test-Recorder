package uk.co.benoxley.recorder.dictionary;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.Pagination;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.testfx.api.FxRobot;

import java.util.Iterator;
import java.util.Optional;
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
    public Optional<String> translate(Event event) {
        Optional<String> result = Optional.empty();
        if (MouseEvent.ANY.equals(event.getEventType()!=null?event.getEventType().getSuperType():null)){
            result = translate((MouseEvent) event);
        }
        return result;
    }

    public Optional<String> translate(MouseEvent event){
        boolean valid = true;
        StringBuilder sb = new StringBuilder();
        if (MouseEvent.MOUSE_ENTERED.equals(event.getEventType())){
            sb.append("moveTo(");
        }
        else if (!event.isDragDetect()) {
            if (event.isPrimaryButtonDown()) {
                sb.append("clickOn(");
            } else if (event.isSecondaryButtonDown()) {
                sb.append("rightClickOn(");
            } else {
                valid = false;
            }
        } else {
            valid = false;
        }
        Optional<String> nodeDescriptor = getNodeDescriptor(getIntersectedNode(event));
        nodeDescriptor.ifPresent(sb::append);
        valid = valid && nodeDescriptor.isPresent();
        sb.append(");");
        Optional<String> result = Optional.empty();
        if (valid){
            result = Optional.of(sb.toString());
        }
        return result;
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

    public Optional<String> getNodeDescriptor(Node node){
        if (node.getId()!=""&&node.getId()!=null){
            return Optional.of("#"+node.getId());
        } else if (node instanceof Labeled){
            Labeled labeled = (Labeled) node;
            String text = labeled.getText();
            if (text != "" && text!=null){
                return Optional.of(text);
            }
        } else if (!node.getStyleClass().isEmpty()){
            FxRobot robot = new FxRobot();
            Iterator<String> iterator = node.getStyleClass().iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                Set<Node> nodes = robot.from(node.getScene().getRoot()).lookup("." + next).queryAll();
                if (nodes.size()==1){
                    //We've found a unique css identifier for the
                    return Optional.of("."+next);
                }
            }



        }
        return Optional.empty();
    }
}
