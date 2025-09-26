package jugadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Deporte {

    //Se declaran los Set como TreeSet
    private Set<Jugador> deportesTree = new TreeSet<>();
    private Set<Jugador> deportesLindek;

    //asignando Set de tipo jugador 
    private Set<Jugador> futbol;
    private Set<Jugador> basquetbol;
    private Set<Jugador> voleibol;
    //asignando una lista para guardar los jugadores de acuerdo a su inscripcion 
    private List<Jugador> ordenInscripcion = new ArrayList<>();
    
    //asignando valor a los set de tipo hashset y haciendo publicos para utilizarlas en cada metodo
    public Deporte () {
        futbol = new HashSet<>();
        basquetbol = new HashSet<>();
        voleibol = new HashSet<>();
    }
    
    //Metodo registrar jugador
    public boolean registrarJugador(String deporte, Jugador jugador) {
        //Creando una lista para poder obtener todos los datos de cada jugador de cada deporte para buscar si existen coinicidencias tanto en ID como nombre
        for(Set<Jugador> conjunto : Arrays.asList(futbol, basquetbol, voleibol)){
            for (Jugador j : conjunto) {
                //se verifica si existe el ID registrado
                if(j.getId() == jugador.getId()){
                    //Si en el id buscado existe un nombre distinto al que se quiere volver a inscribir
                    if(!j.getNombre().equalsIgnoreCase(jugador.getNombre())){
                        //envia mensaje de error, ya que un jugador con el mismo ID debe tener el mismo nombre, aunque diferente deporte
                        System.out.println("Error: El Id " + jugador.getId() + " ya se encuentra registrado con el nombre " + j.getNombre());
                        return false;
                    }
                }
            }
        }
        //se declara variable boolean para verificar si se ejecuta agregar un nuevo jugador se llena la lista
        boolean agregado = getDeporte(deporte).add(jugador); //llamando metodo getDeporte para agregar el jugador 
        //si se agrego jugador
        if(agregado) {
            //se agrega el jugador a la lista de orden 
            ordenInscripcion.add(jugador);
        }
        return agregado;

    }
        
        //Metodo mostrar jugadores por nombre
        public void mostrarJugadoresPorNombre(){
            //llenando el conjunto treeset con los conjuntos hashset de los deportes
            deportesTree.addAll(futbol);
            deportesTree.addAll(basquetbol);
            deportesTree.addAll(voleibol);

            System.out.println("Jugadores ordenados por nombre:");
            deportesTree.forEach(j -> System.out.println("Id: " + j.getId() + " -> Nombre: " + j.getNombre()));
        }

        //Metodo mostrar jugadores por inscripcion
        public void mostrarJugadoresPorInscripcion(){
            //se llena el conjunto de tipo linkedset con la lista de orden de inscripcion
            deportesLindek = new LinkedHashSet<>(ordenInscripcion);
            
            deportesLindek.addAll(futbol);
            deportesLindek.addAll(basquetbol);
            deportesLindek.addAll(voleibol);

            System.out.println("Jugadores ordenados por orden de inscripcion");
            deportesLindek.forEach(js -> System.out.println("Id: " + js.getId() + " -> Nombre: " + js.getNombre()));
        }

        //Metodo mostrar jugadores por medio del conjunto HashSet
        public void mostrarJugadores(String deporte) {
            Set<Jugador> conjunto = getDeporte(deporte);
            if(conjunto != null){
                System.out.println("Jugadores en " + deporte + ": ");
                conjunto.forEach(System.out::println);
            }
        }

        //Metodo getDeporte para llenar el conjunto de acuerdo el tipo de deporte
        public Set<Jugador> getDeporte(String deporte){
            switch (deporte.toLowerCase()) {
                case "futbol" : return futbol;
                case "basquetbol" : return basquetbol;
                case "voleibol" : return voleibol;
                default: return null;
            }
        }

        //Metodo que contabiliza cada deporte
        public int conteoJugadores(String deporte){
            switch (deporte.toLowerCase()) {
                case "futbol" : return futbol.size();
                case "basquetbol" : return basquetbol.size();
                case "voleibol" : return voleibol.size();
                default: return 0;
            }
        }

        //Metodo fusion 
        public void fusionarEquipos (String f, String b) {
            //se crea una fusion entre los dos distintos conjuntod de futbol y basquetbol
            Set<Jugador> fusion = new HashSet<>(getDeporte(f));
            fusion.addAll(getDeporte(b));
            System.out.println("Jugadores fusionados ( " + f + " + " + b + " ): ");
            fusion.forEach(j -> System.out.println("Id: " + j.getId() + " -> Nombre: " + j.getNombre()));
        }

        //Metodo de Interseccion donde se verifica si existe el mismo jugador inscrito en dos deportes diferentes
        public void jugadoresEnComun(String f, String b) {
            Set<Jugador> comun = new HashSet<>(getDeporte(f));
            comun.retainAll(getDeporte(b));
            System.out.println("JUgadores en comun ( " + f + " + " + b + "): ");
            comun.forEach(j -> System.out.println("Id: " + j.getId() + " -> Nombre: " + j.getNombre()));
        }

        //Metodo Transferir jugador de un deporte a otro
        public boolean transferirJugador(String jOrigen, String jDestino, int id){
            Set<Jugador> origen = getDeporte(jOrigen);
            Set<Jugador> destino = getDeporte(jDestino);

            Jugador encontrado = null;
            //primero se busca en el deporte de origen si existe el jugador
            for(Jugador j : origen){
                if(j.getId() == id) {
                    encontrado = j;
                    break;
                }
            }
            //Si esq existe el jugador en el deporte mencionado
            if(encontrado != null){
                //se elimina del conjunto de origen
                origen.remove(encontrado);
                //Se agrega al nuevo conjunto 
                return destino.add(encontrado);
            }
            return false;
        }

        //Rankind por ID 
        public void rankingPorId(){
            //Utilizando treeset para comparar y ordenar por ID
            TreeSet<Jugador> ranking = new TreeSet<>(Comparator.comparing(Jugador::getId));
            //Se llena con los hashset el treeset
            ranking.addAll(futbol);
            ranking.addAll(basquetbol);
            ranking.addAll(voleibol);
            System.out.println("Ranking de jugadores por ID:");
            ranking.forEach(j -> System.out.println("Id: " + j.getId() + ", Nombre: " + j.getNombre()));
        }

} 
