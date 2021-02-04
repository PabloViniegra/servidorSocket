import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket client = server.accept();
            new Cliente(client).start();
        }
        /*server.close();*/

    }
}
