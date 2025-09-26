package test;

import java.util.Scanner;

import models.Inventario;
import models.Producto;


public class Enumeracion {
    public static void main(String[] args) {

        Inventario inv = new Inventario();
        
        Scanner sc = new Scanner(System.in);
        int op, cantidad;
        String clave;
        String nombre;
        String categoria;

    do{
        System.out.println();
        System.out.println("================================MENU=================================");
        System.out.println("1. Registrar productos en el inventario");
        System.out.println("2. Consultar un producto");
        System.out.println("3. Generar un reporte de productos en el orden en que fueron agregados");
        System.out.println("4. Generar un reporte de productos ordenados alfabeticamente por nombre");
        System.out.println("5. Actualizar stock cuando se registren ventas o lleguen nuevas unidades");
        System.out.println("6. Salir..");
        System.out.print("Elige una opcion: ");
        op = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch (op) {
            case 1:
                System.out.print("Ingrese la clave: ");
                clave = sc.nextLine();
                System.out.print("Ingrese el nombre: ");
                nombre = sc.nextLine();
                System.out.print("Ingrese la categoria: ");
                categoria = sc.nextLine();
                System.out.print("Ingrese la cantidad: ");
                cantidad = sc.nextInt();
                
                inv.agregarProducto(new Producto(clave, nombre, categoria, cantidad));
                break;
            case 2:
                System.out.print("Ingrese el SKU del producto a buscar: ");
                clave = sc.nextLine();
                inv.consultarProducto(clave);
                break;
            case 3: 
                System.out.println("Generando reporte en orden de como se agregaron los productos");
                //inv.generarReportePorOrdenDeAgregados();
                inv.guardarReporteAgregado();
                break;
            case 4: 
                System.out.println("Generando reporte en orden alfabetico de nombre");
                //inv.generarReportePorNombre();
                inv.guardarReporteNombre();
                
                break;
            case 5: 
                System.out.print("Ingrese el SKU del producto a actualizar su stock: ");
                clave = sc.nextLine();
                System.out.print("Ingrese el nuevo stock del producto: ");
                cantidad = sc.nextInt();
                inv.actualizarStock(clave, cantidad);
                break;
            case 6:
                System.out.println("=====Hasta luego=======");
                break;
            default:
                System.out.println("No ingreso una opción valida....");
                break;
        } 
    
    } while(op != 6);
    sc.close();
}
}
