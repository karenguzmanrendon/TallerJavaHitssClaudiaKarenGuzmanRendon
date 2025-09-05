package clases;

import interfaces.ILibro;
import java.time.LocalDate;

public class Libro extends Producto implements ILibro{
    private LocalDate fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;
    public Libro(int precio, LocalDate fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getEditorial() {
        return editorial;
    }
    @Override
    public double getPrecioVenta() {
        return precio + (precio * 0.15);
    }
    @Override
    public String toString() {
        return "{precio $" + precio + ", fechaPublicacion: " + fechaPublicacion + ", autor: " + autor + ", titulo: "
                + titulo + ", editorial: " + editorial + "}";
    }
   
    

    

}
