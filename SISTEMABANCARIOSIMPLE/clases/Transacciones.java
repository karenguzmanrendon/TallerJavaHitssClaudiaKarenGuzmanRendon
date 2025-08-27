package clases;

//Clase transacciones
public class Transacciones {
    //atributos
    private final int id;
    private String tipoOperacion;
    private double monto;
    //atributo para llenar el id de cuenta
    private int cuentaId;
    //atributo estatico
    private static int contadorTransacciones = 1;

    //Cosntructor con atributos tipo de operacion, monto, y llamando a la clase cuentasBancarias patra asignarle el id de la cuenta
    public Transacciones(String tipoOperacion, double monto, CuentasBancarias cuentasBancarias) {
        this.id = contadorTransacciones++;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        //se le asigna cuentaId al get de la clase cuentasBancarias
        this.cuentaId = cuentasBancarias.getId();
    }

    //metodo que muestra los datos de las transacciones
    @Override
    public String toString() {
        return "{id: " + id + 
            ", tipoOperacion: " + tipoOperacion + 
            ", monto: " + monto +
            ", cuenta: " + cuentaId + "}";
    }

   
}
