package master;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Emiter {

    public static final int KEYBOARD_TYPE = 0;
    public static final int MOUSE_TYPE = 1;
    public static final int TABLET_TYPE = 2;
    public static final int PRESSED = 0;
    public static final int RELEASED = 1;
    public static final int BUTTON_PRESSED = 0;
    public static final int BUTTON_RELEASED = 1;

    private final String name;
    private Socket sock;
    private PrintStream out;
    private SocketAddress addr;
    private boolean connected = false;

    public Emiter(SocketAddress addr, String name) throws IOException {
        this.addr = addr;
        this.name = name;
        this.sock = new Socket();
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean connect() {
        connected = true;
        return connected;
//        if (!connected) {
//            boolean success = true;
//            try {
//                sock.connect(addr);
//                out = new PrintStream(sock.getOutputStream());
//            } catch (IOException ex) {
//                Logger.getLogger(Emiter.class.getName()).log(Level.SEVERE, null, ex);
//                success = false;
//            }
//            connected = success;
//            return success;
//        } else {
//            return false;
//        }
    }
    
    public void demo() throws IOException {
        sock.connect(addr);
        out = new PrintStream(sock.getOutputStream());
        out.println("Hola soc en " + name);
        out.flush();
        
    }

    public String getName() {
        return name;
    }

    public boolean amI(String name) {
        return this.name.equals(name);
    }
    
    public void demoWrite(String message){
        out.println(message);
        out.flush();
        System.out.println(message);
    }

    /**
     * This function send a message ordering to do some action with the
     * "virtual" keyboard or mouse.
     *
     * <p>
     * The different types and subtypes of messages are the following ones:
     * KEYBOARD_TYPE: it is a message from the keyboard, their subtypes are:
     * PRESSED RELEASED The message it is always a representation of the key
     * pressed/released MOUSE_TYPE: it is a message from the mouse, their
     * subtypes are: BUTTON_PRESSED BUTTON_RELEASED The message is the number of
     * the button that has been pressed/released MOVE The message is the x & y
     * position in the range 0-1 in double precision: Example 0.23322,0.85686
     * WHEEL The message is the movement of the mouse wheel TABLET_TYPE: it is a
     * message form the graphical tablet, their subtypes are the same as in the
     * MOUSE
     *
     * @param type this parameter defines which message types this is
     * @param subtype this parameter defines which subtype of message this is
     * @param Message the char to send to the Receiver
     */
    public void write(int type, int subtype, String Message) {
        if (connected) {
            out.println(type + ":" + subtype + ":" + Message);
            out.flush();
        }
    }

    public void stop() throws IOException {
        if (connected) {
            out.close();
            sock.close();
        }
    }

}
