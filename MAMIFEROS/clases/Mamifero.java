package clases;

//Clase abstracta
public abstract class Mamifero {
    protected String habitat;
    protected double altura;
    protected double largo;
    protected double peso;
    protected String nombreCientifico;

    //Constructor
    public Mamifero(String habitat, double altura, double largo, double peso, String nombreCientifico) {
        this.habitat = habitat;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
    }

    //Getters
    public String getHabitat() { 
        return habitat; 
    }

    public double getAltura() {
        return altura;
    }

    public double getLargo() {
        return largo;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    //Metodos abstractos
    public abstract String comer();
    public abstract String dormir();
    public abstract String correr();
    public abstract String comunicarse();

    //Metodos mostrar informacion
    public void mostrarInfo(){
        System.out.println("Habitat: " + habitat + " | Altura: " + altura + "cm."
                            + " | Largo: " + largo + " metros" + " | Peso: " + peso + "kg."
                            + " | Nombre Científico: " + nombreCientifico + "}");
    }
    
}
