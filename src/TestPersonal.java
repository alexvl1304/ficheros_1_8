
void main() {

    Personal personal = new Personal();
    String fichero;

    System.out.println("\nNo hay ninguna lista de personal cargada:\n-------------");
    do {
        personal.clear();
        fichero = Teclado.introducirTexto("Introduce el nombre del fichero que desea cargar:", false);
    } while (!anadirPersonasAPersonal(personal, fichero));


    //menu principal de la aplicacion
    while (menu(personal)) ;

    boolean guardado;
    switch (Teclado.introducirInt("¿En que formato desea guardar el fichero?\n1. CSV\n2. XML\n3. JSON", 1, 3)){

        case 1: guardado = Auxiliar.writeCSVPersonas(personal.getListaPersonas());

        case 2: guardado = Auxiliar.writeXMLPersonas(personal.getListaPersonas());

        case 3: //guardado = Auxiliar.writeJSONPersonas(personal.getListaPersonas());

        default: guardado = false;
    }

    if (!guardado) {
        System.out.println("Ha ocurrido un error al guardar...\nEl archivo .CSV puede no haberse guardado o estar incompleto.");
    }
}

boolean menu(Personal personal) {

    boolean continuar = true;

    System.out.println("\nMENU DEL PERSONAL\n-------------");
    System.out.println("0. Salir de la aplicacion\n1. Mostrar personas por pais\n2. Borrar persona por su email\n");

    switch (Teclado.introducirInt("Seleccione una opcion: ", 0, 2)) {
        case 1:

            String pais = Teclado.introducirTexto("Introduce el pais por el que buscar:", false);
            ArrayList<Persona> lista = personal.personasPorPais(pais);

            if (lista.isEmpty()) {
                System.out.println("No hay ninguna persona con ese pais...");
            } else {

                System.out.println("Se encontraron un total de " + lista.size() + " personas:");
                for (Persona persona : lista) {

                    System.out.println(persona);
                }
            }

            break;
        case 2:

            String email = Teclado.introducirTexto("Introduce el email de la persona a eliminar de la lista:", false);

            System.out.println(personal.borrarPorEmail(email) ? "Se ha eliminado a la persona con email : " + email : "No existe ninguna persona con ese email...");

            break;

        default:
            continuar = false;
    }

    return continuar;
}

boolean anadirPersonasAPersonal(Personal personal, String fichero) {

    if (fichero.endsWith(".csv")) {

        return personal.anadirPersonasDesdeCSV(fichero);
    } else if (fichero.endsWith(".xml")) {

        return personal.anadirPersonasDesdeXML(fichero);
    } else if (fichero.endsWith(".json")) {

        return personal.anadirPersonasDesdeJSON(fichero);
    }

    return false;
}