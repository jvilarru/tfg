package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener implements Runnable {
   
    private int portPool;
    private DatagramSocket sock;
    private DatagramPacket pack;
    
    private ArrayList<receiver> llistaReceivers;
    private boolean running;
    private Thread t;
    private byte[] buff;
    private static final int BUFF_LEN=1024;

    public Listener(){
        llistaReceivers = new ArrayList<>();
    }

    public void stop() {
        running = false;
        sock.close();
//        for (receiver recv : llistaReceivers) {
//            recv.stop();
//        }
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            this.sock = new DatagramSocket(client.port, InetAddress.getByName("0.0.0.0"));
            buff = new byte[BUFF_LEN];
            this.pack = new DatagramPacket(buff, BUFF_LEN);
            while (running) {
                sock.receive(pack);
                //tractament de paquet
                System.out.println("l'he rebut");
                System.exit(1);
                String server_name = new String(pack.getData(), 0, pack.getLength());
                //protocol de conexio(prepararho per a errors)
                SocketAddress socketAddress = pack.getSocketAddress();
                InetAddress address = pack.getAddress();
                pack.setSocketAddress(socketAddress);
                byte[] name = client.name.getBytes();
                byte[] IP = sock.getInetAddress().getHostAddress().getBytes();
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
                System.out.println("Aquest receiver esta bindejat a l'adreça " + sock.getInetAddress().getHostAddress() + ":" + portPool);
                portPool++;

                //creacio de receiver amb server_name+server_ip+port+local_ip               
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
