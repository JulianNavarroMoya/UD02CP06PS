package consola;

import java.util.Scanner;

public class ConsolaUI {
    private final Scanner scanner;

    public ConsolaUI() {
        this.scanner = new Scanner(System.in);
    }

    public int solicitarNumero() {
        System.out.print("Número de Fibonacci a calcular: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarResultadoFinal(int n, long resultado) {
        System.out.println("***************");
        System.out.println("FIBONACCI " + n + ": " + resultado);
    }

    public void cerrar() {
        scanner.close();
    }
}