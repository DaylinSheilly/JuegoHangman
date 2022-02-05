package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 *
 * (ejemplo v.17.3.8 se lee: versión 17 del sofware, la tercera actualización del software
 *  * y la octava corrección de errores)
 */
public class GUIHangman extends JFrame {

    private Header headerProject;
    private PanelFrase panelFrase;
    private PanelHangman panelHangman;
    private ControlHangman controlHangman;
    private Escucha escucha;


    /**
     * Constructor of GUI class
     */
    public GUIHangman(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Hangman Game");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     *
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        controlHangman = new ControlHangman();
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("Oprime una letra del teclado para jugar", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        panelFrase = new PanelFrase(controlHangman.pintarClaveFrases());
        add(panelFrase, BorderLayout.WEST);

        panelHangman = new PanelHangman();
        add(panelHangman, BorderLayout.EAST);
        this.addKeyListener(escucha);
        setFocusable(true);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIHangman miProjectGUIHangman = new GUIHangman();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            String clave = controlHangman.validarLetra(e.getKeyChar());
            if(controlHangman.isFallo()){
                panelHangman.drawBody(controlHangman.getConteoErrores());
                panelFrase.pintarTexto(clave, e.getKeyChar(), controlHangman.getConteoErrores());
                if(controlHangman.getConteoErrores() == 10){
                    int option = JOptionPane.showConfirmDialog(panelFrase, "Perdiste!! ¿Quieres jugar otra ronda?",
                            "Perdiste", JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        //nueva ronda
                        panelFrase.reset(controlHangman.pintarClaveFrases());
                        panelHangman.reset();
                    }else{
                        if(option == JOptionPane.NO_OPTION){
                            System.exit(0);
                        }
                    }
                }
            }else{
               panelFrase.setClave(controlHangman.getClave());
               if(controlHangman.isGanar()){
                   int option = JOptionPane.showConfirmDialog(panelFrase, "Ganaste!! ¿Quieres jugar otra ronda?",
                           "Ganaste", JOptionPane.YES_NO_OPTION);
                   if(option == JOptionPane.YES_OPTION){
                       //nueva ronda
                       panelFrase.reset(controlHangman.pintarClaveFrases());
                       panelHangman.reset();
                   }else{
                       if(option == JOptionPane.NO_OPTION){
                           System.exit(0);
                       }
                   }
               }
            }
        }
    }
}
