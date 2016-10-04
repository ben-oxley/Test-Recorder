package uk.co.benoxley.recorder.domain;

import javafx.scene.Node;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by ben on 04/10/2016.
 */
public class Action {
    //from
    @XmlElement
    private NodeIdentifier identifier;
    //action
    @XmlElement
    private Interaction interaction;

}
