import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class ServidorCooperativa {
    private static final RepositorioSocios repositorio = new RepositorioSocios();

    public static void main(String[] args) throws IOException {
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);
        servidor.createContext("/socios", ServidorCooperativa::atenderSocios);
        servidor.setExecutor(null);
        servidor.start();
        System.out.println("Servidor en http://localhost:8080/socios");
    }

    private static void atenderSocios(HttpExchange intercambio) throws IOException {
        try {
            URI uri = intercambio.getRequestURI();
            String respuesta;
            if ("GET".equalsIgnoreCase(intercambio.getRequestMethod()) && uri.getQuery() == null) {
                respuesta = repositorio.listar().toString();
            } else {
                String query = uri.getQuery();
                int id = Integer.parseInt(query.substring(query.indexOf('=') + 1));
                respuesta = repositorio.buscarPorId(id).toString();
            }
            responder(intercambio, 200, respuesta);
        } catch (SocioNoEncontradoException | NumberFormatException e) {
            responder(intercambio, 404, e.getMessage());
        } catch (RuntimeException e) {
            responder(intercambio, 400, e.getMessage());
        }
    }

    private static void responder(HttpExchange intercambio, int estado, String texto) throws IOException {
        byte[] datos = texto.getBytes(StandardCharsets.UTF_8);
        intercambio.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        intercambio.sendResponseHeaders(estado, datos.length);
        try (OutputStream salida = intercambio.getResponseBody()) { salida.write(datos); }
    }
}
