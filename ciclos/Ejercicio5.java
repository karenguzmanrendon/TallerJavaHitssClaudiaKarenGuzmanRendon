/*
Ejercicio 5:
 * 
 * Un restaurante necesita un programa que permita al cajero. Moostrar un menu de opciones:
 * 1. Registrar un pedido.
 * 2. Mostrar el total de ventas.
 * 3. Salir del sistema.
 * 
 * Cada pedido se registra ingresando el precio. 
 * El programa debe seguir ostrando el menu hasta que el cajero elija Salir.
 * Validar que el precio sea positivo antes de sumarlo a las ventas.
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declarar variables
        int op = 0;
        double venta = 0, totalVenta = 0;

        do {
            //Menu principal
            System.out.println("Menu de restaurante: \n1. Registrar un pedido. \n2. Mostrar el total de ventas. \n3. Salir.");
            op = sc.nextInt();
            //Switch para menu 
            switch (op) {
                case 1:
                //Caso 1. Se registra venta
                    System.out.print("Ingrese pedido a registrar: ");
                    venta = sc.nextDouble();
                //Se registra venta solo en caso de ser positiva y no sea igual a 0
                    if(venta > 0){
                        //Se suma la venta en variable total venta
                        totalVenta += venta;
                    //Si la venta es negativa o cero, manda error de venta
                    } else{
                        System.out.println("No ingreso un precio correcto, regresa a realizar tu registro... ");
                    }
                    break;
                case 2:
                //Muestra el total de las ventas
                    System.out.println(String.format("Total de Venta: %,.2f", totalVenta));
                    break;
                case 3:
                //Casse 3. salir y envia un mensaje de salida
                    System.out.println("======Hasta luego========");
                    break;
                default: 
                //Manda error sino se ingreso una opcion valida 
                    System.out.println("No ingreso una opcion valida");
                    break;
            }
            //Mientras que opcion sea 3, se ejecuta el programa 
        } while (op != 3);
        sc.close();
    }
}
