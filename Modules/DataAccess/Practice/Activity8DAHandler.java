import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/* Esta clase que extiende de DefaultHandler es la clase que utilizaremos
 como handler para el parse de nuestro documento xml*/
public class Activity8DAHandler extends DefaultHandler {


    private boolean nombre;
    private boolean precio;
    private boolean descripcion;
    private boolean calorias;


    // Instanciamos nuestra clase de platos y creamos una lista de ellos
    private Activity8DAFood plato = new Activity8DAFood();
    private List<Activity8DAFood> platos = new ArrayList<>();



    /* A partir de aqui sobreescibiremos metodos de DefaultHanler, estos metodos nos permitiran
    separar la informacion de los distintos platos que contiene el documento xml*/

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(Activity8DABreakfastElement.NAME.getName())) {
            nombre = true;
        }
        if (qName.equals(Activity8DABreakfastElement.PRICE.getName())) {
            precio = true;
        }
        if (qName.equals(Activity8DABreakfastElement.DESCRIPTION.getName())) {
            descripcion = true;
        }
        if (qName.equals(Activity8DABreakfastElement.CALORIES.getName())) {
            calorias = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(Activity8DABreakfastElement.FOOD.getName())) {
            platos.add(plato);
            plato = new Activity8DAFood();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nombre) {
            plato.setNombre(new String(ch, start, length));
            nombre = false;
        }
        if (precio) {
            plato.setPrecio(Double.parseDouble(new String(ch, start, length)));
            precio = false;
        }
        if (descripcion) {
            plato.setDescripcion(new String(ch, start, length));
            descripcion = false;
        }
        if (calorias) {
            plato.setCalorias(Integer.parseInt(new String(ch, start, length)));
            calorias = false;
        }
    }

    // Este metodo devuelve la lista de platos generada
    public List<Activity8DAFood> getBreakfast() {
        return platos;
    }

    
}
