public class HiloCajero implements Runnable {
    private final String nombre;
    private final int clientes;

    public HiloCajero(String nombre, int clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    @Override
    public void run() {
        for (int i = 1; i <= clientes; i++) {
            System.out.printf("%s atendiendo al cliente %d%n", nombre, i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpido.");
                return;
            }
        }
        System.out.println(nombre + " termino su jornada.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread cajero1 = new Thread(new HiloCajero("Cajero 1", 4));
        Thread cajero2 = new Thread(new HiloCajero("Cajero 2", 4));
        cajero1.start();
        cajero2.start();
        cajero1.join();
        cajero2.join();
        System.out.println("Todos los cajeros terminaron.");
    }
}
