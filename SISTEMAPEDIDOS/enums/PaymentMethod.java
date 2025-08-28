package enums;

//Enumeracion de tipo String para PaymentMethod
public enum PaymentMethod {
    CASH {
        @Override
        public String method() {
            return "Efectivo";
        }
    },
    CARD {
        @Override
        public String method() {
           return "Tarjeta de crédito/débito";
        }
    },
    TRANFER {
        @Override
        public String method() {
            return "Transferencia";
        }
    };

    //Metodo abstracto
    public abstract String method();
}
