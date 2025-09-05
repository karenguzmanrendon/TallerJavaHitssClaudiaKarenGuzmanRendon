package clases;

import interfaces.IProducto;

public abstract class Producto implements IProducto{
    protected int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    
}
