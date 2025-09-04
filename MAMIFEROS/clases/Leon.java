package clases;
//Subclase de Felino
public class Leon extends Felino {
    private Integer numManada = 0;
    private double potenciaRugidoDecibel;

    //Metodo constructos
    public Leon(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanoGarras,
            int velocidad, Integer numManada, double potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    //Getters
    public Integer getNumManada() {
        return numManada;
    }

    public double getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }
    

    //Metodos abstractos implementados en subclase
    @Override
    public String comer() {
        return "El león caza junto a su grupo de " + numManada + " individuos en las llanuras africanas.";
    }

    @Override
    public String comunicarse() {
        return "El león ruge a " + potenciaRugidoDecibel + " de potencia de decibel";
    }
    @Override
    public String correr() {
        return "El leon corre a una velocidad de " + velocidad + " km/h";
    }
    @Override
    public String dormir() {
        return "El león duerme en las cavernas de " + habitat;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tamaño de garras: " + tamanoGarras + "cm"
                            + " | Velocidad: " + velocidad + "km/h"
                            + " | Numero de manada: "+ numManada 
                            + " | Potencia rugido: " + potenciaRugidoDecibel + " decibelios");
    }

    

    
    
}
