import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class Main {

    final static Scanner sc = new Scanner(System.in);

    XmlManager xmlManager;

    // Constructor
    public Main() throws ParserConfigurationException{
       xmlManager = new XmlManager();
    }

    // Metodo que genera un menu que permite al usuario elegir que accion quiere realizar
    public void menu() throws TransformerException, ParserConfigurationException, SAXException, IOException, XPathExpressionException{

        // Se muestra al usuario las distiantas acciones que puede realizar
        System.out.println("Elige opcion:\n1 - Crear fichero XML\n2 - Introducir datos en el fichero XML\n3 - Mostrar el contenido del fichero XML\n4 - Modificar datos\n5 - Consultas\n6 - Eliminar un registro\n0 - Salir\n--------------------------");
        int opcion = sc.nextInt();

        // Dependiendo de la accion el porgrama lanzara unos metodos u otros
        switch (opcion){
            // Creacion del documento
            case 1:
                xmlManager.crearDocumento();
                menu();
                break;
            case 2:
                menuRegistarAlumnos();
                menu();
                break;
            case 3:
                xmlManager.mostrarDocumento();
                menu();
                break;
            case 4:
                //Codigo
                break;
            case 5:
                //Codigo
                break;
            case 6:
                //Codigo
                break;
            case 0:
                return;
            default:
                System.out.println("-----------\nError - Elija una opcion valida\n-----------");   
                menu();
        }


    }

    // Este metodo pedira al usuario que instroduzca los datos necesarios para crear un nuevo alumno
    public void menuRegistarAlumnos() throws TransformerException, SAXException, IOException {

        Scanner sc2 = new Scanner(System.in);

        // Se pide al usuario los datos del alumno
        System.out.println("- Introduzca el codigo del alumno:");
        String codigo = sc2.nextLine();
        System.out.println("- Introduzca el nombre del alumno:");
        String nombre = sc2.nextLine();
        System.out.println("- Introduzca el curso del alumno:");
        String curso = sc2.nextLine();
        System.out.println("- Introduzca el año de nacimiento del alumno:");
        String año = sc2.nextLine();
        System.out.println("- Introduzca el colegio del alumno:");
        String colegio = sc2.nextLine();

        // Con los datos introducidos por el usuario se lanza el metodo para registrarlo en el XML
        xmlManager.registarAlumno(codigo, nombre, curso, año, colegio);
    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException, XPathExpressionException {
        Main hola = new Main();
        hola.menu();
    }
}
