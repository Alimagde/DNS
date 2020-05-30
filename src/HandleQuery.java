import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

//need some info
public class HandleQuery {


    HandleQuery(ArrayList<String> arr, Socket s, String server) {
        if (arr.size() == 3) queryC(arr, s, server);
        queryA(arr, s, server);
    }

    void queryA(ArrayList<String> arr, Socket s, String server) {
        try {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            if (server.equals("Auth server")) {
                out.writeUTF("Url = " + arr.get(0) + " IP Address = " + arr.get(1) + " Query type = A ,NS " + " Server name = " + server);
                return;
            } else {
                out.writeUTF("Url = " + arr.get(0) + " IP Address = " + arr.get(1) + " Query type = A" + " Server name = " + server);
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void queryC(ArrayList<String> arr, Socket s, String server) {
        try {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("URL = "+arr.get(0)+" IP Address = "+arr.get(1)+" Query type = A,CNAME "+"Server name:" +server + " Canonical name: "+arr.get(2)+" Aliases:"+arr.get(0));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
