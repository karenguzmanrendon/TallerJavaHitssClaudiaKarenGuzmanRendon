package clases;

import java.util.ArrayList;
import java.util.List;

public class Bolsa <T extends Producto> {
    private final int capacidad;
    private final List<T> productos;

    

    public Bolsa(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<>(capacidad);
    }

    public void addProducto(T producto){
        if(productos.size() >= capacidad){
        throw new IndexOutOfBoundsException("La bolsa ya se encuentra llena. ");
        }
        productos.add(producto);
    }

    public List<T>  getProducto(){
        return productos;
    }

    public void mostraDetalles(){
        for (T t : productos) {
            t.mostrarInfo();
        }
    }
}
