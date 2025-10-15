import java.nio.file.Path;
import java.util.ArrayList;


public class Personal {

    ArrayList<Persona> listaPersonas;

    /**
     * Constructor que inicializa la lista de Personas.
     */
    public Personal() {

        listaPersonas = new ArrayList();
    }

    /**
     * Getter de una copia de la lista del personal.
     * @return una copia de la lista de Personas
     */
    public ArrayList<Persona> getListaPersonas() {

        ArrayList<Persona> copia = new ArrayList();

        for (Persona p : listaPersonas) {
            copia.add(p);
        }

        return copia;
    }

    /**
     * Vacia por completo la lista del personal.
     */
    public void clear() {

        listaPersonas.clear();
    }

    /**
     * Añade una Persona a la lista.
     * @param persona
     */
    public void anadir(Persona persona) {

        listaPersonas.add(persona);
    }

    /**
     * Busca Personas que sean de un determinado pais.
     * @param pais
     * @return una lista con todas las Personas del pais pasado por parametro
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
     * @return si se ha eliminado a alguna Persona de la lista.
     */
    public boolean borrarPorEmail(String email) {

        boolean borrado = false;

        for (int i = 0; !borrado && i < listaPersonas.size(); i++) {

            if (listaPersonas.get(i).getEmail().equals(email)) {

                borrado = true;
                listaPersonas.remove(i);
            }
        }

        return borrado;
    }

    /**
     * Añade varias Personas a la lista desde un .CSV
     * @param csv ruta del fichero .CSV
     * @return si las Personas se añadieron con exito.
     */
    public boolean anadirPersonasDesdeCSV(String csv) {

        ArrayList<Persona> lista = Auxiliar.readPersonasCSV(Path.of(csv));

        if(lista == null) {return false;}

        for (Persona persona : lista) {

            listaPersonas.add(persona);
        }

        return true;
    }
}
