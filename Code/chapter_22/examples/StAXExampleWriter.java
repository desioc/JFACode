
import java.io.FileOutputStream;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;

public class StAXExampleWriter {

    public void saveXMLFile(String fileXML) throws Exception {
        // we create a XMLOutputFactory
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        // we create a XMLEventWriter
        XMLEventWriter xmlEventWriter = xmlOutputFactory
                .createXMLEventWriter(new FileOutputStream(fileXML));
        // we create aXMLEventFactory
        XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
        //XMLEvent end = xmlEventFactory.createDTD("\n");
        // we create and add to a xmlEventWriter the first part of the document
        StartDocument startDocument = xmlEventFactory.createStartDocument();
        xmlEventWriter.add(startDocument);
        Characters newLine = xmlEventFactory.createCharacters("\n");
        xmlEventWriter.add(newLine);
        // we create and add to a xmlEventWriter the initial tag 
        StartElement startElement = xmlEventFactory.createStartElement("", "", "user");
        xmlEventWriter.add(startElement);
        xmlEventWriter.add(newLine);
        // Write the different nodes
        createTag(xmlEventWriter, "name", "Claudio");
        createTag(xmlEventWriter, "surname", "De Sio Cesari");
        xmlEventWriter.add(xmlEventFactory.createEndElement("", "", "user"));
        //xmlEventWriter.add(end);
        xmlEventWriter.add(xmlEventFactory.createEndDocument());
        xmlEventWriter.close();
    }
    // creation of a indented nested tag
    private void createTag(XMLEventWriter xmlEventWriter, String tagName, String tagContent) throws XMLStreamException {
        XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
        // we create the opening tag and add to  xmlEventWriter
        StartElement openTag = xmlEventFactory.createStartElement("", "", tagName);
        Characters newLine = xmlEventFactory.createCharacters("\n");
        Characters spaces = xmlEventFactory.createCharacters("  ");
        xmlEventWriter.add(spaces);
        xmlEventWriter.add(openTag);
        // we create the tag content and add to xmlEventWriter
        Characters characters = xmlEventFactory.createCharacters(tagContent);
        xmlEventWriter.add(characters);
        // we create the closing tag
        EndElement closedTag = xmlEventFactory.createEndElement("", "", tagName);
        xmlEventWriter.add(closedTag);
        xmlEventWriter.add(spaces);
        xmlEventWriter.add(newLine);
    }

    public static void main(String[] args) {
        StAXExampleWriter stAXExampleWriter = new StAXExampleWriter();
        try {
            stAXExampleWriter.saveXMLFile("WriteTestWithStAX.xml");
            System.out.println("File saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}