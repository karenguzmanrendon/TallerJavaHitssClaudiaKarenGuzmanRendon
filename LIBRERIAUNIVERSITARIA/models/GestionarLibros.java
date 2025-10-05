package models;

public class GestionarLibros {
    private int idLibro;
    private String titulo;
    private String autor;
    private int fechaPublicacion;
    private double precio;

    public GestionarLibros(int idLibro, String titulo, String autor, int fechaPublicacion, double precio) {
        this.idLibro = idLibro; // posteriormente se asigna con interfaz funcional
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String toString() {
        return "Libro {idLibro: " + idLibro +
                                ", titulo: " + titulo + 
                                ", autor: " + autor + 
                                ", fechaPublicacion: " + fechaPublicacion + 
                                ", precio: " + precio + "}";
    }

    
}
