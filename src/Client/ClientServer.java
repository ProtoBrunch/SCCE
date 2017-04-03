package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientServer extends Thread{
    int port;
    Socket partner;
    private BufferedReader inFromPartner;
    static ServerSocket clientServer;


    ClientServer(int port){
        this.port = port;
        try{
            clientServer = new ServerSocket(port);
            System.out.println("Started my own server!");
            this.start();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void run() {
        try {
            partner = clientServer.accept();
            System.out.println("Verbindung fuclkerssdd");
            new ClientController("exit");
            new ClientToClientWriter(partner).start();
            this.inFromPartner = new BufferedReader(new InputStreamReader(partner.getInputStream()));

            String input;
            do {
                input = inFromPartner.readLine();
                if (input != null) {
                    System.out.println(input);
                }
            } while (!Objects.equals(input, "exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
