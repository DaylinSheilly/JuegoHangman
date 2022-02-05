package myProject;

public class ControlHangman {
    private Diccionario frases;
    private String frase, clave, errores;
    private int conteoErrores;
    private boolean fallo, ganar;

    public ControlHangman(){
        frases = new Diccionario();

    }

    public String pintarClaveFrases(){
        //inicializacion de las variables de control de la ronda
        clave = "";
        frase = frases.getFrase(); //obtener la frase
        errores = "Letras erroneas: ";
        conteoErrores = 0;

        //crear clave
        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == ' '){
                clave += frase.charAt(i);
            }else{
                clave += "-";
            }
        }
        return clave;

    }

    public String validarLetra(char letra){
        fallo = false;
        int index = frase.indexOf(letra); //recibe el char y busca la primera letra que encuentre de letra y dice su posicion
        if(index != -1){
            while(index > -1){
                reemplazarLetra(index, letra);
                index = frase.indexOf(letra, index + 1);
            }
        }else{
            fallo = true;
            conteoErrores++;
            errores += letra + " ";
        }
        return clave;
        }

    private void reemplazarLetra(int index, char letra) {
        char [] arrayClave = clave.toCharArray();
        arrayClave[index] = letra;
        clave = String.copyValueOf(arrayClave);
    }

    public boolean isGanar(){
        /*if(clave.indexOf("-") == -1){
            ganar = true;
        }else {
            ganar = false;
        }*/
        ganar = (clave.indexOf("-") == -1)? true:false; //todo el if se cambia por el operrador terciario
        return ganar;
    }

    public String getFrase() {
        return frase;
    }

    public String getClave() {
        return clave;
    }

    public String getErrores() {
        return errores;
    }

    public int getConteoErrores() {
        return conteoErrores;
    }

    public boolean isFallo() {
        return fallo;
    }
}

