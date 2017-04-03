package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;


/**
 * Created by berberatr on 03.04.2017.
 */
public class Client extends Thread{
    static Socket server;

    public static void main(String[] args) {
        String host = "172.16.2.156";
        int port = 50000;

        try {
            server = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Client().start();
        new ClientToServerWriter().start();

    }

    public void run(){
        String input;
        BufferedReader inFromServer = null;
        try {
            inFromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            do{
                assert inFromServer != null;
                input = inFromServer.readLine();
                new ClientController(input);
            }while(!Objects.equals(input, "exit"));

        } catch(SocketException se){
            System.out.println("Lost Connection to Server.");
            this.interrupt();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
