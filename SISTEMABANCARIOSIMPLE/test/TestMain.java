package test;

import clases.CuentasBancarias;


public class TestMain {
    public static void main(String[] args) {
       
        //Creando objeto para cuentas bancarias
        //Asignando valores e imprimiendo su valor 
        CuentasBancarias c1 = new CuentasBancarias("Ana Gomez", 1000.00);
        System.out.println(c1);
        CuentasBancarias c2 = new CuentasBancarias("Angel Salgado", 2500.00);
        System.out.println(c2);
        CuentasBancarias c3 = new CuentasBancarias("Bruno Flores", 3000.00);
        System.out.println(c3);

        System.out.println("--------------------Transacciones-------------------------");
        //LLamando a los metodos depositar o retirar segun sea el caso
        c1.depositar(300);
        c2.retirar(3000);
        c2.depositar(400);
        c3.retirar(350);
        c3.depositar(250);
        c1.depositar(400);
        
        //llamando al metodo mostrar transacciones para visualizar las operaciones que hizo cada cliente 
        c1.mostrarTransacciones();
        c2.mostrarTransacciones();
        c3.mostrarTransacciones();
    }
}
