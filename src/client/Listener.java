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
    private int port;
    private String client_name;
    private int portPool;
    private DatagramSocket sock;
    private DatagramPacket pack;
    private String server_name;
    private ArrayList<receiver> llistaServers;
    private boolean running;

    public Listener(InetAddress local_ip, int port, String client_name) throws SocketException {
        this.local_ip = local_ip;
        this.port = port;
        this.client_name = client_name;
        this.sock = new DatagramSocket(port, local_ip);
        running = true;
        llistaServers = new ArrayList<receiver>();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        boolean received = true;
        try {
            sock.setSoTimeout(1000);
        } catch (SocketException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        while (running) {
            try {
                sock.receive(pack);
            } catch (SocketTimeoutException ex) {
                received = false;
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                received = false;
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
                llistaServers.add(new receiver(portPool, server_name, address));
                portPool++;

                //creacio de receiver amb server_name+server_ip+port+local_ip
            }

        }
    }
}
