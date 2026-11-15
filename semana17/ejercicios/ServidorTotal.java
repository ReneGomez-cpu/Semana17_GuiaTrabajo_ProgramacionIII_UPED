import java.util.concurrent.atomic.AtomicInteger;

public class ServidorTotal {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger total = new AtomicInteger();
        Thread[] servidores = new Thread[3];
        for (int i = 0; i < servidores.length; i++) {
            final int servidor = i + 1;
            servidores[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) total.incrementAndGet();
                System.out.println("Servidor " + servidor + " termino.");
            });
            servidores[i].start();
        }
        for (Thread servidor : servidores) servidor.join();
        System.out.println("Total procesado: " + total.get());
    }
}
