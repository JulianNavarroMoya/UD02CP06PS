package modelo;

public class MemoriaArrayCompartida implements MemoriaFibonacci {
    private final long[] fibonacci;
    private int turno = 2;

    public MemoriaArrayCompartida(int n) {
        this.fibonacci = new long[n + 1];
        inicializarMemoria();
    }

    private void inicializarMemoria() {
        for (int i = 0; i < fibonacci.length; i++) {
            fibonacci[i] = -1; // -1 indica que no está calculado
        }
        // Casos base (especiales)
        if (fibonacci.length > 0) fibonacci[0] = 0;
        if (fibonacci.length > 1) fibonacci[1] = 1;
    }

    @Override
    public synchronized boolean estaCalculado(int indice) {
        return fibonacci[indice] != -1;
    }

    @Override
    public synchronized long getValor(int indice) {
        return fibonacci[indice];
    }

    @Override
    public synchronized void setValor(int indice, long valor) {
        fibonacci[indice] = valor;
    }

    @Override
    public int getTamano() {
        return fibonacci.length - 1;
    }

// dos metodos añadidos de la MemoriaFibonacci

    @Override
    public synchronized int getTurno() {
        return turno;
    }

    @Override
    public synchronized void siguienteTurno() {
        turno++;
    }
}
