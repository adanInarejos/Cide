import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import org.w3c.dom.Element;

public class Activity7DA {
    // Atributos necesarios para el programa.
    static File xml = new File("Videojuego.xml");
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    Node videojuegos;

    // Constructor: Instanciamos el nodo padre de nustro documento xml.
    public Activity7DA() throws ParserConfigurationException, SAXException, IOException{
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(xml);
            videojuegos = doc.getFirstChild();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }


    // Este metodo crea un elemento videojuego con sus distintos atributos. 
    private void crearVideojuego(String titulo, String creador, String sinopsis, String plataforma, String creado_en) throws ParserConfigurationException, SAXException, IOException{
        
        // Creacion del elemento.
        Element videojuego = doc.createElement("videojuego");
        this.videojuegos.appendChild(videojuego);

        // Nodos hijos (elementos de el videojuego)
        Node tituloVj = doc.createElement("Titulo");
        tituloVj.setTextContent(titulo);
        Node creadorVj = doc.createElement("Creador");
        creadorVj.setTextContent(creador);
        Node sinopsisVj = doc.createElement("Sinopsis");
        sinopsisVj.setTextContent(sinopsis);
        Node plataformaVj = doc.createElement("Plataforma");
        plataformaVj.setTextContent(plataforma);
            

        videojuego.appendChild(tituloVj);
        videojuego.appendChild(creadorVj);
        videojuego.appendChild(sinopsisVj);
        videojuego.appendChild(plataformaVj);

        // Atributo del nodo videojuego.
        videojuego.setAttribute("creado_en", creado_en);

    }

    // Muestra por terminal el arbol de elementos actual.
    private void mostrarArbol() throws TransformerException {
        System.out.println("Arbol de Contenido\n------------------");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }

    // Busca un videojuego por titulo y modifica su titulo por el que se le pase como parametro.
    private void cambiarTitulo(String juego, String titulo){

        NodeList nodes = videojuegos.getChildNodes();
        for (int i = 1; i < nodes.getLength(); i++) {
            if (nodes.item(i).getFirstChild().getTextContent().equals(juego)){
                nodes.item(i).getFirstChild().setTextContent(titulo);
            } else {
                
            }
        } 
    }

    // Busca un videojuego por su titulo y lo elimina del arbol.
    private void eliminarVideojuego(String juego) {
        NodeList nodes = videojuegos.getChildNodes();
        for (int i = 1; i < nodes.getLength(); i++) {
            if (nodes.item(i).getFirstChild().getTextContent().equals(juego)){
                videojuegos.removeChild(nodes.item(i));
            } else {
        
            }
        }
    }

    // Guarda el arbol actual en un nuevo documento xml.
    private void guardarArbol() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult consoleResult = new StreamResult("resultado.xml");
        transformer.transform(source, consoleResult);
    }




    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        try {
        Activity7DA A = new Activity7DA();
        // Se crean 5 videojuegos.
        A.crearVideojuego("Minecraft", "Manolo", "Juego de Cubiculos", "PC", "San Diego California");
        A.crearVideojuego("GTA6", "Rockstar North", "Nunca va a salir", "PC-PS5-PROYCTX", "California");
        A.crearVideojuego("Bioshock", "Rockstar North", "Nunca va a salir", "PC-PS5-PROYCTX", "California");
        A.crearVideojuego("Lola indigo", "Rockstar North", "Nunca va a salir", "PC-PS5-PROYCTX", "California");
        A.crearVideojuego("Star Wars III", "Rockstar North", "Nunca va a salir", "PC-PS5-PROYCTX", "California");
        // Se modifican 2 videojuegos.
        A.cambiarTitulo("Minecraft", "MAINCRAH");
        A.cambiarTitulo("Lola indigo", "Shakira");
        // Se elemina un videojuego.
        A.eliminarVideojuego("GTA6");
        // Se guarda el arbol en un documento xml.
        A.guardarArbol();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
}
