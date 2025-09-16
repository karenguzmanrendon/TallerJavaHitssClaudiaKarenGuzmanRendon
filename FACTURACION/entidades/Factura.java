package entidades;

import java.util.List;
import java.util.ArrayList;

import genericos.Identificable;

public class Factura implements Identificable<Integer> {
    private Integer id;
    private Cliente cliente;
    private List<Producto> productos;
    
    public Factura(Integer id, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>(productos);
    }

    @Override
    public Integer getID() {
        //return null;
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    //Metodo dinamico para agregar un producto a la lista de productos
    public void agregarElemento(Producto producto){
        productos.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    //Eliminar un producto de lista de productos
    public boolean eliminarProducto(int id){
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getID() == id) {
                Producto producto = productos.remove(i);
                //System.out.println("Producto eliminado: " + productos.get(i));
                System.out.println("Producto eliminado: " + producto);
                return true;
            }
        }
        System.out.println("No se encontro el producto con ID: " + id);
        return false;
    }

    public double calcularTotal(){
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    //Generar el ticket de la factura
    public String generarReporte(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n==========FACTURA #").append(id).append("==============\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("--------------------------------------------------\n");
        for(Producto producto : productos){
            sb.append(producto.getDescripcion())
            .append("\t\t$").append(producto.getPrecio()).append("\n");
        }
        sb.append("--------------------------------------------------\n");
        sb.append("Total: $").append(calcularTotal()).append("\n");
        return sb.toString();
    }

    //Nuevo metodo creado con formato tipo tabla para generar ticke de factura
    public String generar(){
        StringBuilder tabla = new StringBuilder();
       
        String titulo = "\n\t     FACTURA #" + id + "\n";
        String encabezado = String.format("| %-15s | %-15s |\n ", "Producto", "Total");
        String separador = "------------------------------------\n";
        tabla.append(titulo);
        tabla.append(separador);
        tabla.append(encabezado);
        tabla.append(separador);

        for (Producto producto : productos) {
           String filaFormateada = String.format("| %-15s | %-15s |\n", producto.getDescripcion(), producto.getPrecio());
           tabla.append(filaFormateada);
        }
        tabla.append(separador);
        String pie = String.format("| %-15s | %-15s |\n", "Total: ", calcularTotal());
        tabla.append(pie);
        tabla.append(separador);
        return tabla.toString();
    }


    @Override
    public String toString() {
        return "Factura [id=" + id + ", cliente=" + cliente + 
        ", productos=" + productos + ", Total: " + calcularTotal() + "]";
    }

    
}
