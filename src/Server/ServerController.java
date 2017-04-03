package Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ServerController {

    ServerController(String input, Socket client) {
        String[] inputArray = input.split(" ");
        switch (inputArray[0]) {
            case "NCR":
                new ServerWriter(client).askForInformation();
                break;
            case "RI":
                Server.clientPortsLookingForConnection.put(inputArray[1], Integer.parseInt(inputArray[2]));
                System.out.println(inputArray[2]);
                String inetadress = String.valueOf(client.getInetAddress());
                inetadress = inetadress.replace("/","");
                Server.clientIpsLookingForConnection.put(inputArray[1],inetadress);
                new ServerWriter(client).successOpeningRoom();
                break;


            case "GMC":
                for(String key: Server.clientPortsLookingForConnection.keySet()){
                    new ServerWriter(client).sendClientName(key);
                }
                new ServerWriter(client).endOfClientList();
                break;
            case "GCI":
                String ip = Server.clientIpsLookingForConnection.get(inputArray[1]);
                int port = Server.clientPortsLookingForConnection.get(inputArray[1]);
                new ServerWriter(client).sendClienInformation(inputArray[1], ip, port);
                break;

            case "exit":
                new ServerWriter(client).sendExit();


        }
    }
}
