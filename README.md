# Semana 17 - Programación III

Ejemplos de programación concurrente, interfaces gráficas con Swing y servidor web básico en Java.

## Estructura

- `hilos/`
  - Creación y ejecución de hilos.
  - Uso de `start()`, `run()` y `join()`.
  - Ejecución paralela y medición de tiempos.

- `swing/`
  - Ventana congelada por trabajo en el hilo principal.
  - Ventana fluida usando `SwingWorker`.

- `web/`
  - Clase `Socio`.
  - Repositorio de socios.
  - Excepciones personalizadas.
  - Servidor HTTP con `HttpServer`.

- `ejercicios/`
  - Cuenta regresiva con hilos.
  - Servidor total usando `AtomicInteger`.

## Compilación

Entrar a la carpeta del ejemplo y ejecutar:

```bash
javac *.java
java NombreDeLaClase
