package test;

import clases.Cliente;
import clases.Empleado;
import clases.Gerente;
import clases.Persona;

public class TestMain {
    public static void main(String[] args) {

        //Objeto de persona como cliente, empleado y gerente
        Empleado p1 = new Empleado("Victor", "Mendez", "RFC1984", "Coyoacan, CDMX", 1000);
        Persona p2 = new Cliente("Cesar", "Hernandez", "RFC2002", "Edomex");
        Gerente p3 = new Gerente("Ana", "Lopez", "RFC123", "Edomex", 2000, 10000);
        //Gerente g1 = new Gerente("Eli", "Carbajal", "RFC987", "CDMX", 1000, 15000);

        //imprimiento la informacion de objetos
        System.out.println("==Empleado==");
        System.out.println(p1);
        System.out.println("==Cliente==");
        System.out.println(p2);
        System.out.println("==Gerente==");
        System.out.println(p3);
        
        System.out.println("==================Operaciones=================");
        //llamando metodo aumentarRemuneracion de la clase gerente, 
        ((Gerente) p3).aumentarRemuneracion(p1, 15);
        p3.setPresupuesto(p1);
        System.out.println("==Empleado==");
        System.out.println(p1);
        System.out.println("==Gerente==");
        System.out.println(p3);
        
    }
}
