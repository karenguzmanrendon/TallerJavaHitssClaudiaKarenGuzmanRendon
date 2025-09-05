package clases;

import java.time.LocalDate;

public class Comics extends Libro{
    private String personaje;

    public Comics(int precio, LocalDate fechaPublicacion, String autor, String titulo, String editorial,
            String personaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    @Override
    public double getPrecioVenta() {
        return precio + (precio * 0.08);
    }

    @Override
    public String toString() {
        return "{precio $" + precio + ", fechaPublicacion: " + getFechaPublicacion() 
                + ", autor: " + getAutor() + "titulo: " + getTitulo() 
                + ", editorial: " + getEditorial() + "personaje=" + personaje + "}";
    }

    
    
    
}
