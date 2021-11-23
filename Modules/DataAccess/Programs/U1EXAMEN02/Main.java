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
                xmlManager.consultasXPath("//alumne");
                menu();
                break;
            case 4:
                menuModificarAlumno();
                menu();
                break;
            case 5:
                menuConsultes();
                menu();
                break;
            case 6:
                Scanner sc4 = new Scanner(System.in);
                System.out.println("Introduzca el codigo del alumno que desea eliminar");
                String id = sc4.nextLine();
                xmlManager.eliminarAlumno(id);
                menu();
                break;
            case 0:
                break;
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

    public void menuModificarAlumno() throws SAXException, IOException, TransformerException{

        Scanner sc3 = new Scanner(System.in);

        System.out.println("Introduzca el codigo del alumno que desea modificar");
        String id = sc3.nextLine();

        System.out.println("Introduzca el campo del alumno que desea modificar");
        String campo = sc3.nextLine();

        System.out.println("Introduzca el valor que desa introducir");
        String valor = sc3.nextLine();

        xmlManager.modificarAlumno(id, campo ,valor);
    }

    public void menuConsultes() throws XPathExpressionException, SAXException, IOException, TransformerException, ParserConfigurationException{

        Scanner sc5 = new Scanner(System.in);


        System.out.println("Elige opcion:\n1 - Consultar todos los nombres de los alumnos\n2 - Consultar los alumnos que vayan al colegio Cide\n3 - Consultar el nombre de almuno con codigo 3\n4 - Consultar los alumnos nacidos antes de 1990\n0 - Salir\n--------------------------");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                xmlManager.consultasXPath("//nom_alumne");
                menuConsultes();
                break;
            case 2:
                xmlManager.consultasXPath("//alumne[colegi='cide']");
                menuConsultes();
                break;
            case 3:
                xmlManager.consultasXPath("//alumne[@codi_alumne='3']");
                menuConsultes();
                break;
            case 4:
                xmlManager.consultasXPath("//alumne[any_naixement<1990]");
                menuConsultes();
                break;
            case 0:
                menu();
                break;
            default:
                System.out.println("-----------\nError - Elija una opcion valida\n-----------");  
                menuConsultes();
                break;
        }



    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException, XPathExpressionException {
        Main hola = new Main();
        hola.menu();
    }
}
