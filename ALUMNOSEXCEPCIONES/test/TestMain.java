package test;

import java.util.Scanner;

import alumnos.Alumno;
import exceptions.EdadInvalidaException;

public class TestMain {
    public static void main(String[] args) {
        //Declarando variables y la clase Sccanner
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;
        Alumno[] alumnos = new Alumno[3];
        //servira para contar cuantos alumnos se han ingresado
        int contador = 0;

        //Mientras que sea true se solicitan los datos, con el fin de que no solo haga los tres solicitudes sino que se mande excepcion al querer seguir ejecutando el programa desde de 3 registros exitosos
        while (true) {
            try {
                //Si el contador es igual a 3 lo que equivale el arreglo entonces muestra excepcion de tipo ArrayIndexOutOfBoundsException
                if(contador >= alumnos.length){
                    throw new  ArrayIndexOutOfBoundsException("No se pueden registrar más de tres alumnos.");
                }
                //Solicitando los datos
                System.out.print("Ingrese nombre de alumno: ");
                nombre = sc.nextLine();
                System.out.print("Ingrese edad: ");
                edad = sc.nextInt();
                //limpiando el buffer de memoria
                sc.nextLine();
                //Guardando alumno en el arreglo nuevoAlumno
                Alumno nuevoAlumno = new Alumno(nombre, edad);
                alumnos[contador] = nuevoAlumno;
                contador++;
                System.out.println("Alumno registrado correctamente");
                //Matrapando los errores el catch de las diferentes tipos de excepcion
            } catch (IllegalArgumentException e) {
                System.out.println("Error de argumento. " + e.getMessage());
            } catch (EdadInvalidaException e) {
                System.out.println("Excepcion capturada de edad. " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                //muestra error de mensaje al dar clic despues del tercer registro exitodo, terminando el programa
                System.out.println("Excepcion de Index. " + e.getMessage());
                break;
            }

        }

        //Imprmiendo los resultados 
        System.out.println("Alumnos registrados");
        for (Alumno al : alumnos) {
            if(al != null){
                System.out.println(al);
            }
        }
        sc.close();
    }
}
