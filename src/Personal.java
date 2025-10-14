import java.util.ArrayList;

public class Personal {

    ArrayList<Persona> listaPersonas;

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
}
