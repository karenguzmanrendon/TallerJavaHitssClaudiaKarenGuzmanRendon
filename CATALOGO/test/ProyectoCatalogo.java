package test;

import java.time.LocalDate;

import clases.Comics;
import clases.IPhone;
import clases.Libro;
import clases.Producto;
import clases.TvLcd;
import interfaces.IProducto;

public class ProyectoCatalogo {
    
    public static void main(String[] args) {
        LocalDate libro = LocalDate.of(2008, 1, 1);
        LocalDate comics = LocalDate.of(2024, 11, 1);
        IProducto[] productos = new Producto[5];
        productos[0] = new IPhone(25999, "Apple", "Titanio del Desierto", "iPhone 16 Pro");
        productos[1] = new TvLcd(5499, "Samsung", 40);
        productos[2] = new Libro(21828, libro, "Lui Joyanes Aguilar", "Fundamentos de Programación", "McGraw Hill Edducation");
        productos[3] = new Comics(749, comics, "Stan Lee, DK y Adam Bray", "Marvel La Enciclopedia", "Penguin Random House", "Superheroés");
        productos[4] = new IPhone(14999, "Apple", "Azul", "iPhone 14");

        System.out.println();
        for (IProducto iProducto : productos) {
            System.out.println("Información de Producto");
            System.out.println(iProducto.toString());
            System.out.println("Ejecutando metodo getPrecioVenta");
            System.out.println(String.format("El precio del producto de venta es $%.2f", iProducto.getPrecioVenta()));
            System.out.println("=====================================================");
        }

    }
}
