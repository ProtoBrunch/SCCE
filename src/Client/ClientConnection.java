package Client;

import Server.ServerController;
import Server.ServerWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientConnection{
    int port;
    String ip;
    Socket partner;
    BufferedReader inFromPartner;

    ClientConnection(int port, String ip) {
        try {
            partner = new Socket(ip, port);
            if (partner.isConnected()) {
                System.out.println("Verbindung fuckers!");
                new ClientToClientListener(partner);
                new ClientToClientWriter(partner);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
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

