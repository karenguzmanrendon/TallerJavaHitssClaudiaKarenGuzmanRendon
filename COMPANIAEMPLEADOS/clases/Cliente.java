package clases;

//clase cliente que hereda de persona
public class Cliente extends Persona {
    private int clienteId;
    private int idC = 1;

    //Metodo constructor
    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = idC++;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Cliente: " + clienteId;
    }

    

    
}
