package jugadores;

import java.util.Objects;

public class Jugador implements Comparable<Jugador>{
    private int id;
    private String nombre;
    private String deporte;
    
    public Jugador(int id, String nombre, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
  
    public String getDeporte() {
        return deporte;
    }

    @Override
    public String toString() {
        return "Jugadores {id: " + id + 
            ", nombre: " + nombre +   
            ", deporte: " + deporte + "}";
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    //    return Objects.hash(id, nombre.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        return id == other.id && Objects.equals(nombre, other.nombre);
        // if ((id = other.id) && (nombre.equals(other.nombre))){
        //     return true;
        // }
        // if (id != other.id)
        //     return false;
        // if (nombre == null) {
        //     if (other.nombre != null)
        //         return false;
        // } else if (!nombre.equals(other.nombre))
        //     return false;
        // return true;
    }
    @Override
    public int compareTo(Jugador o) {
        //return Integer.compare(this.getId(), o.getId());
        return this.nombre.compareToIgnoreCase(o.nombre);
    }  
}
