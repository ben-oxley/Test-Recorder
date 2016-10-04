package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by ben on 04/10/2016.
 */
@XmlRootElement
public class Project {
    @XmlElement(name="classes")
    private Collection<TestClass> classes;
    @XmlElement(name="maps")
    private Collection<UIMap> UIMaps;
}
