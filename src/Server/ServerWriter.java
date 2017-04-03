package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ServerWriter {
    Socket client;
    PrintWriter outToClient;


    public ServerWriter(Socket client){
        this.client = client;
        try {
            this.outToClient = new PrintWriter(client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void askForInput(){
        outToClient.println("M What is it you wish to do?");
    }

    public void askForInformation(){
        outToClient.println("GMI");
    }

    public void successOpeningRoom(){
        outToClient.println("You opened your own Chatroom, now you'll have to wait for someone to connect.");
    }

    public void sendClientName(String client){
        outToClient.println("RCN "+client);
    }

    public void endOfClientList(){
        outToClient.println("EOCL");
    }

    public void sendClienInformation(String name, String ip, int port){
        outToClient.println("RCI "+name+" "+ip+" "+port);
    }
}