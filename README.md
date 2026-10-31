# Proyecto: Calculadora de Fibonacci Multihilo

Este proyecto es una solución en Java para el cálculo concurrente de la sucesión de Fibonacci utilizando múltiples hebras. Se ha diseñado respetando los principios de arquitectura SOLID.

## Arquitectura del Proyecto

El código está estructurado para evitar el acoplamiento y separar las responsabilidades:

*   **`consola`**: Contiene la clase `ConsolaUI`. Se encarga exclusivamente de la interacción con el usuario (entrada de datos y muestra de resultados).
*   **`modelo`**: Contiene la interfaz `MemoriaFibonacci` y su implementación `MemoriaArrayCompartido`. Define el contrato y la lógica de la memoria compartida, el almacenamiento de los términos de Fibonacci y el control del turno de impresión.
*   **`concurrencia`**: Contiene `TareaFibonacci` (lógica matemática y de espera activa de la hebra) y `GestorHebras` (orquestación, creación y sincronización de los hilos).
*   **`Main`**: Actúa como punto de entrada de la aplicación y se encarga de la Inyección de Dependencias (instanciar y conectar los componentes).

## Características Técnicas y Soluciones Aplicadas

1.  **Espera Activa Segura:**
    Las hebras utilizan "espera activa" para coordinarse. Se ha implementado un sistema con `Thread.sleep(1)` dentro de los bucles `while` para evitar que la CPU se sature al, dejando trabajar al planificador del sistema operativo.

2.  **Barreras de Memoria:**
    Para evitar que las hebras lean valores obsoletos desde la caché local de sus núcleos, se ha utilizado la palabra reservada `synchronized` en los métodos de la memoria compartida. Esto obliga a leer y escribir directamente en la memoria principal (RAM), garantizando que todos los hilos vean los cambios al instante.

3.  **Coordinación de Turnos:**
    Dado que el orden de ejecución de los hilos es impredecible, se implementó una segunda fase de espera activa mediante un sistema de **turnos** (`turno` iterativo).

4.  **Prevención de Desbordamiento:**
    El tipo primitivo `int` en Java solo permite calcular correctamente hasta el término 46 de Fibonacci. Para soportar números mayores, la memoria compartida y los cálculos internos utilizan el tipo `long` (enteros de 64 bits), permitiendo calcular correctamente hasta la posición 92 de la sucesión (Por desgracia a partir de ese número no funciona correctamente).

## Ejemplo de Salida (N = 10)

```text
Número de Fibonacci a calcular: 10
Fibonacci 2: 1
Fibonacci 3: 2
Fibonacci 4: 3
Fibonacci 5: 5
Fibonacci 6: 8
Fibonacci 7: 13
Fibonacci 8: 21
Fibonacci 9: 34
Fibonacci 10: 55
***************
FIBONACCI 10: 55