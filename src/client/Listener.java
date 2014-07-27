package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener implements Runnable {
   
    private DatagramSocket Usock;
    private ServerSocket Ssock;
    private DatagramPacket pack;
    
    private ArrayList<receiver> llistaReceivers;
    private boolean running;
    private Thread t;

    public Listener(){
        llistaReceivers = new ArrayList<>();
    }

    public void stop() {
        running = false;
        Usock.close();
        for (receiver recv : llistaReceivers) {
            recv.stop();
        }
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        byte[] buff;
        try {
            this.Usock = new DatagramSocket(client.port, InetAddress.getByName("0.0.0.0"));
            this.Ssock = new ServerSocket(client.port);
            buff = new byte[client.BUFF_LEN];
            this.pack = new DatagramPacket(buff, client.BUFF_LEN);
            while (running) {
                Usock.receive(pack);
                String server_name = new String(pack.getData());
                //ficar-hi merda de seguretat del pal clau publica i tal
                SocketAddress socketAddress = pack.getSocketAddress();
                pack.setSocketAddress(socketAddress);
                pack.setData(client.name.getBytes());
                pack.setLength(client.name.getBytes().length);
                try {
                    Usock.send(pack);
                } catch (IOException ex) {
                    Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                }
                Socket s = Ssock.accept();
                receiver r = new receiver(server_name, s);
                llistaReceivers.add(r);
                r.start();
            }
        } catch (SocketException ex) {
            if(running){
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
