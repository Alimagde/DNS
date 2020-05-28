import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LocalServer implements Runnable {

    public void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(3030);

            while (true) {
                Socket con = socket.accept();
                Thread s = new Thread(new LocalServerSearch(con),"Local server");
                s.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
