import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca {

    // Campo estatico: la coleccion de libros (ISBN -> Titulo)
    private static HashMap<String, String> libros = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    buscarLibro();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Volviendo al menu principal.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== BIBLIOTECA =====");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Actualizar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Finalizar");
        System.out.print("Elija una opcion: ");
    }

    // Lee la opcion del menu, con maximo 3 intentos
    private static int leerOpcionValida() {
        int intentos = 0;
        while (intentos < 3) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                // no era un numero, cuenta como intento fallido
            }
            intentos++;
            System.out.println("Opcion invalida. Intento " + intentos + " de 3.");
        }
        System.out.println("Supero el numero de intentos.");
        return -1; // opcion invalida, el switch la ignora y vuelve al menu
    }

    // ---- ACCION 1: CREATE ----
    private static void agregarLibro() {
        String isbn = leerISBNValido();
        if (isbn == null) return; // se cancelo, vuelve al menu

        if (libros.containsKey(isbn)) {
            System.out.println("Ya existe un libro registrado con ese ISBN.");
            return;
        }

        String titulo = leerTituloValido();
        if (titulo == null) return;

        libros.put(isbn, titulo);
        System.out.println("Libro agregado correctamente.");
    }

    // ---- ACCION 2: READ ----
    private static void buscarLibro() {
        String isbn = leerISBNValido();
        if (isbn == null) return;

        if (libros.containsKey(isbn)) {
            System.out.println("Titulo encontrado: " + libros.get(isbn));
        } else {
            System.out.println("No existe ningun libro con ese ISBN.");
        }
    }

    // ---- ACCION 3: UPDATE ----
    private static void actualizarLibro() {
        String isbn = leerISBNValido();
        if (isbn == null) return;

        if (!libros.containsKey(isbn)) {
            System.out.println("No existe ningun libro con ese ISBN.");
            return;
        }

        String nuevoTitulo = leerTituloValido();
        if (nuevoTitulo == null) return;

        libros.put(isbn, nuevoTitulo);
        System.out.println("Libro actualizado correctamente.");
    }

    // ---- ACCION 4: DELETE ----
    private static void eliminarLibro() {
        String isbn = leerISBNValido();
        if (isbn == null) return;

        if (libros.containsKey(isbn)) {
            libros.remove(isbn);
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No existe ningun libro con ese ISBN.");
        }
    }

    // Valida el ISBN con expresion regular (formato ISBN-13: empieza en 978 o 979 + 10 digitos)
    private static String leerISBNValido() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Ingrese el ISBN (formato: 978XXXXXXXXXX): ");
            String isbn = scanner.nextLine();
            if (isbn.matches("^(978|979)\\d{10}$")) {
                return isbn;
            }
            intentos++;
            System.out.println("ISBN invalido. Intento " + intentos + " de 3.");
        }
        System.out.println("Supero el numero de intentos. Operacion cancelada.");
        return null;
    }

    // Valida que el titulo no venga vacio
    private static String leerTituloValido() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Ingrese el titulo del libro: ");
            String titulo = scanner.nextLine();
            if (titulo != null && !titulo.trim().isEmpty()) {
                return titulo;
            }
            intentos++;
            System.out.println("Titulo invalido (no puede estar vacio). Intento " + intentos + " de 3.");
        }
        System.out.println("Supero el numero de intentos. Operacion cancelada.");
        return null;
    }
}
