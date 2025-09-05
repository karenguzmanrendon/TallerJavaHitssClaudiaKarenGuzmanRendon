package clases;

public class TvLcd extends Electronico{
    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return precio + (precio * 0.10);
    }

    @Override
    public String toString() {
        return "{pulgadas: " + pulgada + ", precio $" + precio + ", fabricante: " + fabricante + "}";
    }

    
    
}
