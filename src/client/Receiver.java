package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver implements Runnable {
    private final String server_name;
    private ServerSocket sSock;
    private Socket sock;
    private boolean running = false;
    private Thread t;

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
                    stop();
                }
                else
                    System.out.println("He llegit lo següent--> " + line);
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
    
    public boolean status() {
        return running;
    }

}
