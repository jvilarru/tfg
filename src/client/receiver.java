package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
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
    private boolean running = false;
    private Thread t;
    private InputStream in;
    private OutputStream out;

    public receiver(int port_num, String server_name) {
        this.port_num = port_num;
        this.server_name = server_name;
    }

    @Override
    public void run() {
        try {
            ServerSocket so = new ServerSocket(port_num);
            Socket accept = so.accept();
            InetAddress localAddress = accept.getLocalAddress();
            int localPort = accept.getLocalPort();
            System.out.println("Ip --> " + localAddress.getHostAddress() + ":" + localPort);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void stop() {
        running = false;
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }
    
    public boolean status() {
        return running;
    }

}
