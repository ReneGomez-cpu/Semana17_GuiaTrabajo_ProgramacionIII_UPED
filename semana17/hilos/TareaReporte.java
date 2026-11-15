public class TareaReporte extends Thread {
    private final String reporte;

    public TareaReporte(String reporte) {
        super("Reporte-" + reporte);
        this.reporte = reporte;
    }

    @Override
    public void run() {
        System.out.println(getName() + " iniciado.");
        for (int porcentaje = 0; porcentaje <= 100; porcentaje += 25) {
            System.out.println(reporte + ": " + porcentaje + "%");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(getName() + " listo.");
    }

    public static void main(String[] args) throws InterruptedException {
        TareaReporte reporte = new TareaReporte("Ventas mensuales");
        reporte.start();
        reporte.join();
    }
}
