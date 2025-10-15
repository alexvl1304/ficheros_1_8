
void main() {

    Personal personal = new Personal();
    String fichero;

    System.out.println("\nNo hay ninguna lista de personal cargada:\n-------------");
    do{
        personal.clear();
        fichero = Teclado.introducirTexto("Introduce el nombre del fichero que desea cargar:", false);
    }while(!personal.anadirPersonasDesdeCSV(fichero));


    //menu principal de la aplicacion
    while(menu(personal));


    Auxiliar.writeCSVPersonas(personal.getListaPersonas());
}

boolean menu(Personal personal) {

    int opcion= 0;
    boolean continuar = false;

    System.out.println("\nMENU DEL PERSONAL\n-------------");
    System.out.println("0. Salir de la aplicacion\n1. Mostrar personas por pais\n2. Borrar persona por su email\n");

    opcion = Teclado.introducirInt("Seleccione una opcion: ", 0, 2);

    switch(opcion){
        case 1:

            String pais = Teclado.introducirTexto("Introduce el pais por el que buscar:", false);
            ArrayList<Persona> lista = personal.personasPorPais(pais);

            if(lista.isEmpty()) {
                System.out.printf("No hay ninguna persona con ese pais...");
            }else{

                System.out.println("Se encontraron un total de " + lista.size() + " personas:");
                for(Persona persona : lista){

                    System.out.println(persona);
                }
            }

            continuar = true;
            break;
        case 2:

            String email = Teclado.introducirTexto("Introduce el email de la persona a eliminar de la lista:", false);

            System.out.println(personal.borrarPorEmail(email)?"Se ha eliminado a la persona con email : " + email : "No existe ninguna persona con ese email...");;

            continuar = true;
            break;
    }

    return continuar;
}