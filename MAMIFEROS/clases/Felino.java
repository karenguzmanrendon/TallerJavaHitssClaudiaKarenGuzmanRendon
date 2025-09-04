package clases;

//Clase asbtracta heredada de Mamifero
public abstract class Felino extends Mamifero{
protected double tamanoGarras;
protected int velocidad;

    //Cosntructos
    public Felino(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    //Getters
    public double getTamanoGarras() {
        return tamanoGarras;
    }
    public int getVelocidad() {
        return velocidad;
    }
   
    
    
}
