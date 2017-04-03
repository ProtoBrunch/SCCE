package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientToClientWriter extends Thread{
    Socket partner;
    PrintWriter outToPartner;
    Scanner scanner = new Scanner(System.in);


    public ClientToClientWriter(Socket client){
        this.partner = client;
        try {
            this.outToPartner = new PrintWriter(partner.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.run();
    }

    public void run(){
            String clientInput;
            do {
                clientInput = scanner.nextLine();
                if (clientInput != null) {
                    outToPartner.println(clientInput);
                }
            }while(!Objects.equals(clientInput, "exit2"));
        }
    }

