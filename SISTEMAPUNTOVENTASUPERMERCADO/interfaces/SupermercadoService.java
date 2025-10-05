package interfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import models.Cliente;
import models.Empleado;
import models.Producto;
import models.Venta;


public class SupermercadoService {

    
    //filtar productos con stock bajo (stock<5)
    public Predicate<Producto> menorCinco = stock -> stock.getStock() < 5;

    //calcular total
    public Function<List<Producto>, Double> calcularTotal = lista -> lista.stream().mapToDouble(Producto::getPrecio).sum();
     
    //Imprimir detalles de una venta
    public Consumer<Venta> detallesVenta = d -> {
        System.out.println("======Detalles de Venta======");
        System.out.println("Id Venta: " + d.getId());
        System.out.println("Cliente: " + d.getCliente().getNombre());
        System.out.println("Empleado: " + d.getEmpleado().getNombre());
        System.out.println("Productos: ");
        d.getProductos().forEach(p ->
            System.out.printf(" - %s (%.2f)\n", p.getNombre(), p.getPrecio()));
        System.out.printf("TOTAL: %.2f\n", d.getTotal());
        System.out.println("-------------------------------------");
    };

    //generar producto muestra
    public Supplier<Producto> productoGenerado = () -> new Producto(10, "Producto Prueba Generada", 100.00, 5);

    //Aplicar descuento del 10% de descuento
    public Function<Producto, Producto> descuento10 = p -> new Producto(p.getId(), p.getNombre(), p.getPrecio() * 0.90, p.getStock());

    //Comparar dos productos y devolver el mas caro
    public BiFunction<Producto, Producto, Producto> masCaro = (p1, p2) -> p1.getPrecio() > p2.getPrecio() ? p1 : p2;

    //verificar si el cliente puede verificar a un descuento
    public BiFunction<Cliente, Double, Boolean> aplicarDescuentoVIP = (cliente, total) -> cliente.getTipo().equals("VIP") && total > 1000;

    //Generar ticket de venta como cliente + venta
    public BiConsumer<Cliente, Venta> generarTicket = (cliente, venta) -> {
        System.out.println("\n===============Ticket de Venta===============");
        System.out.println("Id Venta: " + venta.getId());
        System.out.println("Cliente: " + cliente.getNombre() + "(" + cliente.getTipo() + ")" );
        //System.out.println("Empleado: " + venta.getEmpleado().getNombre() + " - " + venta.getEmpleado().getPuesto());
        System.out.println("---------------------------------------------");
        //System.out.println("Productos: ");
        venta.getProductos().forEach(p -> 
            System.out.printf("%-35s $%.2f\n", p.getNombre(), p.getPrecio())
            );
        System.out.println("---------------------------------------------");
        System.out.printf("%-35s $%.2f\n", "TOTAL VENTA: ", venta.getTotal());
        System.out.println("=============================================");
    };

    //Notificar a un cliente que su compra fue procesada por un empleado
    public BiConsumer<Cliente, Empleado> notificar = (c, e) -> System.out.println("Estimado cliente: " + c.getNombre()
    + " su compra fue procesada por: " + e.getNombre());
}
