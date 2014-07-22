package client;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client {

    private ArrayList<Actiu> ifaceUp;
    private ArrayList<NetworkInterface> ifaceDown;
    public static final int port = 8888;
    private static String name = "Halfonso";
    public static final int DEBUG = 1;
    public static final int RELEASE = 0;
    public static int mode;

    private class Actiu {

        public NetworkInterface iface;
        public Listener list;

        public Actiu(NetworkInterface iface) {
            this.iface = iface;
        }

    }

    public static void main(String args[]) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("DEBUG")) {
            mode = DEBUG;
        } else {
            mode = RELEASE;
        }
        if (args.length >= 2) {
            name = args[1];
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
    }

    private void classifyInterfaces() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface iface = networkInterfaces.nextElement();
                if (iface.isUp() && (!iface.isLoopback() || mode == DEBUG)) {
                    add(ifaceUp, iface);
                    if (ifaceDown.contains(iface)) {
                        ifaceDown.remove(iface);
                    }
                } else {
                    if (!ifaceDown.contains(iface)) {
                        ifaceDown.add(iface);
                    }
                    remove(ifaceUp, iface);
                }
            }
        }
    }

    private void bindPorts() throws SocketException {
        System.out.println("Interfaces:");
        for (Actiu actiu : ifaceUp) {
            System.out.println("\t" + actiu.iface.getDisplayName());
            Enumeration<InetAddress> addresses = actiu.iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                if (!address.getClass().equals(Inet6Address.class)) {
                    System.out.println("\t  |---> " + address.getHostAddress());
                    actiu.list = new Listener(address, port, name);
                    actiu.list.start();
                }
            }
        }
    }

    private boolean add(ArrayList<Actiu> llista, NetworkInterface element) {
        for (Actiu elemLlista : llista) {
            if (elemLlista.iface.equals(element)) {
                return false;
            }
        }
        llista.add(new Actiu(element));
        return false;
    }

    private boolean remove(ArrayList<Actiu> llista, NetworkInterface element) {
        for (Actiu elemLlista : llista) {
            if (elemLlista.iface.equals(element)) {
                llista.remove(elemLlista);
                return true;
            }
        }
        return false;
    }
}
