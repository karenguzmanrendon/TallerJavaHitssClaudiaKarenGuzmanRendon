package clases;

import java.util.*;
//clase CuentasBancarias
public class CuentasBancarias {
    //Atributo estatico 
    private static int contador = 1;
    private int idCuenta;
    private String nombre;
    private double saldoInicial;
    private List<Transacciones> transacciones;


    //constructor de la clase CuentasBancarias
    public CuentasBancarias(String nombre, double saldo) {
       // asignando atributos 
        this.idCuenta = contador++;
        this.nombre = nombre;
        this.saldoInicial = saldo;
        //mandando a la clase transacciones para llenar un arreglo de listas
        this.transacciones = new ArrayList<>();
    }

    //getters
    public int getId() {
        return idCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldoInicial;
    }

    //Metodo depositar donde suma el monto que se deposita al saldo inicial
    public void depositar(double monto){
        saldoInicial += monto;
        //si se realizo la operacion se llena la lista con el tipo de accion y el monto
        transacciones.add(new Transacciones("Depositar", monto, this));
    }

    //metodo retirar donde se comprueba primero si el monto es menor al saldo, de lo contrario envia error 
    public void retirar (double monto){
        if(saldoInicial >= monto){
            //Se resta el monto al saldo 
            saldoInicial -= monto;
            //Si la accion se realiza se realiza una nueva transaccion 
            transacciones.add(new Transacciones("Retirar", monto, this));
        } else{
            System.out.println("Fondos insuficientes en la cuenta: " + nombre);
        }
    }

    //metodo mostrar transacciones para mostrar la informacion de acuerdo con el numero de transaccion y el id de cuenta
    public void mostrarTransacciones(){
        System.out.println("Historial de transaccciones de: " + nombre);
        for (Transacciones t : transacciones) {
            System.out.println(t);
        }
    }

   //Asignando los valores que se mostraran de las cuentas
    @Override
    public String toString() {
        return "{id=" + idCuenta + 
                ", nombre=" + nombre +
                ", saldo=" + saldoInicial + "}";
    }

    
    
}
