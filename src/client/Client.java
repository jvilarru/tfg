package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {

    
    public static int port = 8888;
    public static String name = "Halfonso";
    public static final int DEBUG = 1;
    public static final int RELEASE = 0;
    public static int mode;
    public static final int BUFF_LEN = 1024;
    private Listener list;
    

    public static void main(String args[]) throws IOException {
        Client c;
        if (args.length >= 1 && args[0].equalsIgnoreCase("DEBUG")) {
            mode = DEBUG;
        } else {
            mode = RELEASE;
        }
        if (args.length >= 2) {
            name = args[1];
        } else {
            try {
                name = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException ex) {
                name = name + (int)(Math.random() * 100.0);
            }
        }
        if (args.length >= 3) {
            port = Integer.parseInt(args[2]);
        }
        c = new Client();
        c.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null && line.length() != 0){
            if (line.equalsIgnoreCase("STOP")){
                c.stop();
            }
        }
    }

    public void start() {
        list = new Listener();
        list.start();
    }
    
    public void stop() throws IOException{
        list.stop();
    }
}
