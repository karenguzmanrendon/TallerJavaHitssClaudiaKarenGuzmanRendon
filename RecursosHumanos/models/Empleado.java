package models;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private int id;
    private String nombre;
    private String departamento;
    private double salario;
    private int aniosExperiencia;
    private List<Evaluacion> historialEvaluacion;

    public Empleado(int id, String nombre, String departamento, double salario, int aniosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.aniosExperiencia = aniosExperiencia;
        this.historialEvaluacion = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public List<Evaluacion> getHistorialEvaluacion() {
        return historialEvaluacion;
    }

    public void agregarEvaluacion(Evaluacion evaluacion){
        historialEvaluacion.add(evaluacion);
    }

    @Override
    public String toString() {
        return "\nEmpleado #" + id + " - Nombre: " + nombre + " - Departamento: " + departamento + " - Salario: $" + salario
                + " - Experiencia: " + aniosExperiencia + " años.";
    }

    
    
}
