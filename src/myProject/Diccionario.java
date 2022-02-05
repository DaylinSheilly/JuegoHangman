package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    private ArrayList <String> diccionario = new ArrayList <String> ();

    public Diccionario(){

        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();

    }

    public String getFrase(){
        Random aleatorio = new Random();
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        return diccionario.get(aleatorio.nextInt(diccionario.size())); //retorna un entero entre 0 y 7

    }
}
