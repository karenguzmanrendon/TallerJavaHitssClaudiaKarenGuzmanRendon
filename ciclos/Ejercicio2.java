/*
Ejercico 2: Bucle for
 * 
 * Crear una clase con el metodo main donde el desafio es buscar el numero menor de
 * minimo 10 valores enteros, usando la clase Scanner ingresar la cantidad de numeros a 
 * comparar, luego utilizando una sentencia for iterar el numero de veces (ingresado) para 
 * pedir el numero entero, entonces se requiere:
 * 
 * Calcular el menor numero e imprimir el valor.
 * 
 * Si el menor numero es menor que 10, imprimir "El numero menor es menor que 10!". si no,
 * imprimir "el numero menor es igual o mayor que 10!"
 */

package ciclos;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        int numero;
        //Se solicita un numero que sea 
        System.out.print("Ingrese un numero igual o mayor a 10: ");
        cantidad = entrada.nextInt();
        //Se evalua que el numero menor sea el valor maximo 
        int menor = Integer.MAX_VALUE;
        //Si el numero ingresado es mayor o igual a 10 se ejecuta el programa
        if (cantidad >= 10) {
            //Ciclo for para solicitar el valor de las cantidad de cada numero
            for(int i = 1; i <= cantidad; i++) {
                System.out.print("Ingrese el valor de cada numero: ");
                numero = entrada.nextInt();
                //Si numero ingresado es el menor entonces se le asigna a menor (con el fin de encontrar el menor numero de los valores ingresados)
                if(numero < menor){
                    menor = numero;   
                }
            }
            System.out.println("El numero menor es: " + menor);
           
            //Si menor es menor a 10 
            if(menor < 10){
                System.out.println("El numero menor es menor que 10!");
            } else{
                //Si menor es igual o mayor a 10
                System.out.println("El numero menor es igual o mayor a 10!");
            }
            //Solo deja ingresar un numero mayor o igual a 10
        } else {
            System.out.println("El numero debe ser al menos 10");
            
        }

        entrada.close();
    }
}