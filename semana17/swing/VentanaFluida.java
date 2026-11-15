import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class VentanaFluida {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana fluida");
        JButton boton = new JButton("Procesar");
        JLabel estado = new JLabel("Listo", SwingConstants.CENTER);
        boton.addActionListener(e -> {
            boton.setEnabled(false);
            estado.setText("Procesando...");
            new SwingWorker<Void, Integer>() {
                @Override protected Void doInBackground() throws Exception {
                    for (int i = 0; i <= 100; i += 20) { Thread.sleep(500); publish(i); }
                    return null;
                }
                @Override protected void process(java.util.List<Integer> avances) {
                    estado.setText("Avance: " + avances.get(avances.size() - 1) + "%");
                }
                @Override protected void done() { estado.setText("Terminado"); boton.setEnabled(true); }
            }.execute();
        });
        ventana.add(boton, "North");
        ventana.add(estado, "Center");
        ventana.setSize(350, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
