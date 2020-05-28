import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AuthServerSearch implements Runnable {
    Socket con;

    AuthServerSearch(Socket s) {
        con = s;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(con.getInputStream());
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            String site = in.readUTF();
            //search for site in server file
            Scanner sc = new Scanner(new File("authoritative_dns_table.txt"));
            while (sc.hasNext()) {
                String s = sc.nextLine();
                StringTokenizer tc = new StringTokenizer(s);
                ArrayList<String> arr = new ArrayList<>();
                while (tc.hasMoreTokens()) {
                    arr.add(tc.nextToken());
                }
                if (arr.get(0).equals(site)) {
                    new HandleQuery(arr, con, "Auth server");
                    return;
                }
            }
            out.writeUTF("The site cannot be found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}