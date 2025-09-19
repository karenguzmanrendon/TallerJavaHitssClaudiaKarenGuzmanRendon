package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import clases.Vuelo;

public class MainTest {
    public static void main(String[] args) {
        List<Vuelo> vuelo = new ArrayList<>();

        vuelo.add(new Vuelo("AAL 933", "New York", "Santiago", LocalTime.of(05,39), LocalDate.of(2021, 8, 29), 62));
        vuelo.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", LocalTime.of(04,45), LocalDate.of(2021, 8, 31), 47));
        vuelo.add(new Vuelo("SKU 621", "Rio de Janeiro", "Santiago", LocalTime.of(16,00), LocalDate.of(2021, 8, 30), 52));
        vuelo.add(new Vuelo("DAL 147", "Atlanta", "Santiago", LocalTime.of(13,22), LocalDate.of(2021, 8, 29), 59));
        vuelo.add(new Vuelo("AVA 241", "Bogota", "Santiago", LocalTime.of(14,05), LocalDate.of(2021, 8, 31), 25));
        vuelo.add(new Vuelo("AMX 10", "Mexico City", "Santiago", LocalTime.of(05,20), LocalDate.of(2021, 8, 31), 29));
        vuelo.add(new Vuelo("IBE 6833", "Londres", "Santiago", LocalTime.of(8,45), LocalDate.of(2021, 8, 30), 55));
        vuelo.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", LocalTime.of(07,41), LocalDate.of(2021, 8, 29), 51));
        vuelo.add(new Vuelo("SKU 803", "Lima", "Santiago", LocalTime.of(10,35), LocalDate.of(2021, 8, 30), 48));
        vuelo.add(new Vuelo("LAT 533", "Los Angeles", "Santiago", LocalTime.of(9,14), LocalDate.of(2021, 8, 29), 59));
        vuelo.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", LocalTime.of(8,33), LocalDate.of(2021, 8, 31), 31));
        vuelo.add(new Vuelo("CMP 111", "Panama City", "Santiago", LocalTime.of(15,15), LocalDate.of(2021, 8, 31), 29));
        vuelo.add(new Vuelo("LAT 705", "Madrid", "Santiago", LocalTime.of(8,14), LocalDate.of(2021, 8, 30), 47));
        vuelo.add(new Vuelo("AAL 957", "Miami", "Santiago", LocalTime.of(22,53), LocalDate.of(2021, 8, 29), 60));
        vuelo.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", LocalTime.of(9,57), LocalDate.of(2021, 8, 31), 32));
        vuelo.add(new Vuelo("LAT 1283", "Cancun", "Santiago", LocalTime.of(04,00), LocalDate.of(2021, 8, 31), 35));
        vuelo.add(new Vuelo("LAT 579", "Barcelona", "Santiago", LocalTime.of(07,45), LocalDate.of(2021, 8, 29), 61));
        vuelo.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", LocalTime.of(07,12), LocalDate.of(2021, 8, 30), 58));
        vuelo.add(new Vuelo("LAT 501", "Paris", "Santiago", LocalTime.of(18,29), LocalDate.of(2021, 8, 29), 49));
        vuelo.add(new Vuelo("LAT 405", "Montevideo", "Santiago", LocalTime.of(15,45), LocalDate.of(2021, 8, 30), 39));

        //Ordenar por fecha y hora de llegada
        vuelo.sort(Comparator.comparing(Vuelo::getFecha).thenComparing(Vuelo::getHora));
        System.out.println("Vuelos ordenados por llegada:");
        for (Vuelo vuelos : vuelo) {
            System.out.println(vuelos);
        }

        //Ultimo vuelo en llegar
        Vuelo ultimo = Collections.max(vuelo, Comparator.comparing(Vuelo::getFecha).thenComparing(Vuelo::getHora));
        System.out.println("-----------------------------");
        System.out.println("Ultimo vuelo en llegar: ");
        System.out.println(ultimo);
        System.out.println("-----------------------------");

        //Vuelo con menor nuemro 
        Vuelo menorPasajeros = Collections.min(vuelo, Comparator.comparing(Vuelo::getCantidad));
        System.out.println("Vuelo con menor numero de pasajeros: " + menorPasajeros.getNombre() + " con " + menorPasajeros.getCantidad() + " pasajeros ");
    }
}
