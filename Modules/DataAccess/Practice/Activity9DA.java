import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Activity9DA {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        /* Se parsea el documento utilizando el handler que hemos creado
         y se muestra por pantalla los distintos clientes y la informacion de cada uno*/
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         Activity9DAHandler handler = new Activity9DAHandler();
         saxParser.parse("clientes.xml", handler);
         // Se optiene la lista de clientes y se muestra por pantalla
         List<Activity9DACliente> clientes = handler.getClientes();
         for ( Activity9DACliente Cliente : clientes) {
             System.out.println("Nombre: " + Cliente.getNombre());
             System.out.println("Edad: " + Cliente.getEdad());
             System.out.println("---------------------------------------------------------------------------------------------");
         }
    }
}
