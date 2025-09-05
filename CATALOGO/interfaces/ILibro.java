package interfaces;
import java.time.LocalDate;
//interfaz ILibro
public interface ILibro {
    //Metodos 
    public LocalDate getFechaPublicacion(); 
    public String getAutor();
    public String getTitulo();
    public String getEditorial();
}
