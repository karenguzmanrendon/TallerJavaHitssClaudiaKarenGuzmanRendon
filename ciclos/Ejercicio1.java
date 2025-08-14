/* Ejercicio 1: bucle for

 * Mediante el teclado pedir dos numeros enteros positivos o negativos y multiplicarlos, pero 
 * sin usar el simbolo de multiplicacion (*).
 * 
 * Puede utilizar una sentencia for para realizar la multiplicacion y tener en cuenta los 
 * unarios, donde menos por menos es positivo
 * 
*/

package ciclos;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero1, numero2, resultado = 0;
        //Solicitar los dos numeros
        System.out.print("Ingrese un numero: ");
        numero1 = entrada.nextInt();
        System.out.print("Ingrese otro numero: ");
        numero2 = entrada.nextInt();
        //si numero 1 y 2 son negativos estos se pasan a negativos
        if(numero1 < 0 && numero2 < 0) {
            numero1 = -numero1;
            numero2 = -numero2;
            //ciclo for donde se suma el numero 2 por si mismo las veces que equivale el numero 1
            for(int i = 0; i < numero1; i++){
                resultado += numero2;
            }
            //muestra resultado el positivo
            System.out.print("Resultado de: "+ -numero1 + " x " + -numero2 + " = " + resultado);
           
        //sino si solo numero 1 es negativo
        }else if(numero1 < 0){
            //numero 1 se convierte negativo
            numero1 = -numero1;
            //ciclo for para sumar el numero 2 por si mismo las veces que equivale a numero 1
            for(int i = 0; i < numero1; i++){
                resultado += numero2;
            } 
            //Se imprime resultado en negativo
            System.out.print("Resultado de: "+ -numero1 + " x " + numero2 + " = " + resultado);
           
        //sino si numero 2 es negativo
        }else if(numero2 < 0){
            //numero 2 se convierte en negativo
            numero2 = -numero2;
            //ciclo for para que el numero 1 se sume por si mismo las veces que equivale el numero 2
            for(int i = 0; i < numero2; i++){
                resultado += numero1;
            } 
            //se imprime el resultado en negativo
            System.out.print("Resultado de: "+ numero1 + " x " + -numero2 + " = " + resultado);
           
        }else{
            //si los dos numeros son positivos se ejecuta ciclo for para sumar el numero 1 por si mismo las veces que equivale el numero 2
            for(int i = 0; i < numero2; i++){
                resultado += numero1;
            } 
            //Se imprime resultado en valor positivo
            System.out.print("Resultado de: "+ numero1 + " x " + numero2 + " = " + resultado);
           
        }

        entrada.close();
    }
    
}
