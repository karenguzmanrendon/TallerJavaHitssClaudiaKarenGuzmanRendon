package test;

import java.util.Arrays;
import java.util.List;

import interfaces.SupermercadoService;
import models.Cliente;
import models.Empleado;
import models.Producto;
import models.Venta;

public class PruebaVentaSupermercado {
    public static void main(String[] args) {
        //Iniciando el servicio
        SupermercadoService service = new SupermercadoService();

        //Productos
        Producto p1 = new Producto(101, "Leche Lala Entera 2L", 77.50, 10);
        Producto p2 = new Producto(102, "Jabon Ariel 5K", 380.00, 4);
        Producto p3 = new Producto(103, "Aceite 123 1L", 43.00, 8);
        Producto p4 = new Producto(104, "Pan Bimbo Grande", 45.00, 15);
        Producto p5 = new Producto(105, "Galletas Marias Gamesa Tubo", 27.50, 2);
        Producto p6 = new Producto(106, "Alitas adobadas 2k", 280.00, 6);

        //Creando catalogo de productos
        List<Producto> catalogoProductos = Arrays.asList(p1, p2, p3, p4, p5, p6);

        //clientes
        //Cliente Normal
        Cliente clienteNormal = new Cliente(1, "Edith Suarez", "Normal");
        //Cliente VIP
        Cliente clienteVIP = new Cliente(2, "Luis Sanchez", "VIP");

        //Empleados
        Empleado e1 = new Empleado(11, "Eric Perez", "Cajero");
        Empleado e2 = new Empleado(12, "Bruno Flores", "Cajero");

        //Mostrando todos los productos
        System.out.println("-------Catalogo de Productos-------");
        //System.out.println(catalogoProductos);
        for (Producto producto : catalogoProductos) {
            System.out.println(producto);
        }
        System.out.println();

        //Requerimientos del sistema 
        //1. Filtrar productos con stock bajo (stock < 5)
        System.out.println("Productos con stock < 5");
        catalogoProductos.stream().filter(service.menorCinco).forEach(System.out::println);
        System.out.println();

        //4. Generar un producto muestra para prueba
        System.out.println("Producto prueba");
        System.out.println(service.productoGenerado.get());
        System.out.println();

        //5. Aplicar un descuento del 10% a un producto
        System.out.println("Aplicar el 10% de descuento a un producto (p2)");
        System.out.println(p2);
        System.out.println(service.descuento10.apply(p2));
        System.out.println();

        //6. Comparar dos productos y devolver el mas caro
        System.out.println("Comparar dos productos y devolver el mas caro");
        System.out.println("Producto 3: --" + p3);
        System.out.println("Producto 5: --" + p5);
        System.out.println("Producto mas caro: ");
        System.out.println(service.masCaro.apply(p3, p5));
        System.out.println();

        
        //Realizar ventas
        //Venta cliente VIP
        List<Producto> productosVenta = Arrays.asList(p1, p1, p6, p2, p3, p1, p4, p5);
        Venta venta = new Venta(5001, clienteVIP, e2, productosVenta);
        
        //Venta cliente normal
        List<Producto> productosVenta2 = Arrays.asList(p1, p5, p3);
        Venta venta2 = new Venta(5002, clienteNormal, e1, productosVenta2);
        
        //2. Calcular el total de una venta a partir de la lista de productos
        System.out.println("Calculando el total de la venta cliente VIP");
        double totalVenta = service.calcularTotal.apply(venta.getProductos());
        venta.setTotal(totalVenta);
        System.out.printf("Total calculado para Venta %d: %.2f\n" , venta.getId(), venta.getTotal());
        System.out.println();
        
        
        System.out.println("Calculando el total de la venta cliente Normal");
        double totalVenta2 = service.calcularTotal.apply(venta2.getProductos());
        venta2.setTotal(totalVenta2);
        System.out.printf("Total calculado para Venta %d: %.2f\n" , venta2.getId(), venta2.getTotal());
        System.out.println();

        //3. Imprimir los detalles de la Venta 1
        service.detallesVenta.accept(venta);
        System.out.println();

        //Detalles de venta 2
        service.detallesVenta.accept(venta2);
        System.out.println();

        //7. Verificar si el cliente puede acceder a un descuento (si es VIP y la compra supera 1000)
        //Verificar cliente VIP
        System.out.println("Verificar si se puede aplicar un descuento a un cliente VIP con un compra de al menos $1000.00");
        boolean ventaVIP = service.aplicarDescuentoVIP.apply(clienteVIP, totalVenta);
        System.out.println("Cliente VIP (" + clienteVIP.getNombre() + ") con $" + venta.getTotal() + " : " + (ventaVIP ? " --Aplica-- " : " X No Aplica"));
        
        //Verificar cliente Normal
        boolean ventaNormal = service.aplicarDescuentoVIP.apply(clienteNormal, totalVenta2);
        System.out.println("Cliente Normal (" + clienteNormal.getNombre() + ") con $" + venta2.getTotal() + " : " + (ventaNormal ? " --Aplica-- " : " X No Aplica"));

        System.out.println();

        //8. Generar un ticket de venta con Cliente +Venta, simulando en consola
        System.out.println("Generando ticket ....");
        service.generarTicket.accept(clienteVIP, venta);

        //9. Notificar a un cliente
        System.out.println();
        System.out.println("Notificar al cliente...");
        service.notificar.accept(clienteVIP, e2);

    }
}
