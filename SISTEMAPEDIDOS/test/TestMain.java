package test;

//Importando clases
import enums.Order;
import enums.OrderPriority;
import enums.OrderStatus;
import enums.PaymentMethod;

public class TestMain {
    public static void main(String[] args) {

        //creando objetos de order 
        Order o1 = new Order("Sandra", OrderStatus.NEW, OrderPriority.MEDIUM, PaymentMethod.CASH);
        Order o2 = new Order("Emanuel", OrderStatus.PROCESSING, OrderPriority.HIGH, PaymentMethod.CARD);
        Order o3 = new Order("Luis", OrderStatus.DELIVERED, OrderPriority.LOW, PaymentMethod.TRANFER);

        //Llamando al metodo showDeatils por medio de objeto
        o1.showDetails();
        o2.showDetails();
        o3.showDetails();
    }
}
