package master;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class Emiter implements Runnable{
    private SocketAddress addr;
    private Socket sock;
    private String name;
    private boolean running;
    private Thread t;

    public Emiter(SocketAddress addr,String name) throws IOException {
        this.addr = addr;
        this.name = name;
        this.sock = new Socket();
        sock.connect(addr);
    }
    @Override
    public void run() {
        while(running){
            
        }
    }
    public void write(char c){
        
    }
    
    public void stop() throws IOException{
        running = false;
        sock.close();
    }
    
    public void start(){
        running = true;
        t = new Thread(this);
        t.start();
    }
    
}
