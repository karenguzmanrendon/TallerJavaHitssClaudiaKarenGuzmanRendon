package EXPRESIONESLAMBDA.test;

import EXPRESIONESLAMBDA.interfaces.QuitarEspaciosConvertirMayusculas;

public class PruebaQuitarEspacios {
    public static void main(String[] args) {
        //Lamba que quite espacios y devuelva mayusculas
        QuitarEspaciosConvertirMayusculas<String, String> frase = f -> f.replaceAll("[ ,.]", "").toUpperCase();
        String texto = "Hola !! como estas?.... me llamo Karen, tengo 20 años";
        System.out.println("Texto normal: " + texto);
        String resultado = frase.transformar(texto);
        System.out.println("Texto aplicando lambda");
        System.out.println(resultado);
    }
}
