package models;

import java.time.LocalDate;

public class GestionarVentas {
    private GestionarLibros libro;
    private GestionarClientes cliente;
    private LocalDate fechaCompra;
    private String idVenta;

    public GestionarVentas(String idVenta, GestionarLibros libro, GestionarClientes cliente, LocalDate fechaCompra) {
        this.idVenta = idVenta;
        this.libro = libro;
        this.cliente = cliente;
        this.fechaCompra = fechaCompra;
    }

    public GestionarLibros getLibro() {
        return libro;
    }

    public GestionarClientes getCliente() {
        return cliente;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public void setLibro(GestionarLibros libro) {
        this.libro = libro;
    }

    public void setCliente(GestionarClientes cliente) {
        this.cliente = cliente;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    

    // @Override
    // public String toString() {
    //     return super.toString();

    // }

   
    

    
}
