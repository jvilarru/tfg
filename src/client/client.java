package client;

import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client {

    private ArrayList<NetworkInterface> ifaceUp;
    private ArrayList<NetworkInterface> ifaceDown;
    private DatagramSocket recvConex;
    public static final int port = 8888;
    private static final int DEBUG = 1;
    private static final int RELEASE = 0;
    private static int mode;

    public static void main(String args[]) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("DEBUG")) {
            mode = DEBUG;
        } else {
            mode = RELEASE;
        }
        try {
            new client().start();
        } catch (SocketException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() throws SocketException {
        ifaceUp = new ArrayList<>();
        ifaceDown = new ArrayList<>();
        classifyInterfaces();
        bindPorts();
//        recvConex = new DatagramSocket(port);
    }

    private void classifyInterfaces() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface iface = networkInterfaces.nextElement();
                if (iface.isUp() && (!iface.isLoopback() || mode == DEBUG)) {
                    if (!ifaceUp.contains(iface)) {
                        ifaceUp.add(iface);
                    }
                    if (ifaceDown.contains(iface)) {
                        ifaceDown.remove(iface);
                    }
                } else {
                    if (!ifaceDown.contains(iface)) {
                        ifaceDown.add(iface);
                    }
                    if (ifaceUp.contains(iface)) {
                        ifaceUp.remove(iface);
                    }
                }
            }
        }
    }

    private void bindPorts() {
        for (NetworkInterface iface : ifaceUp) {
            System.out.println("Adreçes per a linterficie " + iface.getDisplayName());
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                if (!address.getClass().equals(Inet6Address.class)) {
                    System.out.println(address.getHostAddress());
                }
            }
        }
    }
}
