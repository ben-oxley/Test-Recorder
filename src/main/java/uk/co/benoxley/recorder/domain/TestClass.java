package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by ben on 04/10/2016.
 */
@XmlRootElement
public class TestClass {
    @XmlAttribute(name="class")
    String className;
    @XmlElement(name="setup")
    TestMethod setup;
    @XmlElement(name="tests")
    List<TestMethod> tests;
    @XmlElementRef
    UIMap map;
    @XmlElement(name="teardown")
    TestMethod teardown;
}
