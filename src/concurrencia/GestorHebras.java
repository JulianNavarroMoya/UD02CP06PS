package concurrencia;

import modelo.MemoriaFibonacci;

public class GestorHebras {
    private final MemoriaFibonacci memoria;
    private final Thread[] hebras;

    public GestorHebras(MemoriaFibonacci memoria) {
        this.memoria = memoria;
        this.hebras = new Thread[memoria.getTamano() + 1];
    }

    public void ejecutarCalculo() {
        int n = memoria.getTamano();

        // Creación y arranque de hebras
        for (int i = 2; i <= n; i++) {
            Runnable tarea = new TareaFibonacci(i, memoria);
            hebras[i] = new Thread(tarea, "Hebra-" + i);
            hebras[i].start();
        }

        // Sincronización: Esperamos a que termine la última hebra
        try {
            if (n >= 2 && hebras[n] != null) {
                hebras[n].join();
            }
        } catch (InterruptedException e) {
            System.out.println("El cálculo fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
