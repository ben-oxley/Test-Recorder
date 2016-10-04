package uk.co.benoxley.recorder.domain;

import javafx.scene.Node;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ben on 04/10/2016.
 */
@XmlRootElement
public class NodeIdentifier {

    private String fxid;

    private Collection<String> css;

    private String label;

    public NodeIdentifier(){

    }

    public NodeIdentifier(String fxid, String label, String... css){
        this.fxid = fxid;
        this.label = label;
        this.css = Arrays.asList(css);
    }

    public String getIdentifier(){
        return getFxid();
    }

    @XmlAttribute(name="fxid")
    public String getFxid() {
        return fxid;
    }

    public void setFxid(String fxid) {
        this.fxid = fxid;
    }

    @XmlElement(name="styles")
    public Collection<String> getCss() {
        return css;
    }

    public void setCss(Collection<String> css) {
        this.css = css;
    }

    @XmlAttribute(name="label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
