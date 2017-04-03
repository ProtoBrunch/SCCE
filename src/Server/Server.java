package Server;

import java.io.IOException;
import java.net.*;
import java.util.*;


/**
 * Created by berberatr on 03.04.2017.
 */
public class Server {
    static HashMap<String, String> clientIpsLookingForConnection = new HashMap<>();
    static HashMap<String, Integer> clientPortsLookingForConnection = new HashMap<>();


    public static void main(String[] args) {
        int port = 50000;
        Socket client1;

        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server Online");
            String ipAdress = Inet4Address.getLocalHost().getHostAddress();
            System.out.println("Server Adress is: "+ipAdress+":"+port);

            while(true) {
                client1 = server.accept();
                new ServerListener(client1).start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
