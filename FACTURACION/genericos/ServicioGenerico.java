package genericos;

import java.util.ArrayList;
import java.util.List;

public class ServicioGenerico <T extends Identificable<ID>, ID> {
    private List<T> datos = new ArrayList<>();

    // public ServicioGenerico() {
    //     datos = new ArrayList<>();
    // }

    //Buscar elemento por ID
    public T buscarPorId(ID  id){

        for (T elemento : datos) {
            if (elemento.getID().equals(id)) {
                return elemento;
            }
        }
        return null;
    }

    //Guardar elemento sin duplicarse
    public void guardar(T elemento){
        if (buscarPorId(elemento.getID()) != null) {
            System.out.println("Ya existe el emento con ID: " + elemento.getID());
        } else {
            datos.add(elemento);
            System.out.println("Guardado: " + elemento);
        }
    }

    //Listar todos los elementos
    public List<T> listar(){
        return datos;
    }

    //Actualizar un elemento de datos de acuerdo al ID
    public boolean actualizar(ID id, T nuevoElemento){
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getID().equals(id)) { //get(i) obtiene el valor del elemento en la posiciion i
                datos.set(i, nuevoElemento);
                System.out.println("Actualizado ID " + id + "con: " + nuevoElemento);
                return true;
            } 
        }
        System.out.println("No se encontro ID " + id + " para actualizar");
        return false;
    }

    //Eliminar un elemento con ID
    public boolean eliminar(ID id){
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getID().equals(id)) {
                datos.remove(i);
                System.out.println("Eliminado ID: " + id);
                return true;
            }
        }
        System.out.println("No se encontro el ID: " + id);
        return false;
    }
}
