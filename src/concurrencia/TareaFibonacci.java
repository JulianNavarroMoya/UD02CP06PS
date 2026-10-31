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
        long resultado = memoria.getValor(i - 1) + memoria.getValor(i - 2);
        memoria.setValor(i, resultado);

        // Espera el turno e imprime
        while (memoria.getTurno() != i ){
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Fibonacci " + i + ": " + resultado);
        // Pasar el turno a la siguinete hebra
        memoria.siguienteTurno();
    }
}