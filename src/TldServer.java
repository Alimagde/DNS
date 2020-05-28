import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TldServer implements Runnable {

    public void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(5050);

            while (true) {
                Socket con = socket.accept();
                Thread s = new Thread(new TldServerSearch(con), "Tld server");
                s.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
