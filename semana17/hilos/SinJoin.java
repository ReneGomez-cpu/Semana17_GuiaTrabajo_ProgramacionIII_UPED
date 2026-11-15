public class SinJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread tarea = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("La tarea termino.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        tarea.start();
        System.out.println("El hilo principal continua sin esperar.");
        Thread.sleep(100);
        System.out.println("El programa principal puede finalizar antes que la tarea.");
    }
}
