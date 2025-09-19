package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private LocalTime hora;
    private LocalDate fecha;
    private int cantidad;
    public Vuelo(String nombre, String origen, String destino, LocalTime hora, LocalDate fecha, int cantidad) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public String getDestino() {
        return destino;
    }
    
    public LocalTime getHora() {
        return hora;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formaroEspanolMex = DateTimeFormatter
        .ofPattern("EEEE, dd MMMM yyyy", Locale.of("es", "MX"));
        return nombre + ", Partio de: " + origen + ", aterriza el: " + fecha.format(formaroEspanolMex) + " "
                + hora + ", con: " + cantidad + " pasajeros";
    }

    
}
