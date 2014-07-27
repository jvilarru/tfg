package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class receiver implements Runnable {
    private String server_name;
    private Socket sock;
    private boolean running = false;
    private Thread t;

    public receiver(String server_name, Socket sock) {
        this.sock = sock;
        this.server_name = server_name;
    }

    @Override
    public void run() {
        while (running) {
            InetAddress localAddress = sock.getLocalAddress();
            int localPort = sock.getLocalPort();
            System.out.println("Name -->" + server_name + "\nIp --> " + localAddress.getHostAddress() + ":" + localPort);
            running = false;
        }
    }

    public void stop() throws IOException {
        running = false;
        sock.close();
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
