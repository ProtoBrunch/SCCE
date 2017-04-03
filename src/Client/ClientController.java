package Client;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientController {

    ClientController(String input){
        String[] inputArray = input.split(" ");
        switch(inputArray[0]){
            case "GMI":
                System.out.println("Who is opening a Chatroom?");
                String chatRoomOwner = "Robin";
                System.out.println("Which Port are you using?");
                int port = 51000;
                //new ClientServer(port).start();
                new ClientToServerWriter().sendInformation(chatRoomOwner, port);
                break;
            case "RCN":
                System.out.println("Currently the following people are looking for chatpartners: ");
                new ClientToServerWriter().displayName(inputArray[1]);
                break;
            case "EOCL":
                System.out.println("These are all the Clients looking for chatpartners.");
                System.out.println("With whom do you wish to chat?");
                String chatPartner = "Robin";
                new ClientToServerWriter().giveInfosToChat(chatPartner);
                break;
            case "RCI":
                System.out.println("Now Connecting with "+inputArray[1]);
                new ClientConnection(Integer.parseInt(inputArray[3]),inputArray[2]);
            case "M":
                System.out.println(input);
                break;
            default:
                System.out.println(input);
        }
    }
}
