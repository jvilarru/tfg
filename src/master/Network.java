package master;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private ArrayList<String> llistaPotencials;
    private ArrayList<String> llistaClients;

    public void scan() {

    }

    public List<String> getLlista() {
        return llistaPotencials;
    }

    public List<String> getConnected() {
        return llistaClients;
    }

}
