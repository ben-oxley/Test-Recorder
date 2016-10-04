package uk.co.benoxley.recorder.domain;

import javafx.scene.Node;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ben on 04/10/2016.
 */
@XmlRootElement
public class Action {
    //from
    @XmlElement(name="identifier",required=true)
    private NodeIdentifier identifier;
    //action
    @XmlElement(name="interaction",required=true)
    private Interaction interaction;

}
