package test;

import java.util.Arrays;
import java.util.List;

import interfaces.LibreriaService;
import models.GestionarClientes;
import models.GestionarLibros;

public class PruebaLibreriaUniversitaria {
    public static void main(String[] args) {
        //iniciando el servicio
        LibreriaService service = new LibreriaService();

        //Generando Id automaticos 
        //id de libro
        int idL1 = service.idLibroSupplier.get();
        int idL2 = service.idLibroSupplier.get();
        int idL3 = service.idLibroSupplier.get();

        //id cliente
        int idC1 = service.idClientSupplier.get();
        int idC2 = service.idClientSupplier.get();


        //Libros
        GestionarLibros l1 = new GestionarLibros(idL1, "100 años de soledad", "Gabriel Garcia Marquez", 1967, 300.00);
        GestionarLibros l2 = new GestionarLibros(idL2, "Emperadores romanos a traves de la historia", "Matthew Jamison", 1721, 500.00);
        GestionarLibros l3 = new GestionarLibros(idL3, "Fundamentos de la Programación", "Joyanes", 2008, 350);

        List<GestionarLibros> libros = Arrays.asList(l1, l2, l3);
        System.out.println("=========Libros==========");
        for (GestionarLibros impLibros : libros) {
            System.out.println(impLibros);
        }
        //Clientes
        GestionarClientes c1 = new GestionarClientes(idC1, "Karen Guzman", 30);
        GestionarClientes c2 = new GestionarClientes(idC2, "Ivan Perez", 17);

        System.out.println("========Clientes=======");
        List<GestionarClientes> clientes = Arrays.asList(c1, c2);
        for (GestionarClientes impCliente : clientes) {
            System.out.println(impCliente);
        }
        System.out.println("_____________________________________________________________________________________________");
        System.out.println();

        //Operaciones

        //Verificar si cliente es mayor de edad
        System.out.println("Verificando la edad del cliente");
        System.out.println("Verificar si un cliente es mayor de edad (mayor de edad)");
        System.out.println("¿Cliente 1 es mayor de edad? " + service.mayorEdad.test(c1));
        
        System.out.println("Verificar si un cliente es mayor de edad (menor de edad)");
        System.out.println("¿Cliente 2 es mayor de edad? " + service.mayorEdad.test(c2));
        System.out.println("===================================================================");
        
        System.out.println("Verificando fecha de publicación de libro");
        System.out.println("Verificar cuando un libro tiene fecha posterior a 1900");
        System.out.println("¿Libro 3 es moderno? " + service.esMayor1900.test(l3));
        
        System.out.println("Verificar cuando un libro tiene fecha anterior a 1900");
        System.out.println("¿Libro 2 es moderno? " + service.esMayor1900.test(l2));
        System.out.println("===================================================================");
        
        
        //Descuento de un libro
        System.out.println("Calculando descuento de un libro");
        double precioFinal = service.calcularDescuento.apply(l1.getPrecio());

        //Convertir un libro en resumen textual
        System.out.println("Resumen del libro: " + service.resumen.apply(l1));
        System.out.printf("Precio con descuento: $%.2f\n" , precioFinal);
        System.out.println("===================================================================");
        
        System.out.println();
        double sumaPrecios = 0.0;
        for (GestionarLibros libro : libros) {
            sumaPrecios = service.sumarPrecio.apply(sumaPrecios, libro);
        }
        //Calcula el promedio
        double promedio = 0.0;
        if(!libros.isEmpty()){
            promedio = sumaPrecios / libros.size();
        }
        System.out.printf("\n%s %.2f\n","Promedio de libros: $" , promedio);
        System.out.println("===================================================================");
        
        //Libro mas caro
        System.out.println("Libro mas caro entre libro 1 y libro 2");
        System.out.println(service.masCaro.apply(l1, l2));
        
        System.out.println("Libro mas barato entre libro 1 y libro 3");
        
        System.out.println(service.masBarato.apply(l1, l3));
        
        System.out.println("===================================================================");
        
        
        //Ventas
        System.out.println("Realizando venta 1 / venta valida");
        service.realizarVenta(c1, l1);
        
        System.out.println("Realizando Venta 2 / Venta fallida por el cliente menor de edad");
        service.realizarVenta(c2, l3);
        
        System.out.println("Realizando venta 3 / venta valida / libro sin descuento");
        service.realizarVenta(c1, l2);
        System.out.println("===================================================================");

        System.out.println();
        //Historial de compras 
        System.out.println("Historial de cliente 1");
        service.imprimirHistorialCompras.accept(c1);

    }
}
