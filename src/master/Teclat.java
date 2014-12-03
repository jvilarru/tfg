package master;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class Teclat extends JPanel {

    private class rawData {

        public String datos;
        public double relWidth, relHeight;
        public Tecla tecla;
    }

    private static final int ID=0;
    private ArrayList<ArrayList<rawData>> matriu = new ArrayList<>();
    private int i;        
    private ArrayList<Double> tamanys = new ArrayList<>();
    private Master boss;

    public Teclat(String layout, Dimension dim,Master boss) throws IOException {
        super();
        this.boss = boss;
        setName("Teclat");
        setSize(dim);
        setPreferredSize(dim);

        GroupLayout teclatLayout = new GroupLayout(this);
        setLayout(teclatLayout);
        prepareKeys(layout);
        printKeys(dim);
    }

    private void prepareKeys(String layout) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(layout));        
        ArrayList<rawData> linia;

        rawData raw;
        i = 0;
        String line = br.readLine();
        while (line != null) {
            linia = new ArrayList<>();
            tamanys.add(0.0);
            while (line != null && !line.equals("NEWLINE")) {
                raw = new rawData();
                String[] split;
                String[] size;
                if (line.startsWith("\\")) {
                    split = line.split(">");
                    size = split[1].split("<");
                } else {
                    split = line.split(";");
                    size = split[1].split(",");
                }
                raw.datos = split[0];
                raw.relWidth = Double.parseDouble(size[0]);
                raw.relHeight = Double.parseDouble(size[1]);
                Double get = tamanys.get(i) + Double.parseDouble(size[0]);
                tamanys.set(i, get);
                linia.add(raw);
                line = br.readLine();
            }
            matriu.add(linia);
            i++;
            line = br.readLine();
        }
        br.close();
    }
    
    private void printKeys(Dimension screenSize) {
        ArrayList<rawData> linia;
        int num_files = matriu.size();
        Tecla.minFontSize = new float[20];
        for (i = 0; i < 20; i++) {
            Tecla.minFontSize[i] = (float) 200.0;
        }
        for (i = 0; i < num_files; i++) {
            linia = matriu.get(i);
            Double width_size = tamanys.get(i);
            double accum = 0.0;
            for (rawData linia1 : linia) {
                if (!linia1.datos.equals("EMPTY")) {
                    Dimension dim = new Dimension((int) ((screenSize.width / width_size) * linia1.relWidth), (int) ((screenSize.height / num_files) * linia1.relHeight));
                    Point p = new Point((int) (accum * (screenSize.width / width_size)), i * (screenSize.height / num_files));
                    linia1.tecla = new Tecla(linia1.datos, dim, p, i,this);
                    add(linia1.tecla);
                }
                accum += linia1.relWidth;
            }
        }
        for (i = 0; i < num_files; i++) {
            for (rawData linia1 : matriu.get(i)) {
                Tecla t = linia1.tecla;
                if (t != null) {
                    t.setFontSize(t.getTitle().length());
                }
            }
        }
    }
    public void send(int keycode,boolean pressed){
        boss.send(ID,pressed,keycode);
    }
}
