public class EcuacionCuadratica {

    // Metodo complementario: solo calcula el determinante (discriminante)
    public static double determinante(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    // Metodo principal: recibe a, b, c e imprime las raices
    public static void calcularRaices(double a, double b, double c) {
        double d = determinante(a, b, c);

        System.out.println("Ecuacion: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Determinante: " + d);

        if (d > 0) {
            // Raices reales y distintas
            double raiz1 = (-b + Math.sqrt(d)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Raices reales y distintas:");
            System.out.println("x1 = " + raiz1);
            System.out.println("x2 = " + raiz2);

        } else if (d == 0) {
            // Raiz real doble (una sola solucion)
            double raiz = -b / (2 * a);
            System.out.println("Raiz real doble:");
            System.out.println("x = " + raiz);

        } else {
            // Raices complejas (numero imaginario)
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-d) / (2 * a);
            System.out.println("Raices complejas:");
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Pruebas con las ecuaciones del ejercicio
        calcularRaices(16, 0, 9);
        calcularRaices(1, -2, 5);
        calcularRaices(4, -4, 7);
    }
}
