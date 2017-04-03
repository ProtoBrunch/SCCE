package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientToServerWriter extends Thread{

    PrintWriter outToServer;
    Scanner scanner = new Scanner(System.in);


    public ClientToServerWriter(){
        try {
            this.outToServer = new PrintWriter(Client.server.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        String clientInput;
        do {
            clientInput = scanner.nextLine();
            if (clientInput != null) {
                outToServer.println(clientInput);
            }
        }while(!Objects.equals(clientInput, "exit"));
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
}

