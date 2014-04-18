package SER;

import java.awt.AWTException;
import java.awt.Robot;

public class KeyForwarder {

    private Robot bender;
    private static long defaultMilis;
    
    public KeyForwarder(long milisPerDefecte) {
        defaultMilis = milisPerDefecte;
        try {
            bender = new Robot();
        } catch (AWTException ex) {
            System.out.println("Cannot create robot on KeyForwarder init");
        }
    }
    
    public KeyForwarder() {
        defaultMilis = 50;
        try {
            bender = new Robot();
        } catch (AWTException ex) {
            System.out.println("Cannot create robot on KeyForwarder init");
        }
    }
    
    public void emit(int tecla) throws InterruptedException{
        emitDown(tecla);
        Thread.sleep(defaultMilis);
        emitUp(tecla);
    }
    
    public void emit(int tecla, long milis) throws InterruptedException{
        emitDown(tecla);
        Thread.sleep(milis);
        emitUp(tecla);
    }
    
    public void emitDown(int tecla){
        bender.keyPress(tecla);
    }
    
    public void emitUp(int tecla){
        bender.keyPress(tecla);
    }
}
