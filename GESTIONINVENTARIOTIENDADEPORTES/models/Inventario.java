package models;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventario {

    private Map<String, Producto> productosSku;
    private Map<String, Producto> inventario;
    private TreeMap<String, Producto> ordenNombre;

    public Inventario(){
        productosSku = new HashMap<>();
        inventario = new LinkedHashMap<>();
        ordenNombre = new TreeMap<>();
    }

    public void agregarProducto(Producto producto){
        if(!productosSku.containsKey(producto.getCodigo())){
            productosSku.put(producto.getCodigo(), new Producto(producto.getCodigo(), producto.getNombre(), producto.getCategoria(), producto.getStock()));
            inventario.put(producto.getCodigo(), producto);
            ordenNombre.put(producto.getNombre(), producto);
            System.out.println("Producto " + producto.getCodigo() + " registrado con exito, en la categoria " + producto.getCategoria());
        } else{
            System.out.println("El producto con SKU: " + producto.getCodigo() + " ya existe.");
        }
    }

    public void consultarProducto(String sku){
        if(productosSku.containsKey(sku)){
            System.out.println(productosSku.get(sku));
        } else {
            System.out.println("El producto con el SKU " + sku + " no existe");
        }
    }

    public void generarReportePorNombre(){
        for(Map.Entry<String, Producto> p : ordenNombre.entrySet()){
            System.out.println(p.getKey() + " -> " + p.getValue());
        }
    }

    public String generarReportePorNombreArchivo(){
            
            StringBuilder tabla = new StringBuilder();
            String titulo = "Reporte de productos por nombre\n";
            String separador = "-------------------------------------------------------------------------------\n";

            tabla.append(titulo);
            
            tabla.append(separador);

            for(Map.Entry<String, Producto> p : ordenNombre.entrySet()){
                String contenido = String.format("|%-15s | %-40s |\n ", p.getKey(), p.getValue());
            // System.out.println(p.getKey() + " -> " + p.getValue());
            tabla.append(contenido);
            }
            tabla.append(separador);
            
        return tabla.toString();
    }

    public void guardarReporteNombre(){
        Path ruta = Paths.get("reporte_nombre.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(ruta)) {
            writer.write(generarReportePorNombreArchivo());
            generarReportePorNombre();
            System.out.println("Reporte guardaddo como: " + ruta);
        } catch (Exception e) {
            System.out.println("Error al guardar el reporte: " + e.getMessage());
        }
    }
    
    public void generarReportePorOrdenDeAgregados(){
        for(Map.Entry<String, Producto> p : inventario.entrySet()){
            System.out.println(p.getKey() + " -> " + p.getValue());
        }
    }
    
    public String generarReportePorAgregadoArchivo(){
            
            StringBuilder tabla = new StringBuilder();
            String titulo = "Reporte de productos por orden de agregado\n";
            String separador = "------------------------------------------------------------------------------\n";

            tabla.append(titulo);
            
            tabla.append(separador);

             for(Map.Entry<String, Producto> p : inventario.entrySet()){
                String contenido = String.format("|%-15s | %-40s |\n ", p.getKey(), p.getValue());
            // System.out.println(p.getKey() + " -> " + p.getValue());
            tabla.append(contenido);
            }
            tabla.append(separador);
            
        return tabla.toString();
    }

    public void guardarReporteAgregado(){
        Path ruta = Paths.get("reporte_orden_agregado.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(ruta)) {
            writer.write(generarReportePorAgregadoArchivo());
            generarReportePorOrdenDeAgregados();
            System.out.println("Reporte guardaddo como: " + ruta);
        } catch (Exception e) {
            System.out.println("Error al guardar el reporte: " + e.getMessage());
        }
    }

    public void actualizarStock(String sku, int nuevoStock){
        if(inventario.containsKey(sku)){
            System.out.println("Cantidad actual: " + inventario.get(sku).getStock());
            inventario.get(sku).setStock(nuevoStock);
            System.out.println("Producto despues de modificar el stock: " + sku);
            System.out.println(inventario.get(sku));
        }
    }
}
