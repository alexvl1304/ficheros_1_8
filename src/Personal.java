import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Personal {

    ArrayList<Persona> listaPersonas;

    /**
     * Constructor que inicializa la lista de Personas.
     */
    public Personal() {

        listaPersonas = new ArrayList();
    }

    /**
     * Añade una Persona a la lista.
     * @param persona
     */
    public void anadir(Persona persona) {

        listaPersonas.add(persona);
    }

    /**
     * Busca Personas que vivan en un determinado pais.
     * @param pais
     * @return una lista con todas las Personas que viven en el pais pasado por parametro
     */
    public ArrayList<Persona> personasPorPais(String pais) {

        ArrayList<Persona> lista = new ArrayList<>();

        for (Persona persona : listaPersonas) {

            if(persona.country.equals(pais)){
                lista.add(persona);
            }
        }

        return lista;
    }

    /**
     * Borra a una Persona de la lista por su email
     * @param email
     */
    public void borrarPorEmail(String email) {

        boolean borrado = false;

        for (int i = 0; !borrado && i < listaPersonas.size(); i++) {

            if (listaPersonas.get(i).getEmail().equals(email)) {

                borrado = true;
                listaPersonas.remove(i);
            }
        }
    }

    public boolean anadirPersonasDesdeCSV(String csv) {

        boolean anadidas = false;

        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(csv)))) {

            sc.nextLine();
            String line = "";

            while (sc.hasNextLine() && !(line = sc.nextLine()).isBlank() ) {

                String[] elementos = line.split(",");

                String firstName = elementos[0];
                String lastName = elementos[1];
                String email = elementos[2];
                String gender = elementos[3];
                String country = elementos[4];

                listaPersonas.add(new Persona(firstName, lastName, email, gender, country));
            }
            anadidas = true;

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return anadidas;
    }
}
