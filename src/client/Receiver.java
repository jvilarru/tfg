package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver implements Runnable {
    private final String server_name;
    private final ServerSocket sSock;
    private Socket sock;
    private boolean running = false;
    private Thread t;

    public static final int KEYBOARD_TYPE = 0;
    public static final int MOUSE_TYPE = 1;
    public static final int TABLET_TYPE = 2;
    public static final int PRESSED = 0;
    public static final int RELEASED = 1;
    public static final int BUTTON_PRESSED = 0;
    public static final int BUTTON_RELEASED = 1;

    public Receiver(String server_name, int port) throws IOException {
        this.server_name = server_name;
        sSock =  new ServerSocket(port);
    }
    
    public boolean areYou(String name){
        return name.equals(server_name);
    }

    @Override
    public void run() {
        
        try{
            sock = sSock.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            while (running) {
                String line = in.readLine();

                //Fer algo mes elaborat
                if(line.equalsIgnoreCase("STOP")){
                    System.out.println("tanco paradeta");
                    reboot();
                }
                else {//Parsing and execution
                    System.out.println("He llegit lo següent--> " + line);
                    String[] split = line.split(":");
                }
            }
            
        }
        catch (IOException ex){
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public void stop() throws IOException {
        running = false;
        sock.close();
    }

    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }

    public void reboot() throws IOException {
        stop();
        t.start();
    }

    public boolean status() {
        return running;
    }

}
