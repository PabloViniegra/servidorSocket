import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            File myFile = new File("aux.txt");
            FileInputStream fis = new FileInputStream(myFile);
            byte[] bytearrya = new byte[(int) myFile.length()];
            fis.read(bytearrya);

            Socket socket = server.accept();
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            bos.write(bytearrya,0, bytearrya.length);
            bos.flush();
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
