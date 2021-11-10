import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Activity10DAHandler extends DefaultHandler {


    private boolean grupo;
    private boolean categoria;
    private boolean nombre;
    private boolean album;
    private boolean año;


    // Instanciamos nuestra clase de cancion y creamos una lista de ellas
    private Activity10DASong cancion = new Activity10DASong();
    private List<Activity10DASong> canciones = new ArrayList<>();



    /* A partir de aqui sobreescibiremos metodos de DefaultHanler, estos metodos nos permitiran
    separar la informacion de las distintas canciones que contiene el documento xml*/

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(Activity10DASongElement.GRUPO.getName())) {
            grupo = true;
        }
        if (qName.equals(Activity10DASongElement.CATEGORIA.getName())) {
            categoria= true;
        }
        if (qName.equals(Activity10DASongElement.NOMBRE.getName())) {
            nombre = true;
        }
        if (qName.equals(Activity10DASongElement.ALBUM.getName())) {
            album = true;
        }
        if (qName.equals(Activity10DASongElement.AÑO.getName())) {
            año = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(Activity10DASongElement.CANCION.getName())) {
            canciones.add(cancion);
            cancion = new Activity10DASong();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (grupo) {
            cancion.setGrupo(new String(ch, start, length));
            grupo = false;
        }
        if (categoria) {
            cancion.setCategoria(new String(ch, start, length));
            categoria = false;
        }
        if (nombre) {
            cancion.setNombre(new String(ch, start, length));
            nombre = false;
        }
        if (album) {
            cancion.setAlbum(new String(ch, start, length));
            album = false;
        }
        if (año) {
            cancion.setAño(new String(ch, start, length));
            año = false;
        }
    }

    // Este metodo devuelve la lista de canciones generada
    public List<Activity10DASong> getClientes() {
        return canciones;
    }

    
}
