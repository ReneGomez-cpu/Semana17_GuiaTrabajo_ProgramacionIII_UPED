public class StartVsRun {
    private static void pausa(String texto) {
        System.out.println(texto + " - hilo: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread tarea = new Thread(() -> pausa("Ejecutando con start"));
        tarea.start();
        tarea.join();

        // run() es una llamada normal y se ejecuta en el hilo actual.
        Thread otraTarea = new Thread(() -> pausa("Ejecutando con run"));
        otraTarea.run();
    }
}
