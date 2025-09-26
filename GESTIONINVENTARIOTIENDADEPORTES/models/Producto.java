package models;

public class Producto {
    private String codigo;
    private String nombre;
    private String categoria;
    private int stock;
    
    public Producto(String codigo, String nombre, String categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "producto {codigo: " + codigo + 
                ", nombre: " + nombre + 
                ", categoria: " + categoria + 
                ", stock: " + stock
                + "}";
    }

    
}
