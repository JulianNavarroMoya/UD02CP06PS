package modelo;

public interface MemoriaFibonacci {

    boolean estaCalculado(int indice);
    long getValor(int indice);
    void setValor(int indice, long valor);
    int getTamano();

    // metodo añadido para coordinar la salida en consola //

    int getTurno();
    void siguienteTurno();
}