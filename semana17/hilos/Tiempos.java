public class Tiempos {
    public static void main(String[] args) throws InterruptedException {
        long inicio = System.nanoTime();
        Thread t1 = new Thread(() -> trabajo("A"));
        Thread t2 = new Thread(() -> trabajo("B"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long fin = System.nanoTime();
        System.out.printf("Tiempo total: %.3f segundos%n", (fin - inicio) / 1_000_000_000.0);
    }

    private static void trabajo(String nombre) {
        long total = 0;
        for (int i = 0; i < 2_000_000; i++) total += i;
        System.out.println("Trabajo " + nombre + ": " + total);
    }
}
