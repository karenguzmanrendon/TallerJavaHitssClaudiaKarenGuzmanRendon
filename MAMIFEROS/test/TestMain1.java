package test;

import clases.Guepardo;
import clases.Leon;
import clases.Lobo;
import clases.Mamifero;
import clases.Perro;
import clases.Tigre;

public class TestMain1 {
    public static void main(String[] args) {
        //Contabilizar arreglo
        int i = 1;
        //Arreglo de tipo mamifero
        Mamifero[] mamiferos = new Mamifero[7];
        //Llenando los arreglos por medio de objetos
        Mamifero leon1 = new Leon("Sur de África", 100, 1.6, 110, "Panthera leo", 3.8, 80, 10, 114);
        Mamifero leon2 = new Leon("Sur de África", 120, 2.1, 272, "Panthera leo", 3.5, 60, 30, 114);
        Mamifero tigre1 = new Tigre("Bosque tropical", 105, 2.9, 220, "Panthera tigris", 8.0, 65, "Bengala");
        Mamifero tigre2 = new Tigre("Selva", 60, 2.4, 1.2, "Panthera tigris sumatrae", 10, 65, "Sumatra");
        Mamifero guepardo = new Guepardo("África", 94, 1.5, 72, "Acinonyx jubatus", 5.0, 130);
        Mamifero lobo = new Lobo("Bosque", 90, 2.0, 80, "Canis lupus", "Gris", 6.0, 6, "Mexicano");
        Mamifero perro = new Perro("Doméstico", 65, 76, 45, "Canis lupus familiaris", "Negro y canela", 60, 250);

        //asignando el valor de cada arreglo
        mamiferos[0] = leon1;
        mamiferos[1] = leon2;
        mamiferos[2] = tigre1;
        mamiferos[3] = tigre2;
        mamiferos[4] = guepardo;
        mamiferos[5] = lobo;
        mamiferos[6] = perro;

        //For each para recorrer el arreglo y que por cada objeto se realice la accion correspondiente llamando los metodos comer, correr, comunicarse, dormir
        System.out.println();
        for (Mamifero animal : mamiferos) {
            //Mostrando informacion
            System.out.println("============================================== Informacion de animal " + i + ": ===============================================");
            animal.mostrarInfo();
            System.out.println("====================================================== Acciones =======================================================");
            System.out.println(animal.comer());
            System.out.println(animal.correr());
            System.out.println(animal.comunicarse());
            System.out.println(animal.dormir());
            System.out.println();
            i++;
        }

        
    }
}
