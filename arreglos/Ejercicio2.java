/*
Ejercicio 2:
 * 
 * Para la tarea se debe crear un arreglo con 10 elementos (enteros en el rango 1 a 9). Escriba
 * un programa que imprima el numero que tiene mas ocurrencias en el arreglo y tambien
 * imprimir la cantidad de vecs que aparece en el arreglo.
 * Por ejemplo, para el arreglo: [1,2,3,3,4,5,5,5,6,7]
 * como resultado deberia imprimir lo siguiente:
 * 1. La mayor ocurrencia es: 3
 * 2. El elemento que mas se repite es: 5
 * En el ejemplo, el elemento que mas se repote en el arreglo es el numero 5 con una 
 * ocurrencia de 3 veces
 */
package arreglos;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Declarando final numElementos 
        final int numElementos = 10;
        int numero = 0;
        //Declarando arreglo con valor de 10
        int[] elementos = new int[numElementos];
        
        //Solicitando los valores para el arreglo
        System.out.println("Ingrese un numero del 1 al 9: ");
        for(int i = 0; i < elementos.length; i++){
            
            do { //Hacer 
                System.out.print("Numero "+(i+1)+": ");
                numero = sc.nextInt();

                //Si el numero ingresado esta fiera de los valores manda error
                if(numero < 1 || numero > 9) {
                    System.out.println("Solo se permiten numeros del 1 al 9");
                }
            } while (numero < 1 || numero > 9); //Evita que un numero se ingrese en el i fuera de rango
            
            //asignando los valores ingresados en cada posicion del arreglo
            elementos[i] = numero;
        }
        sc.close();
        
        //Se crea una variable para conocer la posicion de donde se encuentra el elemento con más repeticiones
        int moda = elementos[0];
        //Variable para buscar cual es la mayor ocurrencia
        int mayorOcurrencia = 0;
        //se recorre el arreglo para comparar si existen numeros repetidos
        for(int i = 0; i < elementos.length; i++) {
            //se declra contabilizador
            int contador = 0;
            for (int j = 0; j < elementos.length; j++) {
                //si elementos de la posicion i == elementos de la posicion j quiere decir que un numero se repite
                if(elementos[i] == elementos[j]) {
                    //contabilizador se incrementa
                    contador++;
                }
            }
            // si contador es mayor a mayor ocurrencia
            if(contador > mayorOcurrencia){
                //mayor ocurrencia = contabilizador
                mayorOcurrencia = contador;
                //moda == elementos en la posicion i
                moda = elementos[i];
            }
        }

        //imprimiendo resultado 
        System.out.println("La mayor ocurrencia es: " + mayorOcurrencia);
        System.out.println("El elemento que mas se repite es: " + moda);

    }
}
        
