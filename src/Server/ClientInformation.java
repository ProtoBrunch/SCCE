package Server;

/**
 * Created by berberatr on 03.04.2017.
 */
public class ClientInformation {
    String ipAdress;
    int port;
    String Name;

    public ClientInformation(){

    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
