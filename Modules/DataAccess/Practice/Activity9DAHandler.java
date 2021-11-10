import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Activity9DAHandler extends DefaultHandler {


    private boolean nombre;
    private boolean edad;


    // Instanciamos nuestra clase de clientes y creamos una lista de ellos
    private Activity9DACliente cliente = new Activity9DACliente();
    private List<Activity9DACliente> clientes = new ArrayList<>();



    /* A partir de aqui sobreescibiremos metodos de DefaultHanler, estos metodos nos permitiran
    separar la informacion de los distintos clientes que contiene el documento xml*/

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(Activity9DAClienteElement.NOMBRE.getName())) {
            nombre = true;
        }
        if (qName.equals(Activity9DAClienteElement.EDAD.getName())) {
            edad = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(Activity9DAClienteElement.ClIENTE.getName())) {
            clientes.add(cliente);
            cliente = new Activity9DACliente();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nombre) {
            cliente.setNombre(new String(ch, start, length));
            nombre = false;
        }
        if (edad) {
            cliente.setEdad(Integer.parseInt(new String(ch, start, length)));
            edad = false;
        }
    }

    // Este metodo devuelve la lista de platos generada
    public List<Activity9DACliente> getClientes() {
        return clientes;
    }

    
}
