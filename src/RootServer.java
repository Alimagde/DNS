import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RootServer implements Runnable {

    public void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(4040);

            while (true) {
                Socket con = socket.accept();
                Thread s = new Thread(new RootServerSearch(con),"Root server");
                s.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
