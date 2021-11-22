
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlManager {

    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;

    // Atributos para DOM
    Document doc;
    Node registre_alumnes;

    // Atributo para XPath
    XPath xpath;


    // Constructor
    public XmlManager() throws ParserConfigurationException{
        docFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();
        // Nodo raiz
        registre_alumnes = doc.createElement("registre_alumnes");
        doc.appendChild(registre_alumnes);

        xpath = XPathFactory.newInstance().newXPath();
    }

    // Metodo para crear el documento XML
    public void crearDocumento() throws TransformerException{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(this.doc);
        StreamResult consoleResult = new StreamResult("alumnos.xml");
        transformer.transform(source, consoleResult);

        System.out.println("--------------------------\nDocumento creado correctamente\n--------------------------");
    }

    // Optimizar : Metodo para añadir registros al documento xml 
    public void añadirRegistros(Document document) throws TransformerException{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        DOMSource source = new DOMSource(document);
        StreamResult consoleResult = new StreamResult("alumnos.xml");
        transformer.transform(source, consoleResult);
    }

    // Este metodo generara un elemento alumno a partir de los datos que introduzca el usuario
    public void registarAlumno(String codigo, String nom_alumne, String curs, String any_naixement, String colegi) throws TransformerException, SAXException, IOException{

        // Se parsea el documento y se obtiene el modo raiz
        Document docParse = docBuilder.parse("alumnos.xml");
        Element alumnes = (Element) docParse.getFirstChild();

        // Se crea un elemento alumno y se añade el atributo "codi_alumne"
        Element alumne = docParse.createElement("alumne");
        alumne.setAttribute("codi_alumne", codigo);
        alumnes.appendChild(alumne);

        // Se crean los elementos que forman el alumno
        Element nombre = docParse.createElement("nom_alumne");
        Element curso = docParse.createElement("curs");
        Element año = docParse.createElement("any_naixement");
        Element colegio = docParse.createElement("colegi");

        // Se introduze la informacion proporcionada por el usuario
        nombre.setTextContent(nom_alumne);
        curso.setTextContent(curs);
        año.setTextContent(any_naixement);
        colegio.setTextContent(colegi);

        alumne.appendChild(nombre);
        alumne.appendChild(curso);
        alumne.appendChild(año);
        alumne.appendChild(colegio);

        // Se añade el nuevo registro al archivo XML
        this.añadirRegistros(docParse);
        
    }

    public void mostrarDocumento() throws SAXException, IOException, XPathExpressionException{
        Document docParse = docBuilder.parse("alumnos.xml");
        NodeList nodos = (NodeList) xpath.evaluate("//alumne", docParse, XPathConstants.NODESET);

        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("----------------------------");
            System.out.println("\n" + nodos.item(i).getNodeName() + i + "\n");
            NodeList atributos = nodos.item(i).getChildNodes();
            for (int j = 0; j < nodos.item(i).getChildNodes().getLength(); j++) {
                System.out.println(atributos.item(j).getTextContent());
            }
        System.out.println("----------------------------");
        }
    }

    public void modificarAlumno(String id, String campo, String valor) throws SAXException, IOException, TransformerException{
        Document docParse = docBuilder.parse("alumnos.xml");
        Node alumnes = docParse.getFirstChild();

        NodeList nodes = alumnes.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getAttributes().getNamedItem("codi_alumne").getTextContent().equals(id)){
                NodeList campos = nodes.item(i).getChildNodes();
                for (int j = 0; j < campos.getLength(); j++) {;
                    System.out.println(campos.item(j).getTextContent());
                    if (campos.item(j).getNodeName().equals(campo)){
                        campos.item(j).setTextContent(valor);
                    }
                    
                }
            }
        }
        this.añadirRegistros(docParse);
    }

    public void eliminarAlumno(String id) throws SAXException, IOException, TransformerException{
        Document docParse = docBuilder.parse("alumnos.xml");
        Node alumnes = docParse.getFirstChild();
        NodeList nodes = alumnes.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getAttributes().getNamedItem("codi_alumne").getTextContent().equals(id)){
                alumnes.removeChild(nodes.item(i));
            }
        }
        this.añadirRegistros(docParse);
    }
}
