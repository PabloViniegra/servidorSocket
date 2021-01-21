import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            String chain = "";
            System.out.println("Esperando conexión con el cliente...");
            Socket client = server.accept();

            System.out.println("El cliente se ha conectado");
            BufferedReader inputChanel = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter outputChanel = new PrintWriter(client.getOutputStream(),true);

            while ((chain = inputChanel.readLine()) != null && !chain.equals("*")) {
                outputChanel.println(chain.toUpperCase());
                System.out.println("Recibido: " + chain);
            }

            System.out.println("Cerrando conexion " + chain);
            inputChanel.close();
            outputChanel.close();
            client.close();
            server.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
