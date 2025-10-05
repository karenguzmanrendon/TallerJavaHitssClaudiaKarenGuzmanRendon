package models;

import java.util.ArrayList;
import java.util.List;

public class GestionarClientes {
    private String nombre;
    private int edad;
    private List<GestionarLibros> historialCompras;
    private int idCliente;

    public GestionarClientes(int idCliente, String nombre, int edad) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.edad = edad;
        this.historialCompras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<GestionarLibros> getHistorialCompras() {
        return historialCompras;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void agregarHistorial(GestionarLibros libro){
        if(this.historialCompras == null){
            this.historialCompras = new ArrayList<>();
        }
        this.historialCompras.add(libro);
    }


    @Override
    public String toString() {
        return "Cliente {nombre: " + nombre + 
                ", edad: " + edad + 
                "}";
    }

    
}
