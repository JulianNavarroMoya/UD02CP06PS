package modelo;

public interface MemoriaFibonacci {

    boolean estaCalculado(int indice);
    int getValor(int indice);
    void setValor(int indice, int valor);
    int getTamano();
}