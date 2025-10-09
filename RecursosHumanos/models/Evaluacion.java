package models;

public class Evaluacion {
    private int anio;
    private int puntuaje;
    private Empleado empleado;

    public Evaluacion(Empleado empleado, int anio, int puntuaje) {
        this.anio = anio;
        this.puntuaje = puntuaje;
        this.empleado = empleado;
    }
    
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPuntuaje() {
        return puntuaje;
    }

    public void setPuntuaje(int puntuaje) {
        this.puntuaje = puntuaje;
    }

    public Empleado getEmpleado() {
        return empleado;
    }


    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

     @Override
    public String toString() {
        return "Evaluacion de empleado #: " + empleado.getNombre() + anio + " - " + puntuaje;
    }
    
}
