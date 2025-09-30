package EXPRESIONESLAMBDA.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import EXPRESIONESLAMBDA.interfaces.PalabraMasRepetidaConteo;

public class PruebaPalabraMasRepetida {
    public static void main(String[] args) {

        PalabraMasRepetidaConteo analizar = f -> {

            //Map<String, Integer> con = Arrays.stream(f.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            Map<String, Long> conteo = Arrays.stream(f.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            //Se busca la palabra mas repetida
            Map.Entry<String, Long> masRepetida = conteo.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();

            //Resultado
            Map<String, Integer> resultado = new HashMap<>();
            resultado.put(masRepetida.getKey(), masRepetida.getValue().intValue());

            return resultado;
        };

        String frase = "hola mundo Java esto es una prueba de Java para curso Java";

        Map<String, Integer> palabraMasRepetida = analizar.obtenerPalabraMasRepetida(frase);

        System.out.println("Frase: " + frase);

        System.out.println("Resultado: " + palabraMasRepetida);

        //Iterando el Map
        palabraMasRepetida.forEach((p, c) -> System.out.println("Palabra: " + p + ", repeticiones: " + c));
    }
}
