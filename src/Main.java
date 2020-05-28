// ip = 192.168.1.25


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String args[]) {
        //Server server = new Server();
        // server.start();
        Thread local = new Thread(new LocalServer(), "local");
        Thread root = new Thread(new RootServer(), "root");
        Thread tld = new Thread(new TldServer(), "tld");
        Thread auth = new Thread(new AuthServer(), "auth");
        local.start();
        root.start();
        tld.start();
        auth.start();
        try {

            System.out.print("Enter site : ");
            Scanner sc = new Scanner(System.in);
            String site = sc.next();
            Socket s = new Socket("localhost", 3030);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(site);
            DataInputStream in = new DataInputStream(s.getInputStream());

            System.out.println(in.readUTF());


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
