package clases;

//Clase empleado que hereda de persona
public class Empleado extends Persona {
    private double remuneracion;
    private int empleadoId;
    private static int id = 1;

    //Metodo constructor
    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = id++;
    }
    
    //Gettes
    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public static int getId() {
        return id;
    }

    //metodo aumentarRemuneracion asignando un objeto de tipo empleado para sobreescribirse en la clase de gerente
    public void aumentarRemuneracion(Empleado e, int porcentaje){
        remuneracion += remuneracion * porcentaje / 100;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\n Empleado ID: " + empleadoId +
        "\n Remuneración $" + remuneracion;
    }

    
}
