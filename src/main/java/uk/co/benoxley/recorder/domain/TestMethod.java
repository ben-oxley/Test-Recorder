package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlList;
import java.util.LinkedList;

/**
 * Created by ben on 04/10/2016.
 */
public class TestMethod {
    @XmlList
    private LinkedList<Action> actions;
}
