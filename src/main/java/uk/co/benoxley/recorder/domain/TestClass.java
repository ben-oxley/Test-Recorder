package uk.co.benoxley.recorder.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import java.util.List;

/**
 * Created by ben on 04/10/2016.
 */
public class TestClass {
    @XmlElement
    String className;
    @XmlElement
    TestMethod setup;
    @XmlList
    List<TestMethod> tests;
    @XmlElementRef
    UIMap map;
    @XmlElement
    TestMethod teardown;
}
