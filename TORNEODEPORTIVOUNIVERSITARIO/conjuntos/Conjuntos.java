package conjuntos;

import java.util.Scanner;

import jugadores.Deporte;
import jugadores.Jugador;

public class Conjuntos {
    public static void main(String[] args) {
        int op, id;
        String nombre, deporte;
        Scanner sc = new Scanner(System.in);
        Deporte dep = new Deporte();

        do {
            System.out.println();
            System.out.println("=============================");
            System.out.println("Menu de opciones");
            System.out.println("1. Registrar jugadores");
            System.out.println("2. Mostrar jugadores por deporte");
            System.out.println("3. Contar jugadores en cada disciplina");
            System.out.println("4. Fusionar equipos (unión)");
            System.out.println("5. Ver jugadores en común (intersección)");
            System.out.println("6. Tranferir un jugador de un deporte a otro");
            System.out.println("7. Mostrar todos los jugadores ordenados por nombre");
            System.out.println("8. Mostrar todos los jugadores en orden de inscripción");
            System.out.println("9. Mostrar ranking de jugadores por ID");
            System.out.println("10. Salir");
            System.out.println("==============================");
            System.out.print("Elige una opcion: ");
            op = sc.nextInt();
            System.out.println();
            switch (op) {
                case 1:
                    System.out.println("Registrar jugador");
                    System.out.print("Ingrese ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese deporte (futbol, basquetbol, voleibol): ");
                    deporte = sc.nextLine();

                     if(dep.registrarJugador(deporte, new Jugador(id, nombre, deporte))){
                            System.out.println("Jugador registrado");
                        } else {
                            System.out.println("El jugador ya se encuentra registrado en ese deporte");
                        }

                    
                break;
                case 2:
                    System.out.println("Deporte(futbol/basquetbol/voleibol): ");
                    dep.mostrarJugadores("futbol");  
                    dep.mostrarJugadores("basquetbol");
                    dep.mostrarJugadores("voleibol");
                break;
                case 3:
                    System.out.println("Futbol: " + dep.conteoJugadores("futbol"));
                    System.out.println("Basquetbol: " + dep.conteoJugadores("basquetbol"));
                    System.out.println("Voleibol: " + dep.conteoJugadores("voleibol"));
                break;
                case 4:
                    System.out.println("Fusion entre futbol y basquetbol: ");
                    dep.fusionarEquipos("futbol", "basquetbol");
                break;
                case 5:
                    System.out.println("Jugadores en comun entre futbol/basquetbol: ");
                    dep.jugadoresEnComun("futbol", "basquetbol");
                break;
                case 6:
                        int idJug;
                        String origen;
                        String destino;
                    System.out.print("Ingrese el Id del jugador a transferir: ");
                    idJug = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese deporte origen del jugador: ");
                    origen = sc.nextLine();
                    System.out.print("Ingrese deporte destino del jugador: ");
                    destino = sc.nextLine();

                    if(dep.transferirJugador(origen, destino, idJug)){
                        System.out.println("Jugador transferido");
                    } else{
                        System.out.println("Datos del jugador incorrectos / No se encontro jugador");
                    }
                break;
                case 7:
                    dep.mostrarJugadoresPorNombre();
                break;
                case 8:  
                    dep.mostrarJugadoresPorInscripcion();
                break;
                case 9:
                    dep.rankingPorId();
                break;
                case 10:
                    System.out.println("===Hasta luego====");
                break;
                default:
                    System.out.println("No ingreso una opcion correcta");
                break;
            }
        }while(op != 10);
        sc.close();
    }
}
