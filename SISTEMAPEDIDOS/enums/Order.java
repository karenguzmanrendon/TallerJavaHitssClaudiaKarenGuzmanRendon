package enums;

public class Order {
    //Atributos
    private int id;
    private String customer;
    private OrderStatus orderStatus;
    private OrderPriority orderPriority;
    private PaymentMethod paymentMethod;
    //atributo estatico
    private static int contador = 1;


    //Metodo constructor
    public Order(String customer, OrderStatus orderStatus, OrderPriority orderPriority, PaymentMethod paymentMethod) {
        this.id = contador++;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderPriority = orderPriority;
        this.paymentMethod = paymentMethod;
    }

    //Metodo mostrar detalles
    public void showDetails(){
        System.out.println("=========================================");
       System.out.println("Pedido #: " + id);
       System.out.println("Customer: " + customer);
       System.out.println("Estado: " + orderStatus.accion());
       System.out.println("Prioridad: " + orderPriority.priority());
       System.out.println("Metodo de pago: " + paymentMethod.method());
       System.out.println("=========================================");
    }

    
}
