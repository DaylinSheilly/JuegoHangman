package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGTH = 200;

    private  String clave, letrasMalas, errores;

    public PanelFrase(String clave){
        this.clave = clave;
        letrasMalas = " ";
        errores = " ";
        this.setPreferredSize(new Dimension(WIDTH, HEIGTH));

    }

    public void pintarTexto(String clave, char letra, int error){
        this.clave = clave;
        letrasMalas += " " + String.valueOf(letra); //tranforma la letra a string
        errores += " " + String.valueOf(error); //transforma el entero a string
        repaint();
    }

    public void setClave(String clave){
        this.clave = clave;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Color del jpanel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGTH);

        //texto
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        g.setColor(Color.BLACK);
        g.drawString("Frase a adivinar", 4, 20);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        g.setColor(Color.BLACK);
        g.drawString(clave, 4, 55);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        g.setColor(Color.BLACK);
        g.drawString("Letras incorrectas", 4, 77);
        g.setColor(Color.MAGENTA);
        g.drawString(letrasMalas, 4, 101);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        g.setColor(Color.BLACK);
        g.drawString("Errores", 4, 120);
        g.setColor(Color.MAGENTA);
        g.drawString(errores, 72, 120);
    }

    //se reinicia el panel

    public void reset(String clave){
        this.clave = clave;
        letrasMalas = " ";
        errores = " ";
        repaint();
    }
}
