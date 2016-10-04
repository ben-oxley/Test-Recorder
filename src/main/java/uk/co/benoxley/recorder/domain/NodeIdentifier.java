package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlList;
import java.util.Collection;

/**
 * Created by ben on 04/10/2016.
 */
public class NodeIdentifier {
    @XmlAttribute
    private String fxid;
    @XmlList
    private Collection<String> css;
    @XmlAttribute
    private String label;

    public String getIdentifier(){
        return fxid;
    }
}
