package test;

import java.util.Arrays;

import entidades.Cliente;
import entidades.Factura;
import entidades.Producto;
import genericos.ServicioGenerico;
import util.Utilerias;


//Sistema de facturacion
//Entidades: Cliente, Producto, Factura
//servicio Generico, ID unico -> Todas las entidades que implementen de Identificable
// -> Guardar entidades
// -> Listar las entidades
// -> Buscar por ID
// -> Actualizar por ID
// -> Eliminar por ID

//Una interfaz generica Identificable

//Problema: Escribir y leer  un archivo donde se guarde el detalle de la factura
public class Facturacion {
    public static void main(String[] args) {

        //Una clase con metodos estaticos, los cuales son: 
        //1.- Guardar en un archivo la factura, con la siguiente nomenclatura en el nombre
        //del archivo: "factura_idFactura.txt", todas las facturas se guardan 
        //en una carpeta llamada facturas
        //2.- Leer la factura y mostrar en consola
        //3.- Listar los nombres de todas las facturas existentes
        //  factura_1.txt
        //  factura_2.txt


        //Servicios
        ServicioGenerico<Cliente, String> clienteServicio = new ServicioGenerico<>();
        ServicioGenerico<Producto, Integer> productoServicio = new ServicioGenerico<>();
        ServicioGenerico<Factura, Integer> facturaServicio = new ServicioGenerico<>();
        //No se acepta la entidad Estudiante por que no implementa Identificable
        //ServicioGenerico<Estudiante, Integer> estudianteServicio = new ServicioGenerico<>();
    
        //Clientes
        Cliente c1 = new Cliente("C001", "Eloy Sanchez");
        Cliente c2 = new Cliente("C003", "Susana Gonzaga");
        Cliente c3 = new Cliente("C002", "Edth Santiago");
        clienteServicio.guardar(c1);
        // //No se guarda el cliente c2 porque tiene duplicado el ID
        clienteServicio.guardar(c2);
        clienteServicio.guardar(c3);

        //Productos
        Producto p1 = new Producto(100, "Laptop", 15000);
        Producto p2 = new Producto(200, "Mouse", 250);
        Producto p3 = new Producto(300, "Teclado", 670.54);
        Producto p4 = new Producto(400, "Pantalla LCD", 5600);
        productoServicio.guardar(p1);
        productoServicio.guardar(p2);
        productoServicio.guardar(p3);

        //Facturas
        // List<Producto> nuevaLista = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Factura f1 = new Factura(1, c1, Arrays.asList(p1, p2)); //Retorna una lista de productos //De inmutable
        Factura f2 = new Factura(2, c3, Arrays.asList(p1, p2, p3));
        facturaServicio.guardar(f1);
        facturaServicio.guardar(f2);

        // //Buscar por ID
        System.out.println("Buscar cliente C002");
        System.out.println(clienteServicio.buscarPorId("C002"));
        System.out.println("Buscar cliente C003");
        System.out.println(clienteServicio.buscarPorId("C003"));

        // //Actualizar cliente
        System.out.println("Actualizar cliente C002...");
        clienteServicio.actualizar("C002", new Cliente("C002", "Susana Gonzaga"));

        // //Eliminar cliente por ID
        System.out.println("Eliminando cliente C003");
        clienteServicio.eliminar("C003");

        //Eliminar producto a la factura
        System.out.println("Eliminar y agregar productos a factura");
        f2.eliminarProducto(300);
        f2.agregarElemento(p4);

        System.out.println(f2.generarReporte());

        //Guardar factura
        Utilerias.guardarFactura(f1);
        Utilerias.guardarFactura(f2);

        //Leer factura
        Utilerias.leerFactura(1);
        Utilerias.leerFactura(2);

        //listar facturas
        Utilerias.listarFacturas();

    }
}
