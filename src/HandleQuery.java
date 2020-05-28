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
            out.writeUTF("Found site type A");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void queryC(ArrayList<String> arr, Socket s, String server) {
        try {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("Found site type C");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
