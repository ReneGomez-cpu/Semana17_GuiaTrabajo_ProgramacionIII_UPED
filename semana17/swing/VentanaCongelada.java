import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaCongelada {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana congelada");
        JButton boton = new JButton("Procesar");
        JLabel estado = new JLabel("Listo", SwingConstants.CENTER);
        boton.addActionListener(e -> {
            estado.setText("Procesando...");
            for (int i = 0; i < 5; i++) {
                try { Thread.sleep(1000); } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
            }
            estado.setText("Terminado");
        });
        ventana.add(boton, "North");
        ventana.add(estado, "Center");
        ventana.setSize(350, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
