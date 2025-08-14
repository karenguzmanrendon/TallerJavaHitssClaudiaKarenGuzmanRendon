/*
Ejercico 4.
 * 
 * Para la tarea se requiere en menu para administrar a los productos con las opciones:
 * actualizar, eliminar, crear, listar y salir.
 * 
 *Para la clase con el metodo main vamos a contar con un menu y poder seleccionar el tipo
 de operacion, segun el numero ingresado.

 Dentro de cada opcion imprimir un texto relacionado, por ejemplo, para actualizar: 
 "usuario actualizado correctamente"

 Para eliminar el mensaje "Usuario eliminado correctamente" y asi sucesivamente
 dependiendo de la opcion

 Iterar hasta que la opcion sea salir, cada vez que se selecciona una operacion distinta a
 salir, al finalizar con dicha operacion debe volver al menu para continuar con la otra, con la 
 opcion salir (5) se debe mostrar un mensaje "Haz salido con exito" y finalizar el programa.
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declarando opcion 
        int op = 0;
        do {
            //hacer --> solicitar una opcion a elegir
            System.out.print("Ingresa una opcion: \t1. Actualizar \t2. Eliminar \t3. Crear \t4. Listar \t5.Salir: ");
            op = sc.nextInt();
            //switch para verificar que opcion se eligio
            switch (op) {
                //opcion 1. actualizar
                case 1:
                    System.out.println("Usuario actualizado correctamente");
                    break;
                //Opcion 2. eliminar
                case 2:
                    System.out.println("Usuario eliminado correctamente");
                    break;
                //opcion 3. crear
                case 3:
                    System.out.println("Usuario creado correctamente");
                    break;
                //opcion 4. listar
                case 4:
                    System.out.println("Listado correctamente");
                    break;
                case 5:
                //opcion salir mostrando mensaje de salida
                    System.out.println("Haz salido con exito");
                    break;
                default:
                //sino se ingreso opcion correcta 
                System.out.println("No ingresaste una opcion correcta");
                break;
            }
            //mientras que la opcion sea --> 5
        } while (op != 5);
        sc.close();
    }
}
