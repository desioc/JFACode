
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXExampleReader {

    // utility constants
    private static final String EMAIL = "email";
    private static final String FROM = "from";
    private static final String RECIPIENTS = "recipients";
    private static final String SUBJECT = "subject";
    private static final String BODY = "body";

    public List<EMail> readXMLFile(String xmlFile) {
        List<EMail> eMails = new ArrayList<>();
        try {
            //we create a XMLInputFactory...
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // ...and then a XMLEventReader
            InputStream in = new FileInputStream(xmlFile);
            XMLEventReader xmlEventReader = inputFactory.createXMLEventReader(in);
            EMail eMail = null;
            // let's read the xml file
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String localPart = startElement.getName().getLocalPart();
                     //depending on the tag we are reading, let's createan  Email object and set its instance variables
                    switch (localPart) {
                        case EMAIL:
                            eMail = new EMail();
                            break;
                        case FROM:
                            xmlEvent = xmlEventReader.nextEvent();
                            eMail.setFrom(xmlEvent.asCharacters().getData());
                            break;
                        case RECIPIENTS:
                            xmlEvent = xmlEventReader.nextEvent();
                            eMail.setRecipients(xmlEvent.asCharacters().getData());
                            break;
                        case SUBJECT:
                            xmlEvent = xmlEventReader.nextEvent();
                            eMail.setSubject(xmlEvent.asCharacters().getData());
                            break;
                        case BODY:
                            xmlEvent = xmlEventReader.nextEvent();
                            eMail.setBody(xmlEvent.asCharacters().getData());
                            break;
                        default:
                            break;
                    }
                }
                //if we are arrived to the email closed tag we add the mail to the eMails arraylist 
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals(EMAIL)) {
                        eMails.add(eMail);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return eMails;
    }
    
    public static void main(String args[]) {
        StAXExampleReader stAXExampleReader = new StAXExampleReader();
        List<EMail> eMails = stAXExampleReader.readXMLFile("emails.xml");
        for (EMail eMail : eMails) {
            System.out.println(eMail);
        }
    }

}