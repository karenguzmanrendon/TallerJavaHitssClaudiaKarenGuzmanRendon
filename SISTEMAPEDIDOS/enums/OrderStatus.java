package enums;

//Enumeracion de tipo String para PaymentMethod
public enum OrderStatus {
    NEW {
        @Override
        public String accion() {
            return "Pedido creado";
        }
    },
    PROCESSING {
        @Override
        public String accion() {
           return "Pedido en proceso";
        }
    },
    SHIPPED {
        @Override
        public String accion() {
            return "Pedido enviado";
        }
    },
    DELIVERED {
        @Override
        public String accion() {
            return "Pedido entregado";
        }
    },
    CANCELLED {
        @Override
        public String accion() {
            return "Pedido cancelado";
        }
    };

    //Metodo abstracto
    public abstract String accion();

}
