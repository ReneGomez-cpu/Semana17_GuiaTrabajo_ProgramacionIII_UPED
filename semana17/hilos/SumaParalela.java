import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumaParalela {
    public static void main(String[] args) throws Exception {
        int[] numeros = new int[1000];
        for (int i = 0; i < numeros.length; i++) numeros[i] = i + 1;

        ExecutorService ejecutor = Executors.newFixedThreadPool(4);
        Future<Integer> mitad1 = ejecutor.submit(() -> sumar(numeros, 0, 500));
        Future<Integer> mitad2 = ejecutor.submit(() -> sumar(numeros, 500, numeros.length));
        System.out.println("Suma paralela: " + (mitad1.get() + mitad2.get()));
        ejecutor.shutdown();
    }

    private static int sumar(int[] numeros, int inicio, int fin) {
        int total = 0;
        for (int i = inicio; i < fin; i++) total += numeros[i];
        return total;
    }
}
