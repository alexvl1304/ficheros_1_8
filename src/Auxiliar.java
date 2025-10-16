import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public final class Auxiliar {

    private Auxiliar() {}

    public static ArrayList<Persona> readPersonasCSV(Path path){

        ArrayList<Persona> personas = new ArrayList<>();

        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(path.toString())))) {

            sc.nextLine();
            String line = "";

            while (sc.hasNextLine() && !(line = sc.nextLine()).isBlank() ) {

                String[] elementos = line.split(",");

                String firstName = elementos[0];
                String lastName = elementos[1];
                String email = elementos[2];
                String gender = elementos[3];
                String country = elementos[4];

                personas.add(new Persona(firstName, lastName, email, gender, country));
            }

            return personas;

        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static boolean writeCSVPersonas(ArrayList<Persona> personas){

        boolean resultado = false;
        Date d = new Date();
        String nombreFichero = "personal_" + (1900 + d.getYear()) + "-" + (1 + d.getMonth()) + "-" + d.getDate() + "_" + d.getHours() + "-" + d.getMinutes() + "-" + d.getSeconds() + ".csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))){

            bw.write("firstName,lastName,email,gender,country");
            bw.newLine();

            for (Persona persona : personas) {

                bw.write(persona.toString());
                bw.newLine();
            }
            resultado = true;

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    public static ArrayList<Persona> readPersonasXML(Path path){

        ArrayList<Persona> personas = new ArrayList<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(path.toFile());
            doc.getDocumentElement().normalize();

            //System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            NodeList lista = doc.getElementsByTagName("persona");

            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    String firstName = elemento.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = elemento.getElementsByTagName("lastName").item(0).getTextContent();
                    String email = elemento.getElementsByTagName("email").item(0).getTextContent();
                    String gender = elemento.getElementsByTagName("gender").item(0).getTextContent();
                    String country = elemento.getElementsByTagName("country").item(0).getTextContent();

                    personas.add(new Persona(firstName, lastName, email, gender, country));
                }
            }

            return personas;

        }catch(Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static boolean writeXMLPersonas(ArrayList<Persona> personas){

        boolean resultado = false;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("personal");
            doc.appendChild(rootElement);

            for(Persona p : personas) {

                Element persona = doc.createElement("persona");
                rootElement.appendChild(persona);

                Element e;
                e = doc.createElement("firstName");
                e.appendChild(doc.createTextNode(p.getFirstName()));
                persona.appendChild(e);

                e = doc.createElement("lastName");
                e.appendChild(doc.createTextNode(p.getLastName()));
                persona.appendChild(e);

                e = doc.createElement("email");
                e.appendChild(doc.createTextNode(p.getEmail()));
                persona.appendChild(e);

                e = doc.createElement("gender");
                e.appendChild(doc.createTextNode(p.getGender()));
                persona.appendChild(e);

                e = doc.createElement("country");
                e.appendChild(doc.createTextNode(p.getCountry()));
                persona.appendChild(e);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Date d = new Date();
            String nombreFichero = "personal_" + (1900 + d.getYear()) + "-" + (1 + d.getMonth()) + "-" + d.getDate() + "_" + d.getHours() + "-" + d.getMinutes() + "-" + d.getSeconds() + ".xml";

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreFichero));

            transformer.transform(source, result);

            resultado = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public static ArrayList<Persona> readPersonasJSON(Path path){

        ArrayList<Persona> personas = new ArrayList<>();

        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(path.toString())))) {

            sc.nextLine();
            String line = "";

            while (sc.hasNextLine() && !(line = sc.nextLine()).isBlank() ) {

                String[] elementos = line.split(",");

                String firstName = elementos[0];
                String lastName = elementos[1];
                String email = elementos[2];
                String gender = elementos[3];
                String country = elementos[4];

                personas.add(new Persona(firstName, lastName, email, gender, country));
            }

            return personas;

        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }
}
