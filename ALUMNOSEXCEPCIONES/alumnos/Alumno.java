package alumnos;

//Se imoorta la clase de excepcion para utilizizar sus metodos 
import exceptions.EdadInvalidaException;

//Clase alumno para utilizar los datos de alumnos 
public class Alumno {
    private String nombre;
    private int edad;

    //Constructor
    public Alumno(String nombre, int edad) throws EdadInvalidaException {
        this.nombre = nombre;
        this.edad = edad;

        //Si la edad es negativa manda excepcion de tipo IllegalArgumentsException
        if(edad < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        //Si la edad es menor a 18 manda excepcion de tipo EdadInvalidaException heredada de la clase EdadInvalidaExcepcionn
        if(edad < 18){
            throw new EdadInvalidaException("La edad minima es de 18 años");
        }
        
    }

    //getters and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "{nombre: " + nombre + ", edad: " + edad + "}";
    }


}
