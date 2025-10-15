import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
            e.printStackTrace();

            return null;
        }
    }

    public boolean writeCSVPersonas(ArrayList<Persona> personas){

        boolean resultado = false;
        Date d = new Date();
        String nombreFichero = "personal_" + d.getYear() + "-" + d.getMonth() + "-" + d.getDay() + "_" + d.getHours() + "-" + d.getMinutes() + "-" + d.getSeconds() + ".csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))){

            bw.write("firstName,lastName,email,gender,country");

            for (Persona persona : personas) {

                bw.write(persona.toString());
            }
            resultado = true;

        }catch(IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
