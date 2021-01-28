import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Message implements Serializable, Runnable {
    private String uniqueID;
    private String message;
    private Socket socket;

    public Message( String message, Socket socket) {
        this.uniqueID = UUID.randomUUID().toString();;
        this.message = message;
        this.socket = socket;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new PrintWriter(this.socket.getOutputStream()));
            String response = new Scanner(System.in).nextLine();
            String[] tokens = response.split(" ");
            for (int i = 0; i < tokens.length; i++) {
                TimeUnit.MILLISECONDS.sleep(1000);
                bufferedWriter.write(tokens[i]);
            }
            bufferedWriter.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
