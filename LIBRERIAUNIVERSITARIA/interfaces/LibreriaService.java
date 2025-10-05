package interfaces;

import java.time.LocalDate;
//import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import models.GestionarClientes;
import models.GestionarLibros;
import models.GestionarVentas;

public class LibreriaService {

    //Generar Id de Venta (Encontre una distinta manera de generar codigo automatico)
    public final Supplier<String> generarCodigoVenta = () -> "V-" + System.currentTimeMillis();
    //public Supplier<String> generarCodigoVenta = () -> UUID.randomUUID().toString();  //Genera un valor unico de 120bits
    //System.out.println("ID generado: " + generar.get());

    //Genera id de cliente
    public Supplier<Integer> idClientSupplier = new Supplier<>() {
        private int contador = 101;
        @Override
        public Integer get() { return contador++; }
    };

    //Genera id de libro
    public Supplier<Integer> idLibroSupplier = new Supplier<>() {
        private int contador = 1;
        @Override
        public Integer get() { return contador++; }
    };

    //Genera fecha de compra automaticamente
    public Supplier<LocalDate> generarFecha = LocalDate::now;  //Genera fecha automaticamente
    
    //Verificar si la fecha es mayor a 1900
    public Predicate<GestionarLibros> esMayor1900 = f -> f.getFechaPublicacion() > 1900;
    

    //Verificar si el libro cuesta mas de 0
    public Predicate<GestionarLibros> mayorCero = p -> p.getPrecio() > 0;

    //verificar si la edad del cliente es mayor a 18
    public Predicate<GestionarClientes> mayorEdad = e -> e.getEdad() >= 18;

    //resumen del libro
    public Function<GestionarLibros, String> resumen = l -> (
        String.format("Libro: '%s' del Autor:  %s, con fecha de publicacón: %d y un costo de: %.2f",
        l.getTitulo(), l.getAutor(), l.getFechaPublicacion(), l.getPrecio()));
    


     // BiFunction que calcula el promedio a partir de la suma y el conteo
    public BiFunction<Double, GestionarLibros, Double> sumarPrecio = (suma, libro) -> suma + libro.getPrecio(); 
    
    //Encontrar el libro mas caro 
    public BinaryOperator<GestionarLibros> masCaro = (l1, l2) -> l1.getPrecio() > l2.getPrecio() ? l1 : l2;
    
    //Encontrar el libro mas barato
    public BinaryOperator<GestionarLibros> masBarato = (l1, l2) -> l1.getPrecio() < l2.getPrecio() ? l1 : l2;

    //enviar notificacion al cliente
    public Consumer<GestionarVentas> notificar = (v) -> System.out.println("Estimado cliente: " + v.getCliente().getNombre()
    + " usted ha adquirido el libro: " + v.getLibro().getTitulo() + " el dia de " + v.getFechaCompra());

    //calcular descuento -> se aplica solo en libros modernos mayores de 1900
    public Function<Double, Double> calcularDescuento = precio -> precio * 0.90;

     //generar factura 
    public Consumer<GestionarVentas> generarFactura = (venta) -> {
        double nuevoPrecioLibro = 0.0;
        if(esMayor1900.test(venta.getLibro())){
            nuevoPrecioLibro = calcularDescuento.apply(venta.getLibro().getPrecio());
        } else{
            nuevoPrecioLibro = venta.getLibro().getPrecio();
        }
        System.out.println("\n============================FACTURA=============================");
        System.out.println("Id Venta: " + venta.getIdVenta());
        System.out.printf("\n%-20s %d %s %s","Cliente:  " , venta.getCliente().getIdCliente(), " - ", venta.getCliente().getNombre());
        System.out.printf("\n%-20s %s", "Libro: " , venta.getLibro().getTitulo());
        System.out.printf("\n%-20s %s", "Fecha compra: " , venta.getFechaCompra());
        System.out.println("\n-----------------------------------------------------------------");
        System.out.printf("\n%-20s %s %.2f", "Precio: " , "$", nuevoPrecioLibro);
        System.out.println("\n-----------------------------------------------------------------");
    };

    //Metodo para realizar una venta
    public GestionarVentas realizarVenta(GestionarClientes cliente, GestionarLibros libro){
    
    //validando si el cliente es mayor de edad para realizar la venta
    if(!mayorEdad.test(cliente)){
        System.out.println("ERROR: EL cliente debe ser mayor de edad.");
        return null;
    }

    //validando si el libro es mayor de 1900 para que el descuente se aplique
    if(!esMayor1900.test(libro)){
        System.out.println("ADVERTENCIA: Libro antiguo, procede sin descuento");
    }
   
    //Se crea codigo de venta y fecha de venta automaticamente
    String codigo = generarCodigoVenta.get();
    LocalDate fechaVenta = generarFecha.get();

    GestionarVentas nuevaVenta = new GestionarVentas(codigo, libro, cliente, fechaVenta);

    //Se agregar historiañ de libros de venta
    cliente.agregarHistorial(libro);

    //Una vez creada la venta se imprime el reporte y se notifica al cliente
    generarFactura.accept(nuevaVenta);
    notificar.accept(nuevaVenta);

    return nuevaVenta;
    }

    public Consumer<GestionarClientes> imprimirHistorialCompras = cliente -> {
        System.out.println("\n =========Historial de compras de: " + cliente.getNombre() + "=========");
        //Se verifica si hay compras
        if(cliente.getHistorialCompras() == null || cliente.getHistorialCompras().isEmpty()){
            System.out.println("El cliente no tiene compras registradas");
            return;
        }

        //Se itera cada libro
        cliente.getHistorialCompras().forEach(libro -> {
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Precio: " + libro.getPrecio());
            System.out.println("--------------------------------------------------");
        });
        System.out.println("=========================================================");
    };

}
