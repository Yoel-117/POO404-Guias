public class Controlif {

    public static void ejemplo3() {

        int opcion = 3; // valor de ejemplo, puedes cambiarlo

        /*
        // ---- BLOQUE ORIGINAL CON IF (convertido en comentario, ejercicio 1) ----
        if (opcion == 1) {
            System.out.println("Opcion 1: Lunes");
        } else if (opcion == 2) {
            System.out.println("Opcion 2: Martes");
        } else if (opcion == 3) {
            System.out.println("Opcion 3: Miercoles");
        } else if (opcion == 4) {
            System.out.println("Opcion 4: Jueves");
        } else {
            System.out.println("Opcion invalida");
        }
        */

        // ---- MISMO COMPORTAMIENTO, PERO CON SWITCH ----
        switch (opcion) {
            case 1:
                System.out.println("Opcion 1: Lunes");
                break;
            case 2:
                System.out.println("Opcion 2: Martes");
                break;
            case 3:
                System.out.println("Opcion 3: Miercoles");
                break;
            case 4:
                System.out.println("Opcion 4: Jueves");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void main(String[] args) {
        ejemplo3();
    }
}
