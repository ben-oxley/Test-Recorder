package uk.co.benoxley.recorder.domain;

import javafx.scene.Node;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by ben on 04/10/2016.
 */
public class NodeIdentifierXMLTest {
    private static final Logger LOGGER = Logger.getLogger(NodeIdentifierXMLTest.class.getName());

    @Test
    public void serializeDeserializeTest() throws JAXBException {
        NodeIdentifier sut = new NodeIdentifier("nodeName","label","nodeStyle");
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(NodeIdentifier.class);
        Marshaller m = context.createMarshaller();

        m.marshal(sut, writer);
        String xmlString = writer.toString();
        LOGGER.log(Level.INFO,()->"Seralized Object:"+xmlString);
        Unmarshaller um = context.createUnmarshaller();
        NodeIdentifier unmarshal = (NodeIdentifier) um.unmarshal(new StringReader(xmlString));
        assertEquals(sut.getFxid(),unmarshal.getFxid());
        assertEquals(sut.getLabel(),unmarshal.getLabel());
        assertEquals(sut.getCss(),unmarshal.getCss());
    }
}
