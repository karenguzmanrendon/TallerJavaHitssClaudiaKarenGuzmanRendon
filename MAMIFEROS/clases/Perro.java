package clases;

//Subclase de canino 
public class Perro extends Canino{
    private Integer fuerzaMordida = 0;

    //Constructor
    public Perro(String habitat, double altura, double largo, double peso, String nombreCientifico, String color,
            double tamanoColmillos, Integer fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    //Getter
    public Integer getFuerzaMordida() {
        return fuerzaMordida;
    }

    //Metodos abstractos implementados en subclase
    @Override
    public String comer() {
        return "El perro come todo lo que le da su amo por eso pesa " + peso + " kg.";
    }

    @Override
    public String comunicarse() {
        return "El perro " + color + "ladra con fuerza de " + fuerzaMordida + " psi.";
    }

    @Override
    public String correr() {
        return "El perro corre felizmente para atrapar su pelota.";
    }

    @Override
    public String dormir() {
        return "El perro duerme en " + habitat;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color: " + color 
                            + " | Tamaño de colmillos: " + tamanoColmillos + "mm"
                            + " | Fuerza de mordida: " + fuerzaMordida + "psi");
    }


    
}
