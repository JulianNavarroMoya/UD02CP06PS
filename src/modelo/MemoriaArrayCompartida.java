package modelo;

public class MemoriaArrayCompartida implements MemoriaFibonacci {
    private final int[] fibonacci;

    public MemoriaArrayCompartida(int n) {
        this.fibonacci = new int[n + 1];
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
    public boolean estaCalculado(int indice) {
        return fibonacci[indice] != -1;
    }

    @Override
    public int getValor(int indice) {
        return fibonacci[indice];
    }

    @Override
    public void setValor(int indice, int valor) {
        fibonacci[indice] = valor;
    }

    @Override
    public int getTamano() {
        return fibonacci.length - 1;
    }
}
