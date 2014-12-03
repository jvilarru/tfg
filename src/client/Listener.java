package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener implements Runnable {

    private DatagramSocket Usock;
    private DatagramPacket pack;

    private final ArrayList<Receiver> llistaReceivers;
    private boolean running;
    private Thread t;
    private int port;
    

    public Listener() {
        llistaReceivers = new ArrayList<>();
        port = Client.port+1;
    }

    public void stop() throws IOException {
        running = false;
        Usock.close();
        for (Receiver recv : llistaReceivers) {
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
        String server_name;
        try {
            this.Usock = new DatagramSocket(Client.port, InetAddress.getByName("0.0.0.0"));
            buff = new byte[Client.BUFF_LEN];
            this.pack = new DatagramPacket(buff, Client.BUFF_LEN);
            while (running) {
                //REBRE PAQUETS UDP
                Usock.receive(pack);
                server_name = new String(pack.getData());
                boolean alreadyInUse = false;
                for (Receiver r : llistaReceivers) {
                    if (r.areYou(server_name)) {
                        alreadyInUse = true;
                    }
                }
                if (!alreadyInUse) {
                    //ficar-hi merda de seguretat del pal clau publica i tal
                    //CAL?
                    SocketAddress socketAddress = pack.getSocketAddress();
                    pack.setSocketAddress(socketAddress);
                    //FI-CAL?
                    byte [] packData = creaMessage(Client.name,port);
                    pack.setData(packData);
                    //CAL?
                    pack.setLength(packData.length);
                    //FI-CAL?
                    //FI-REBRE PAQUETS UDP
                    //CONTESTAR-SERVER
                    try {
                        Usock.send(pack);
                    } catch (IOException ex) {
                        Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //FI-CONTESTAR-SERVER
                    //Esperar connexio i al rebre crear un receiver amb el nou socket
                    //i afegirlo a la llista per a si s'ha de tancar, al mateix 
                    //temps que l'arranquem
                    System.out.println("LISTENER\n\tCreo un receiver amb nom -->" + server_name);
                    Receiver r = new Receiver(server_name, port++);
                    r.start();
                    llistaReceivers.add(r);
                }
            }
        } catch (SocketException ex) {
            if (running) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (Exception ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private byte[] creaMessage(String name, int port) {
        byte[] strPort = Integer.toString(port).getBytes();
        byte[] buff = new byte[name.getBytes().length + strPort.length + 1];
        System.arraycopy(name.getBytes(), 0, buff, 0, name.getBytes().length);
        buff[name.getBytes().length] = ':';
        for (int i = 0; i < strPort.length; i++) {
            buff[i+name.getBytes().length+1] = strPort[i];
        }
        return buff;
    }
}
