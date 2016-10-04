package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Created by ben on 04/10/2016.
 */
@XmlEnum
public enum Interaction {
    LEFT_CLICK("clickOn($NODE)"),
    RIGHT_CLICK("rightClickOn($NODE)"),
    DOUBLE_LEFT_CLICK("doubleClickOn($NODE)"),
    DOUBLE_RIGHT_CLICK("doubleClickOn($NODE,MouseButton.SECONDARY"),
    DROP("drop()"),
    DRAG("drag($NODE,MouseButton.PRIMARY)"),
    DROP_TO("dropTo($NODE)"),
    PRESS("press($KEY)"),
    RELEASE("release($KEY)"),
    MOVE_TO("moveTo($NODE)"),
    SCROLL_DOWN("scroll(VerticalDirection.DOWN)"),
    SCROLL_UP("scroll(VerticalDirection.UP)"),
    PUSH("push($KEY)"),
    TYPE("type($KEY)"),
    ERASE("erase(1)"),
    WRITE("write($STRING)");

    private String action;

    private Interaction(String action){
        this.action = action;

    }

    public String compileAction(){
        return action;
    }

}
