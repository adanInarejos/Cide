
import java.io.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM2{

    // Atributos para el DOM.
    static File xml = new File("clientes.dat");
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    Node clientes;


    /* En el constructor se instancian las distintas clases necesarias para el dom,
    se crea el nuevo documento y se crea el elemto raiz del documento xml*/
    public DOM2() throws ParserConfigurationException, SAXException, IOException{
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            clientes = doc.createElement("clientes");
            doc.appendChild(clientes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }


    // Se instancias objetos clientes y se escriben en el fichero clientes.dat.
    private void crearClientes() throws IOException {
        Cliente cl1 = new Cliente("Manolo", 13);
        Cliente cl2 = new Cliente("Carlos", 23);
        Cliente cl3 = new Cliente("Pepe", 56);
        Cliente cl4 = new Cliente("Lola", 66);
        Cliente cl5 = new Cliente("Sara", 24);

        ObjectOutputStream Os = new ObjectOutputStream(new FileOutputStream("clientes.dat"));

        Os.writeObject(cl1);
        Os.writeObject(cl2);
        Os.writeObject(cl3);
        Os.writeObject(cl4);
        Os.writeObject(cl5);

        
        Os.close();
        
    }


    /* Se leen los objetos clientes de clientes.dat, con los objetos
     obtenidos se crean los elementos del XML*/
    private void formarxml() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream os = new ObjectInputStream(new FileInputStream("clientes.dat"));
        Cliente cl1 = (Cliente) os.readObject();
        Cliente cl2 = (Cliente) os.readObject();
        Cliente cl3 = (Cliente) os.readObject();
        Cliente cl4 = (Cliente) os.readObject();
        Cliente cl5 = (Cliente) os.readObject();
        os.close();

        Element cliente1 = doc.createElement("cliente");
        clientes.appendChild(cliente1);
        Element nombreC1 = doc.createElement("Nombre");
        nombreC1.setTextContent(cl1.getNombre());
        Element edadC1 = doc.createElement("edad");
        edadC1.setTextContent(String.valueOf(cl1.getEdad()));

        Element cliente2 = doc.createElement("cliente");
        clientes.appendChild(cliente2);
        Element nombreC2 = doc.createElement("Nombre");
        nombreC2.setTextContent(cl2.getNombre());
        Element edadC2 = doc.createElement("edad");
        edadC2.setTextContent(String.valueOf(cl2.getEdad()));

        Element cliente3 = doc.createElement("cliente");
        clientes.appendChild(cliente3);
        Element nombreC3= doc.createElement("Nombre");
        nombreC3.setTextContent(cl3.getNombre());
        Element edadC3 = doc.createElement("edad");
        edadC3.setTextContent(String.valueOf(cl3.getEdad()));

        Element cliente4 = doc.createElement("cliente");
        clientes.appendChild(cliente4);
        Element nombreC4 = doc.createElement("Nombre");
        nombreC4.setTextContent(cl4.getNombre());
        Element edadC4 = doc.createElement("edad");
        edadC4.setTextContent(String.valueOf(cl4.getEdad()));

        Element cliente5 = doc.createElement("cliente");
        clientes.appendChild(cliente5);
        Element nombreC5 = doc.createElement("Nombre");
        nombreC5.setTextContent(cl5.getNombre());
        Element edadC5 = doc.createElement("edad");
        edadC5.setTextContent(String.valueOf(cl5.getEdad()));

        cliente1.appendChild(nombreC1);
        cliente1.appendChild(edadC1);

        cliente2.appendChild(nombreC2);
        cliente2.appendChild(edadC2);

        cliente3.appendChild(nombreC3);
        cliente3.appendChild(edadC3);

        cliente4.appendChild(nombreC4);
        cliente4.appendChild(edadC4);

        cliente5.appendChild(nombreC5);
        cliente5.appendChild(edadC5);
    }

    // Transformacion a documento xml.
    private void crearDocumentoXML() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult consoleResult = new StreamResult("clientes.xml");
        transformer.transform(source, consoleResult);
    }

    /* Se lee el documento xml formado anteriormente y se muestran los nombres
     y edades de los distintos clientes. */
    public void mostrarClientes() throws ParserConfigurationException, SAXException, IOException{

        DocumentBuilderFactory docFactory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder2 = docFactory2.newDocumentBuilder();
        Document doc2 = docBuilder.parse("clientes.xml");

        Node raiz = doc2.getFirstChild();
        NodeList listaClientes = raiz.getChildNodes();

        for (int i = 0; i < listaClientes.getLength(); i++) {

            NodeList listaAtributos = listaClientes.item(i).getChildNodes();
            for (int j = 0; j < listaAtributos.getLength(); j++) {
                System.out.println(listaAtributos.item(j).getNodeName() + " > " + listaAtributos.item(j).getTextContent());
            }
        }
    }

    // Se ejectuan los distintos metodos.
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException, ClassNotFoundException {
        DOM2 dom = new DOM2();
        dom.crearClientes();
        dom.formarxml();
        dom.crearDocumentoXML();
        dom.mostrarClientes();
    }

}