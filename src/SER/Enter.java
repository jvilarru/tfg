package SER;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionListener;

public class Enter extends Tecla{
    
    private int puntsX[];
    private int puntsY[];
    private Polygon pol;

    public Enter(String lineToParse, Dimension size, Point position, ActionListener listener,Point insidePoint) {
        super(lineToParse, size, position, listener);
        
        puntsX = new int[6];
        puntsY = new int[6];
        
        puntsX[0] = size.width;
        puntsY[0] = 0;
        
        puntsX[1] = 0;
        puntsY[1] = 0;
        
        puntsX[2] = 0;
        puntsY[2] = insidePoint.y;
        
        puntsX[3] = insidePoint.x;
        puntsY[3] = insidePoint.y;
        
        puntsX[4] = insidePoint.x;
        puntsY[4] = size.height;
        
        puntsX[5] = size.width;
        puntsY[5] = size.height;

        pol = new Polygon(puntsX, puntsY, puntsX.length);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.fillPolygon(pol);
    }
    
}
