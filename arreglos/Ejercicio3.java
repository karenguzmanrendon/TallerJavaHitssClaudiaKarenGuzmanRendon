/*
Ejercicio 3:
 * 
 * Escribir un programa que imprima una X construida a base de la letra X en las diagonales de
 * la matriz y utilizar el caracter guion bajo como relleno.
 * El tamaño de la X se basa en una variable n que indicara el tamaño de la letra para imprimir
 * en una matriz de n x n.
 * El caracter "X" en mayuscula y el guion bajo "_" para los espacios.
 * Por ejemplo para n = 5 se obtiene: 
 * 
 * X___X
 * _X_X_
 * __X__
 * _X_X_
 * X___X
 * 
 * Por ejemplo para n=6 se obtiene:
 * X____X
 * _X__X_
 * __XX__
 * __XX__
 * _X__X_
 * X____X
 * 
 * Si n es igual a cero imprimit "ERROR" y finalizar la ejecucion del programa
 */
package arreglos;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Variable como final ya que nunca cambia su valor
        final int N;
        System.out.print("Ingrese un numero: ");
        N = sc.nextInt();

        //Si el valor ingresado es cero o un numero negativo
        if(N <= 0){
            System.out.println("ERROR, ingreso cero o numero negativo");
            return; //Sale del programa
        }

        //Se declara el tamaño del arreglo bidimensional de acuerdo con el valor que el usuario ingreso
        char matriz[][] = new char[N][N];
        
        //for para llenar el arreglo de acuerdo conn los valor de X y _ 
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                //se compara si J = I  OR J = (N -1-i) es decir el llenado de sus diagonales 
                if(j == i || j == (N - 1 - i)) {
                    //Si se cumple la condicion se coloca X
                    matriz[i][j] = 'X';
                } else {
                    //De lo contrario se coloca _
                    matriz[i][j] = '_';
                }
            }
        }

        //Imprimir el resultado de la matriz 
        for(int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                System.out.print(matriz[k][l]);
            }
            System.out.println();
        }
        sc.close();
    }
}
