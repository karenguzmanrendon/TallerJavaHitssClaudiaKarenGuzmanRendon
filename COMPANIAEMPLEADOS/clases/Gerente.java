package clases;

//Clase gerente que hereda de empleado
public class Gerente extends Empleado {
    private double presupuesto;

    //Constructor
    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion,
            double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion);
        this.presupuesto = presupuesto;
    }
    
    //El metodo setPresupuesto se le resta los porcentajes que se le otorgen de aumento a los empleados
    public void setPresupuesto(Empleado e){
        this.presupuesto = this.presupuesto - e.getRemuneracion();
    }

    //Se sobreescribe el metodo aumentarRemuneracion de acuerdo con objeto de tipo empleado para que el gerente realice el aumento al empleado
    @Override
    public void aumentarRemuneracion(Empleado e, int porcentaje) {
        e.aumentarRemuneracion(e, porcentaje);
        System.out.println("El Gerente " + this.getNombre() + " otorgo un aumento del " + porcentaje + " al empleado con ID: " + e.getEmpleadoId());
    }
    
    
    @Override
    public String toString() {
        return super.toString() +
        "\n Presupuesto $" + presupuesto;
    }

    
}
