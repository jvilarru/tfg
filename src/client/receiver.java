package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class receiver implements Runnable {

    private int port_num;
    private String server_name;
    private InetAddress server_ip;
    private InetAddress local_ip;
    private Socket sock;
    private InputStream inStream;

    public receiver(int port_num, String server_name, InetAddress server_ip) {
        this.port_num = port_num;
        this.server_name = server_name;
        this.server_ip = server_ip;
    }

    @Override
    public void run() {
        try {
            sock = new Socket(local_ip, port_num);
            inStream = sock.getInputStream();
            //anar llegint per anar executant el que em manin
        } catch (IOException ex) {
            Logger.getLogger(receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
