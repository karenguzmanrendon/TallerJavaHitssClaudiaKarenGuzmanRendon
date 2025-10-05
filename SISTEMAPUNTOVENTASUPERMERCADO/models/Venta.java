package models;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private Cliente cliente;
    private Empleado empleado;
    private List<Producto> productos;
    private double total;

    public Venta(int id, Cliente cliente, Empleado empleado, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.productos = new ArrayList<>(productos);
        this.total = 0.0; //Posteriormente se calcula
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    @Override
    public String toString() {
        return "Venta {id=" + id + 
                    ", cliente: " + cliente + 
                    ", empleado: " + empleado + 
                    ", productos: " + productos+ 
                    ", total: " + total + "}";
    }

    
}
