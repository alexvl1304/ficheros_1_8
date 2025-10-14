import java.util.ArrayList;

public class Personal {

    ArrayList<Persona> listaPersonas;

    public Personal() {

        listaPersonas = new ArrayList();
    }

    public void anadir(Persona persona) {

        listaPersonas.add(persona);
    }

    public ArrayList<Persona> personasPorPais(String pais) {

        ArrayList<Persona> lista = new ArrayList<>();

        for (Persona persona : listaPersonas) {

            if(persona.country.equals(pais)){
                lista.add(persona);
            }
        }

        return lista;
    }

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
