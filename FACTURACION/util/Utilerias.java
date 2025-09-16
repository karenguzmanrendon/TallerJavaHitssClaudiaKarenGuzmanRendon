package util;

import java.util.List;

import entidades.Factura;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;


public class Utilerias {
    private static final Path carpeta_facturas = Paths.get("facturas");

    //Crear la carpeta sino existe
    static{
        try{
            if(Files.notExists(carpeta_facturas)){
                Files.createDirectories(carpeta_facturas);
            }
        }catch(IOException e){
            System.out.println("Error al crear la carpeta 'Facturas'" + e.getMessage());
        }
        
    }


    public static void guardarFactura(Factura factura){

        Path ruta = carpeta_facturas.resolve("factura_"+ factura.getID() +".txt");
        
        try (BufferedWriter writer = Files.newBufferedWriter(ruta)) {
       
       writer.write(factura.generar());
       System.out.println("Factura guardada en: " + ruta);
        } catch (IOException e) {
        System.out.println("Error al guardar la factura: " + e.getMessage());
        }
    }

    public static void leerFactura(int idFactura){
        Path ruta = carpeta_facturas.resolve("factura_" + idFactura + ".txt");
        try{
            List<String> lineas = Files.readAllLines(ruta);
            for(String linea : lineas){
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println("Error al leer la factura: " +e.getMessage());
        }
    }

    public static void listarFacturas(){
        try{
            System.out.println("Facturas existentes:");
            Files.list(carpeta_facturas).filter(path -> path.toString().endsWith(".txt"))
            .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println("Error al listar las facturas: " + e.getMessage());
        }
    }


}
