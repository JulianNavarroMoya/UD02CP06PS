package concurrencia;

import modelo.MemoriaFibonacci;

public class TareaFibonacci implements Runnable {
    private final int i;
    private final MemoriaFibonacci memoria;

    public TareaFibonacci(int i, MemoriaFibonacci memoria) {
        this.i = i;
        this.memoria = memoria;
    }

    @Override
    public void run() {
        // ESPERA ACTIVA
        while (!memoria.estaCalculado(i - 1) || !memoria.estaCalculado(i - 2)) {
            Thread.yield(); // Cede la CPU temporalmente mientras espera
        }

        // Cálculo y almacenamiento
        int resultado = memoria.getValor(i - 1) + memoria.getValor(i - 2);
        memoria.setValor(i, resultado);

        System.out.println("Fibonacci " + i + ": " + resultado);
    }
}