public class CuentaRegresiva implements Runnable {
    private final int inicio;

    public CuentaRegresiva(int inicio) { this.inicio = inicio; }

    @Override public void run() {
        for (int i = inicio; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
        }
        System.out.println("Despegue!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(new CuentaRegresiva(5), "CuentaRegresiva");
        hilo.start();
        hilo.join();
    }
}
