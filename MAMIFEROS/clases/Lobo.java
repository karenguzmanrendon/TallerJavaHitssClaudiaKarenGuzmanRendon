package clases;

public class Lobo extends Canino{
    private Integer numCamada = 0;
    private String especieLobo;
    public Lobo(String habitat, double altura, double largo, double peso, String nombreCientifico, String color,
            double tamanoColmillos, Integer numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    //Getter
    public Integer getNumCamada() {
        return numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }


    //Metodos abstractos implementados en subclase
    @Override
    public String comer() {
        return "El lobo " + especieLobo + "caza con su grupo de" + numCamada;
    }
    @Override
    public String comunicarse() {
        return "El lobo aulla a la luna";
    }
    @Override
    public String correr() {
        return "El lobo corre agilmente";
    }
    @Override
    public String dormir() {
        return "El lobo " + color + "duerme en las cavernas de " + habitat;
    }

     @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color: " + color 
                            + " | Tamaño de colmillos: " + tamanoColmillos + "cm"
                            + " | Numero de camada: " + numCamada
                            + " | Especie de lobo: "+ especieLobo);
    }
    
}
