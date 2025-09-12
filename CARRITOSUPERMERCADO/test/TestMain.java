package test;

import clases.Bolsa;
import clases.Fruta;
import clases.Lacteo;
import clases.Limpieza;
import clases.NoPerecible;

public class TestMain {
    public static void main(String[] args) {
        int capacidad = 5;
        Bolsa<Lacteo> bolsaLacteos = new Bolsa<>(capacidad);
        Bolsa<Fruta> bolsaFrutas = new Bolsa<>(capacidad);
        Bolsa<Limpieza> bolsaLimpieza = new Bolsa<>(capacidad);
        Bolsa<NoPerecible> bolsaNoPerecible = new Bolsa<>(capacidad);

        //Bolsa de lacteos
        bolsaLacteos.addProducto(new Lacteo("Leche", 34.5, 100, 8));
        bolsaLacteos.addProducto(new Lacteo("Yogurt", 17, 4, 6));
        bolsaLacteos.addProducto(new Lacteo("Crema", 48, 5, 24));
        bolsaLacteos.addProducto(new Lacteo("Queso", 33.5, 3, 80));
        bolsaLacteos.addProducto(new Lacteo("Danup", 19, 7, 12));
        //bolsaLacteos.addProducto(new Lacteo("Danup", 19, 7, 12));

        //Bolsa de frutas
        bolsaFrutas.addProducto(new Fruta("Manzana", 30, 1.0, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta("Pera", 28, 0.75, "Verde"));
        bolsaFrutas.addProducto(new Fruta("Mango", 60, 1.5, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta("Manzana", 50, 1.2, "Roja"));
        bolsaFrutas.addProducto(new Fruta("Uva", 25, 0.250, "Verde"));

        //Bolsa de limpieza
        bolsaLimpieza.addProducto(new Limpieza("Cloro", 35, "Hipoclorito de sodio, hidroxido de sodio y carbonato de sodio", 1));
        bolsaLimpieza.addProducto(new Limpieza("Fabuloso", 56, "Agua, tensoactivos, perfumes y colorantes", 2));
        bolsaLimpieza.addProducto(new Limpieza("Windex", 40, "Agua, solventes, agentes limpiadores, hidroxido de amonio, fragancia y colorante azul", 1));
        bolsaLimpieza.addProducto(new Limpieza("Pinol", 28, "Agua suavizada, emulsificantes, aceite de pino, esencias naturales y agentes de control de calidad", 1));
        bolsaLimpieza.addProducto(new Limpieza("Salvo", 84, "Agua, alquil sulfato de sodio, oxido de amina, alquil etoxisulfato de sodio, y aditivos esteticos como fragancia y colorantes", 2));

        //Bolsa de no perecible
        bolsaNoPerecible.addProducto(new NoPerecible("Arroz", 36, 1, 1300));
        bolsaNoPerecible.addProducto(new NoPerecible("Frijol", 42, 1, 1190));
        bolsaNoPerecible.addProducto(new NoPerecible("Harina de trigo", 30, 1, 364));
        bolsaNoPerecible.addProducto(new NoPerecible("Lentejas", 52, 2, 3500));
        bolsaNoPerecible.addProducto(new NoPerecible("Atun enlatado", 20, 1, 120));
        
        //Informacion de lacteos
        System.out.println("========Lacteos============");
        bolsaLacteos.mostraDetalles();
        //Informacion de frutas
        System.out.println("========Frutas============");
        bolsaFrutas.mostraDetalles();
        //Informacion de limpieza
        System.out.println("========Limpieza============");
        bolsaLimpieza.mostraDetalles();
        //Informacion de no perecible
        System.out.println("========No Perecibles============");
        bolsaNoPerecible.mostraDetalles();


    }
}
