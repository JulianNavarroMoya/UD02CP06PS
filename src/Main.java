import concurrencia.GestorHebras;
import consola.ConsolaUI;
import modelo.MemoriaArrayCompartida;
import modelo.MemoriaFibonacci;

public class Main {
    public static void main(String[] args) {
        ConsolaUI ui = new ConsolaUI();

        int n = ui.solicitarNumero();

        if (n < 2) {
            ui.mostrarMensaje("Por favor, introduce un número mayor o igual a 2.");
            ui.cerrar();
            return;
        }

        // Composición de dependencias (Dependency Injection manual)
        MemoriaFibonacci memoria = new MemoriaArrayCompartida(n);
        GestorHebras gestor = new GestorHebras(memoria);

        // Ejecución
        gestor.ejecutarCalculo();

        // Salida de resultados
        int resultadoFinal = memoria.getValor(n);
        ui.mostrarResultadoFinal(n, resultadoFinal);

        ui.cerrar();
    }
}