package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientToServerWriter{

    PrintWriter outToServer;
    Scanner scanner = new Scanner(System.in);
    String clientInput;


    public ClientToServerWriter(){
        try {
            this.outToServer = new PrintWriter(Client.server.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInformation(String name, int port){
        outToServer.println("RI "+name+" "+port);
    }

    public void displayName(String name){
        System.out.println(name);
    }

    public void giveInfosToChat(String name){
        outToServer.println("GCI "+name);
    }

    public void sendMessage(){
        clientInput = scanner.nextLine();
        outToServer.println(clientInput);
    }

    public void endServerConnection(){
        outToServer.println("exit");
    }
}

