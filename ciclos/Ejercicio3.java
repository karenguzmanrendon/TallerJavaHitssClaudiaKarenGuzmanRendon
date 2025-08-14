/* 
Ejercicio 3:
 * 
 * Pedit 20 notas finales de alumnos en una escala de 1 al 10, manejar decimales en las notas
 * (double). Mostrar el promedio de las notas mayores o igual a 6, promedio de las notas
 * inferiores a 6 y la cantidad de notas iguales a 1, ademas mostrar el promedio total.
 * 
 * Ayuda: usar un bucle for que itere hasta 20 (notas) y dentro del ciclo pedir las notas una a una
 * para realizar los calculos (contadores,sumas).
 * 
 * Opcional: si una de las notas ingresadas es 0 debe salirse del ciclo for y mostrar un mensaje
 * de error finalizando el programa.
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidadNota = 20;
        double nota = 0, promedio =0;
        int cantidadMayorSeis = 0, cantidadMenorSeis = 0;
        double sumaMayorSeis = 0, promedioMayorSeis = 0, sumaMenorSeis = 0, promedioMenorSeis = 0;
        int notasUno = 0;
        
        //Ciclo for para solicitar los valores de las 20 notas
        for(int i = 1; i <= cantidadNota; i++) {
            System.out.print("Ingrese nota "+(i) + " : ");
            nota = entrada.nextDouble();
            //Condicion si nota es menor o igual a 1; y si nota es mayor a 10
                if(nota >= 1 && nota <= 10) {
                    //Si nota es ogual a 1
                    if(nota == 1){
                        //Se suma el contador de notas igual a 1
                        notasUno++;
                    }
                    //si nota es igual o mayor a 6
                    if(nota >= 6){
                        //Se suma el contador de cantidad de notas mayor o igual a 6
                        cantidadMayorSeis++;
                        //se hace sumatoria de sumaMayorSeis = sumaMayorSeis + nota
                        sumaMayorSeis += nota;
                    } else {
                        //En caso contrario que las notas sean menores a 6 se contabiliza la cantidad de notas menores a seis
                        cantidadMenorSeis++;
                        //Se sealiza la suma total de las notas menores a seis
                        sumaMenorSeis += nota;
                    }
                }else {
                    //Si la nota no entra en el rango solicitado
                    System.out.println("Error al ingresar nota");
                    return;
                }
            }
            //Se obtiene el promedio total: promedio = promedio + suma / cantidadNota (20)
            promedio += nota / cantidadNota;
            
            //Se obtiene promedio de las notas mayores a seis donde promedioMayorSeis = SumaMayorSeis / cantidadMayorSeis
            promedioMayorSeis = sumaMayorSeis / cantidadMayorSeis;
            
            //Se promedio las notas menores a seis donde el promedio = sumaMenorSeis / cantidadMenorSeis
            promedioMenorSeis = sumaMenorSeis / cantidadMenorSeis;

            //imprimir los resultados
            System.out.println("Promedio final: " +promedio);
            System.out.println("Las personas que obtuvieron mas de 6 son: " +cantidadMayorSeis + " con un promedio de: " + promedioMayorSeis);
            System.out.println("Las personas que obtuvieron menos de 6 son: " +cantidadMenorSeis + " con un promedio de: " + promedioMenorSeis);
            System.out.println("Los que obtuvieron 1 son: " +notasUno);
            
        entrada.close();
    }
}
