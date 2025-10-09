package models;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceEvaluacion {
    
    //1. Listar todos los empleados de un departamento en especifico
    public List<Empleado> listarPorDepartamento(List<Empleado> todosEmpleados, String departamento){
        return todosEmpleados.stream()
                .filter(e -> e.getDepartamento().equalsIgnoreCase(departamento))
                .sorted(Comparator.comparing(Empleado::getNombre))
                .collect(Collectors.toList());
    }

    //2. Calcular el salario promedio por departamento
    public Map<String, Double> calcularSalarioPromedioPorDepartamento(List<Empleado> empleados) {
        return empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento,
                Collectors.averagingDouble(Empleado::getSalario) // Calcula el promedio por grupo
        ));
    }

    //3. Obtener el empleado con mayor salario en toda la empresa
    public Optional<Empleado> empleadoMayorSalario (List<Empleado> empleados) {
        return empleados.stream()
                .max(Comparator.comparingDouble(Empleado::getSalario));
    }

    //4. Listar todos los empleados con más de cinco años de experiencia y salario mayor a 50,000
    public List<Empleado> empleadosMayorExperienciaSalario (List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getAniosExperiencia() >= 5 && e.getSalario() >= 50000)
                .collect(Collectors.toList());
    }

    //5. Obtener el top 3 de empleados con mejor puntaje en la ultima evaluacion
    public List<Empleado> top3UltimaEvaluacion (List<Empleado> empleados) {
        return empleados.stream()
                    .sorted(Comparator.comparingInt(this::obtenerUltimaEvaluacion).reversed())
                    .limit(3)
                    .collect(Collectors.toList());
    }

    public int obtenerUltimaEvaluacion (Empleado empleado){
            return empleado.getHistorialEvaluacion().stream()
            .max(Comparator.comparingInt(Evaluacion::getAnio))
                                    .map(Evaluacion::getPuntuaje)
                                    .orElse(0);
    }

    //6. Contar cuantos empleados tienen al menos una evaluacion superior a 90 puntos
    public long contarEvaluacionSuperior90 (List<Empleado> empleados){
        return empleados.stream()
                .filter(empleado -> empleado.getHistorialEvaluacion().stream()
                        .anyMatch(eval -> eval.getPuntuaje() > 90))
                .count();
    }
    
    public List<String> EmpleadosConEvaluacionesSuperioresA90 (List<Empleado> empleados) {
        return empleados.stream()
            .filter(empleado -> empleado.getHistorialEvaluacion().stream()
                .anyMatch(eval -> eval.getPuntuaje() >=90)) //Se verifica si se cumple con la condicion
            .map(Empleado::getNombre)
            .collect(Collectors.toList()); 
    }

    //7. Generar un ranking de promedio de puntajes por empleado 
    public Map<String, Double> generarRankingPromedioPuntajes(List<Empleado> empleados) {
        return empleados.stream()
            .collect(Collectors.toMap(
                Empleado::getNombre,
                empleado -> empleado.getHistorialEvaluacion().stream()
                .collect(Collectors.averagingInt(Evaluacion::getPuntuaje))
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2) -> e1,
                    LinkedHashMap::new
                    ));
    }

}
