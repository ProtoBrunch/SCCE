package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ServerListener extends Thread{
    private Socket client;
    private BufferedReader inFromClient;


    public ServerListener(Socket client){
        this.client = client;
        try {
            this.inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        String input;
        new ServerWriter(client).askForInput();
        try{
            do{
                input = inFromClient.readLine();
                if(input != null) {
                    System.out.println(input);
                    new ServerController(input, client);
                }
            }while(!Objects.equals(input, "exit"));

            client.close();
            this.interrupt();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
