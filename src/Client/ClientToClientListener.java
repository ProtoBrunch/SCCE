package Client;

import Server.ServerWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientToClientListener extends Thread{
    Socket partner;
    BufferedReader inFromPartner;


    ClientToClientListener(Socket socket){
        this.partner = socket;
    }

}
