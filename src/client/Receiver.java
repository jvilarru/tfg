package client;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver implements Runnable {
    private final String server_name;
    private final ServerSocket sSock;
    private Socket sock;
    private boolean running = false;
    private Thread t;
    private Robot rob;
    
    private native int open_term(String term);
    private native int write_char(int fd,char c);
    private native void close_term(int fd);
    private int fd;
    
    private boolean graphic = true;

    public static final int KEYBOARD_TYPE = 0;
    public static final int KEYOBARD_PRESS_SUBTYPE = 0;
    public static final int KEYOBARD_RELEASE_SUBTYPE = 1;

    public static final int MOUSE_TYPE = 1;
    public static final int MOUSE_MOVE_SUBTYPE = 0;
    public static final int MOUSE_MOVE_ABS_SUBSUBTYPE = 0;
    public static final int MOUSE_MOVE_REL_SUBSUBTYPE = 1;
    public static final int MOUSE_BUTTON_SUBTYPE = 1;
    public static final int MOUSE_BUTTON_PRESS_SUBSUBTYPE = 0;
    public static final int MOUSE_BUTTON_RELEASE_SUBSUBTYPE = 1;

    public Receiver(String server_name, int port) throws Exception {
        this.server_name = server_name;
        sSock = new ServerSocket(port);
        try {
            rob = new Robot();
        } catch (AWTException ex) {
            graphic = false;
            addLibraryPath(System.getProperty("user.dir")+"/native/lib");
            System.out.println("No graphical interface detected loading the "
                    + "module located at " +System.getProperty("user.dir")+"/native/lib");
            System.loadLibrary("tty_inject");
        }
    }
    
    private void keystroke(char c){
        if(graphic){
            
        }
        else{
            fd = open_term("/dev/tty0");
            if (write_char(fd,c) != 0){
                System.err.println("Error while injecting " + c + " at the current terminal");
            }
            close_term(fd);
            //TODO: no obrir i tancar cada vegada la terminal?
        }
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
//                    System.out.println("He llegit lo següent--> " + line);
                    String[] split = line.split(":");
                    int type = Integer.parseInt(split[0]);
                    int subtype = Integer.parseInt(split[1]);
                    if (type == KEYBOARD_TYPE) {
                        int keycode = Integer.parseInt(split[2]);
                        if (subtype == KEYOBARD_PRESS_SUBTYPE) {
                            rob.keyPress(keycode);
                        } else if (subtype == KEYOBARD_RELEASE_SUBTYPE) {
                            rob.keyRelease(keycode);
                        } else {
                            error(line);
                        }
                    } else if (type == MOUSE_TYPE) {
                        int subsubtype = Integer.parseInt(split[2]);
                        if (subtype == MOUSE_MOVE_SUBTYPE) {
                            if (subsubtype == MOUSE_MOVE_ABS_SUBSUBTYPE) {
                                //veure com ho fem per pillar dimensions pantalla
                            } else if (subsubtype == MOUSE_MOVE_REL_SUBSUBTYPE) {

                            } else {
                                error(line);
                            }
                        } else if (subtype == MOUSE_BUTTON_SUBTYPE) {
                            int button = Integer.parseInt(split[3]);
                            if (subsubtype == MOUSE_BUTTON_PRESS_SUBSUBTYPE) {
                                //mirar com van els butons de JAVa
                            } else if (subsubtype == MOUSE_BUTTON_RELEASE_SUBSUBTYPE) {

                            } else {
                                error(line);
                            }
                        } else {
                            error(line);
                        }

                    } else
                        error(line);
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

    private void error(String line) {
        System.err.println("Error parsing the message " + line);
    }
    
    private void addLibraryPath(String pathToAdd) throws Exception{
        final Field usrPathsField = ClassLoader.class.getDeclaredField("usr_paths");
        usrPathsField.setAccessible(true);

        //get array of paths
        final String[] paths = (String[])usrPathsField.get(null);

        //check if the path to add is already present
        for(String path : paths) {
            if(path.equals(pathToAdd)) {
                return;
            }
        }

        //add the new path
        final String[] newPaths = Arrays.copyOf(paths, paths.length + 1);
        newPaths[newPaths.length-1] = pathToAdd;
        usrPathsField.set(null, newPaths);
    }

}
