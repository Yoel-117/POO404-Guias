import java.util.Random;

public class Descuentos {

    public static void aplicarDescuento(String nombreCliente, double monto) {
        String[] colores = {"cafe", "roja", "azul", "verde"};
        Random random = new Random();
        String bolita = colores[random.nextInt(colores.length)];

        double porcentaje;
        switch (bolita) {
            case "cafe":
                porcentaje = 0.10;
                break;
            case "roja":
                porcentaje = 0.15;
                break;
            case "azul":
                porcentaje = 0.25;
                break;
            case "verde":
                porcentaje = 0.50;
                break;
            default:
                porcentaje = 0.0;
        }

        double descuento = monto * porcentaje;
        double totalPagar = monto - descuento;

        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Bolita generada: " + bolita);
        System.out.println("Descuento aplicado: " + (porcentaje * 100) + "%");
        System.out.println("Monto original: $" + monto);
        System.out.println("Total a pagar: $" + totalPagar);
        System.out.println();
    }

    public static void main(String[] args) {
        aplicarDescuento("Joel", 100.0);
        aplicarDescuento("Maria", 50.0);
        aplicarDescuento("Carlos", 200.0);
    }
}
