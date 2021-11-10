import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

public class Activity10DA {


        DocumentBuilderFactory docFactory;
        DocumentBuilder docBuilder;
        Document doc;
        Node canciones;

    // Constructor, se instancia el parse.
    public Activity10DA() throws ParserConfigurationException{
        docFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();
        canciones = doc.createElement("canciones");
        doc.appendChild(canciones);
    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        Activity10DA ac = new Activity10DA();
        Scanner sc = new Scanner(System.in);
        // Se pregunta al usuario si desea introducir una cancion
        while (true){
            String opcion = JOptionPane.showInputDialog("Desea añadir una cancion?(S/N)");
            // Si el usuario introduce n se forma el xml, se lee con SAX para mostrarlo por pantalla y se finaliza el bucle.
            if (opcion.equals("N") || opcion.equals("n")){
                // Se forma el xml.
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(ac.doc);
                StreamResult consoleResult = new StreamResult("canciones.xml");
                transformer.transform(source, consoleResult);

                // Se lee con SAX.
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                Activity10DAHandler handler = new Activity10DAHandler();
                saxParser.parse("canciones.xml", handler);
                // Se optiene la lista de canciones y se muestra por pantalla
                List<Activity10DASong> canciones = handler.getClientes();
                for ( Activity10DASong Cancion  : canciones) {
                    System.out.println("Grupo: " + Cancion.getGrupo());
                    System.out.println("Categoria: " + Cancion.getCategoria());
                    System.out.println("Nombre: " + Cancion.getNombre());
                    System.out.println("Album: " + Cancion.getAlbum());
                    System.out.println("Ano: " + Cancion.getAno());
                    System.out.println("---------------------------------------------------------------------------------------------");
                }
                // Se cierra el bucle
                return;
            // Si el usuario introduce s el usuario tendrav que introducir los datos de la cancion y con ellos se creara un elemento cancion
            } else if (opcion.equals("S") || opcion.equals("s")){
                String grupo = JOptionPane.showInputDialog("Introduzca el grupo de la cancion");
                String categoria = JOptionPane.showInputDialog("Introduzca la categoria de la cancion");
                String nombre = JOptionPane.showInputDialog("Introduzca el nombre de la cancion");
                String album = JOptionPane.showInputDialog("Introduzca el album de la cancion");
                String año = JOptionPane.showInputDialog("Introduzca el año de la cancion");

                Activity10DASong ca = new Activity10DASong(grupo, categoria, nombre, album, año);
                Element cancion = ac.doc.createElement("cancion");
                ac.canciones.appendChild(cancion);

                Element grupoCancion = ac.doc.createElement("grupo");
                grupoCancion.setTextContent(ca.getGrupo());

                Element categoriaCancion = ac.doc.createElement("categoria");
                categoriaCancion.setTextContent(ca.getCategoria());

                Element nombreCancion = ac.doc.createElement("nombre");
                nombreCancion.setTextContent(ca.getNombre());

                Element albumCancion = ac.doc.createElement("album");
                albumCancion.setTextContent(ca.getAlbum());

                Element añoCancion = ac.doc.createElement("año");
                añoCancion.setTextContent(ca.getAno());

                cancion.appendChild(grupoCancion);
                cancion.appendChild(categoriaCancion);
                cancion.appendChild(nombreCancion);
                cancion.appendChild(albumCancion);
                cancion.appendChild(añoCancion);


            // Mensaje para indicar al usuario los caracteres permitidos
            } else{
                System.out.println("Introduzca unicamente los caracteres S O N");
            }
        }
    }
    
}
