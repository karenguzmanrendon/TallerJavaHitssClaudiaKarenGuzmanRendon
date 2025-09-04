package clases;

//Subclase de Felino
public class Guepardo extends Felino {

    //Metodo constructor
    public Guepardo(String habitat, double altura, double largo, double peso, String nombreCientifico,
            double tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    //Metodos abstractos implementados en subclase
    @Override
    public String comer() {
        return "El guepardo caza con gran velocidad para que no le ganen su comida.";
    }

    @Override
    public String comunicarse() {
        return "El guepardo hace sonidos agudos como gorjeos, gruñidos y ronroneos.";
    }

    @Override
    public String correr() {
        return "El guepardo corre a " + velocidad + " km/h.";
    }

    @Override
    public String dormir() {
        return "El guepardo duerme a la sombra en " + habitat;
    }

     @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tamaño de garras: " + tamanoGarras + "cm"
                            + " | Velocidad: " + velocidad + "km/h");
    }
    
}
