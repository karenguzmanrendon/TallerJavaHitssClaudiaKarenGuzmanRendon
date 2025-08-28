package enums;

//Enumeracion de tipo String para OrderPriority
public enum OrderPriority {
    LOW {
        @Override
        public String priority() {
            return "1. (Baja prioridad)";
        }
    },
    MEDIUM {
        @Override
        public String priority() {
           return "2. (Media prioridad)";
        }
    },
    HIGH {
        @Override
        public String priority() {
            return "3. (Alta prioridad)";
        }
    };

    //Metodo abstracto
    public abstract String priority();
}
