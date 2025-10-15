import java.util.Scanner;

/**
 * Funciones para pedir datos por teclado.
 *
 * @author Alejandro Vivas Lopez
 */
public final class Teclado {

    private Teclado() {}

    /**
     * Pide por teclado un numero sin decimales y vuelve a pedirlo hasta que se introduzca uno valido.
     *
     * @param mensaje Mensaje a mostrar al pedir el numero. Por defecto es "Introduce un numero sin decimales:".
     * @param valorMin Valor minimo que se debe introducir.
     * @param valorMax Valor maximo que se puede introducir.
     * @return El numero sin decimales introducido.
     */
    public static int introducirInt(String mensaje, int valorMin, int valorMax) {
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        boolean declarado;
        if (mensaje.equals("")) {
            System.out.println("Introduce un numero sin decimales: ");
        } else {
            System.out.println(mensaje);
        }
        do {
            declarado = false;
            if (teclado.hasNextInt()) {
                numero = teclado.nextInt();
                if (numero >= valorMin) {
                    if (numero <= valorMax) {
                        declarado = true;
                    } else {
                        System.err.println("Error, el numero no puede ser mayor que " + valorMax + ": ");
                    }
                } else {
                    System.err.println("Error, el numero no puede ser menor que " + valorMin + ": ");
                }
            } else {
                teclado.next();
                System.err.println("Error, introduce un numero sin decimales valido: ");
            }
        } while (!declarado);
        return numero;
    }

    /**
     * Pide por teclado un numero y vuelve a pedirlo hasta que se introduzca uno valido.
     *
     * @param mensaje Mensaje a mostrar al pedir el numero. Por defecto es "Introduce un numero:".
     * @param valorMin Valor minimo que se debe introducir.
     * @param valorMax Valor maximo que se puede introducir.
     * @return El numero introducido.
     */
    public static double introducirDouble(String mensaje, double valorMin, double valorMax) {
        Scanner teclado = new Scanner(System.in);
        double numero = 0;
        boolean declarado;
        if (mensaje.equals("")) {
            System.out.println("Introduce un numero: ");
        } else {
            System.out.println(mensaje);
        }
        do {
            declarado = false;
            if (teclado.hasNextDouble()) {
                numero = teclado.nextDouble();
                if (numero >= valorMin) {
                    if (numero <= valorMax) {
                        declarado = true;
                    } else {
                        System.err.println("Error, el numero no puede ser mayor que " + valorMax + ": ");
                    }
                } else {
                    System.err.println("Error, el numero no puede ser menor que " + valorMin + ": ");
                }
            } else {
                teclado.next();
                System.err.println("Error, introduce un numero valido: ");
            }
        } while (!declarado);
        return numero;
    }

    /**
     * Pide por teclado un texto y vuelve a pedirlo hasta que se introduzca uno valido.
     *
     * @param mensaje Mensaje a mostrar al pedir el texto. Por defecto es "Introduce un texto:".
     * @param puedeVacio True si el texto introducido puede ser vacio y False si debe tener al menos un caracter.
     * @return El texto introducido.
     */
    public static String introducirTexto(String mensaje, boolean puedeVacio) {
        Scanner teclado = new Scanner(System.in);
        String texto = "";
        boolean declarado;
        if (mensaje.equals("")) {
            System.out.println("Introduce un texto: ");
        } else {
            System.out.println(mensaje);
        }
        do {
            declarado = false;
            texto = teclado.nextLine();
            if (!texto.equals("") || puedeVacio) {
                declarado = true;
            } else {
                System.err.println("Error, no puede dejar en blanco este campo: ");
            }
        } while (!declarado);
        return texto;
    }

}
