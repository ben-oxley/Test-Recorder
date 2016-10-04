package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlList;
import java.util.Collection;

/**
 * Created by ben on 04/10/2016.
 */
public class Project {
    @XmlList
    private Collection<TestClass> classes;
    @XmlList
    private Collection<UIMap> UIMaps;
}
