package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener implements Runnable {

    private InetAddress local_ip;
    private int portListen;
    private String client_name;
    private int portPool;
    private DatagramSocket sock;
    private DatagramPacket pack;
    private String server_name;
    private ArrayList<receiver> llistaServers;
    private boolean running;
    private Thread t;
    private byte[] buff;
    private static final int BUFF_LEN=1024;

    public Listener(InetAddress local_ip, int port, String client_name) throws SocketException {
        this.local_ip = local_ip;
        this.portListen = port;
        this.client_name = client_name;
        llistaServers = new ArrayList<>();
    }

    public void stop() {
        running = false;
        for (receiver recv : llistaServers) {
            recv.stop();
        }
        System.out.println("Waiting for the connections to finish");
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }
    
    public boolean status() {
        return running;
    }

    @Override
    public void run() {
        boolean received;
        System.out.println("Listening to " + local_ip.getHostAddress() + ":" + portListen);
        try {
            this.sock = new DatagramSocket(portListen, local_ip);
            buff = new byte[BUFF_LEN];
            this.pack = new DatagramPacket(buff, BUFF_LEN);
            sock.setSoTimeout(100);
        } catch (SocketException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        while (running) {
            try {
                sock.receive(pack);
                received = true;
            } catch (SocketTimeoutException ex) {
                received = false;
                if (client.mode == client.DEBUG) {
                    System.out.println("Timeout");
                }
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                received = false;
                System.exit(1);
            }
            if (received) {
                //tractament de paquet
                server_name = new String(pack.getData(), 0, pack.getLength());
                //protocol de conexio(prepararho per a errors)
                SocketAddress socketAddress = pack.getSocketAddress();
                InetAddress address = pack.getAddress();
                pack.setSocketAddress(socketAddress);
                byte[] name = client_name.getBytes();
                byte[] IP = local_ip.getHostAddress().getBytes();
                byte[] portMessages = ("" + portPool).getBytes();
                byte[] message = new byte[name.length + IP.length + portMessages.length + 3];
                message[0] = (byte) name.length;
                System.arraycopy(name, 0, message, 1, name.length);
                message[name.length + 1] = (byte) IP.length;
                System.arraycopy(IP, 0, message, name.length + 2, IP.length);
                message[name.length + 1 + IP.length + 1] = (byte) portMessages.length;
                System.arraycopy(portMessages, 0, message, name.length + 1 + IP.length + 2, portMessages.length);
                //explicar server com conectar(donarli port)
                pack.setData(message);
                pack.setLength(message.length);
                try {
                    sock.send(pack);
                } catch (IOException ex) {
                    Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                }
//                receiver r = new receiver(portPool, local_ip, address,address);
//                llistaServers.add(r);
//                r.start();
                System.out.println("Acabo de crear un receiver per al server " + server_name + " amb la direccio " + address.getHostAddress());
                System.out.println("Aquest receiver esta bindejat a l'adreça " + local_ip.getHostAddress() + ":" + portPool);
                portPool++;

                //creacio de receiver amb server_name+server_ip+port+local_ip
            }

        }
        sock.disconnect();
        sock.close();
    }
}
