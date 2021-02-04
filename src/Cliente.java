import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread {
   Socket client;
   public Cliente(Socket socket) {
       this.client = socket;
   }
    public void run() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        while (true) {
            try {
                assert in != null;
                if (!((line = in.readLine()) != null && line.equals("#"))) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("recibido:" + line);
            assert out != null;
            assert line != null;
            out.println(line.toUpperCase());
        }
        assert out != null;
        out.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
