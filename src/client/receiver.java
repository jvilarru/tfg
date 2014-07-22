package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

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

    public receiver(int port_num, String server_name, InetAddress server_ip) {
        this.port_num = port_num;
        this.server_name = server_name;
        this.server_ip = server_ip;
    }

    @Override
    public void run() {
//        try {
//            sock = new Socket();
//            SocketChannel channel = sock.getChannel();
//            channel.
//            in = sock.getInputStream();
//            out = sock.getOutputStream();
////            anar llegint per anar executant el que em manin
//            sock.
//        } catch (IOException ex) {
//            Logger.getLogger(receiver.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void stop() {
        running = false;
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }

}
