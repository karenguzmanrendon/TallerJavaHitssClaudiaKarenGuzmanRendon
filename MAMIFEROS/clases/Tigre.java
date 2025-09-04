package clases;

//Subclase de Felino
public class Tigre extends Felino {
    private String especieTigre;

    //Constructor 
    public Tigre(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanoGarras,
            int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    //Getter
    public String getEspecieTigre() {
        return especieTigre;
    }
    
    //Metodos abstractos implementados en subclase
    @Override
    public String comer() {
        return "El tigre" + especieTigre + " caza solitariamente.";
    }

    @Override
    public String comunicarse() {
        return "El tigre ruge ferozmente para comunicarse.";
    }

    @Override
    public String correr() {
        return "El tigre corre a " + velocidad + " km/h.";
    }

    @Override
    public String dormir() {
        return "El tigre duerme en " + habitat;
    }

     @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tamaño de garras: " + tamanoGarras + "cm"
                            + " | Velocidad: " + velocidad + "km/h"
                            + " | Especie: "+ especieTigre );
    }
    
    
}
