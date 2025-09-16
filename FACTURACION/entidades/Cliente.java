package entidades;

import genericos.Identificable;

public class Cliente implements Identificable<String>{
    private String id;
    private String nombre;
    
    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String getID() {
        //return null;
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + "]";
    }

    
    
}
