import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PrintWriter outputChanel;
        BufferedReader bufferedReader;
        Socket socket;
        ServerSocket server;
        try {
            server = new ServerSocket(8080);
            socket = server.accept();
            System.out.println("ha entrado un cliente");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputChanel = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.equals(".")) {
                TimeUnit.SECONDS.sleep(1);
                outputChanel.println(line.toUpperCase());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
