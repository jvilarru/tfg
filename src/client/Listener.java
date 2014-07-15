package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener implements Runnable {

    private InetAddress local_ip;
    private int port;
    private DatagramSocket sock;
    private DatagramPacket pack;

    public Listener(InetAddress local_ip, int port) throws SocketException {
        this.local_ip = local_ip;
        this.port = port;
        this.sock = new DatagramSocket(port, local_ip);
    }

    @Override
    public void run() {
        try {
            //WHILE 2<3
            sock.receive(pack);
            //tractament de paquet
            //protocol de conexio(prepararho per a errors)
            //explicar server com conectar(donarli port)
            //creacio de receiver amb server_name+server_ip+port+local_ip
            //FI-WHILE
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
