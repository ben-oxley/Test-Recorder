package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;

/**
 * Created by ben on 04/10/2016.
 */
@XmlRootElement
public class TestMethod {
    @XmlAttribute(name = "name")
    private String methodName;
    @XmlList
    private LinkedList<Action> actions;
}
