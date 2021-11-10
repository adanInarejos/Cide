import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Activity8DA {

    public SAXParserFactory factory;
    public SAXParser parser;
    public Activity8DAHandler sh;

    public Activity8DA() throws ParserConfigurationException, SAXException{
     
    }
    
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        /* Se parsea el documento utilizando el handler que hemos creado
         y se muestra por pantalla los distintos platos y la informacion de cada uno*/
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        Activity8DAHandler handler = new Activity8DAHandler();
        saxParser.parse("SAX.xml", handler);
        // Se optiene la lista de platos y se muestra por pantalla
        List<Activity8DAFood> list = handler.getBreakfast();
        for (Activity8DAFood food : list) {
            System.out.println("Name: " + food.getNombre());
            System.out.println("Description: " + food.getDescripcion());
            System.out.println("Price: " + food.getPrecio());
            System.out.println("Calories: " + food.getCalorias());
            System.out.println("---------------------------------------------------------------------------------------------");
        }
        }
    }

