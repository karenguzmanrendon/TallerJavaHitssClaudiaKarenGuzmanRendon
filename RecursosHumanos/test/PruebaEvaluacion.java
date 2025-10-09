package test;
import java.util.List;

import models.Empleado;
import models.Evaluacion;
import models.ServiceEvaluacion;

public class PruebaEvaluacion {
   
    public static void main(String[] args) {
        ServiceEvaluacion service = new ServiceEvaluacion();

        //Empleados
        Empleado e1 = new Empleado(1, "Luis Paez", "DevOps", 55000, 5);
        Empleado e2 = new Empleado(2, "Valentín Sanchez", "IT", 35000, 2);
        Empleado e3 = new Empleado(3, "Manuel Barrera", "Testing", 30000, 3);
        Empleado e4 = new Empleado(4, "Vanessa Sandoval", "Testing", 32000, 4);
        Empleado e5 = new Empleado(5, "Ernesto Valdez", "IT", 35000, 3);
       
        //Evaluaciones
        //Empleado 1
        e1.agregarEvaluacion(new Evaluacion(e1, 2025, 80));
        e1.agregarEvaluacion(new Evaluacion(e1, 2024, 90));
        e1.agregarEvaluacion(new Evaluacion(e1, 2023, 85));
        e1.agregarEvaluacion(new Evaluacion(e1, 2022, 92));
        e1.agregarEvaluacion(new Evaluacion(e1, 2021, 90));

        //Empleado 2
        e2.agregarEvaluacion(new Evaluacion(e2, 2025, 60));
        e2.agregarEvaluacion(new Evaluacion(e2, 2024, 85));

        //Empleado 3
        e3.agregarEvaluacion(new Evaluacion(e3, 2025, 90));
        e3.agregarEvaluacion(new Evaluacion(e3, 2024, 92));
        e3.agregarEvaluacion(new Evaluacion(e3, 2023, 88));

        //Empleado 4
        e4.agregarEvaluacion(new Evaluacion(e4, 2025, 85));
        e4.agregarEvaluacion(new Evaluacion(e4, 2024, 92));
        e4.agregarEvaluacion(new Evaluacion(e4, 2023, 70));
        e4.agregarEvaluacion(new Evaluacion(e4, 2022, 67));

        //Empleado 5
        e5.agregarEvaluacion(new Evaluacion(e5, 2025, 80));
        e5.agregarEvaluacion(new Evaluacion(e5, 2024, 70));
        e5.agregarEvaluacion(new Evaluacion(e5, 2023, 75));

        //Listado de todos los empleados
        List<Empleado> empleados = List.of(e1, e2, e3, e4, e5);
        System.out.println("\n============Empleados=============");
        empleados.forEach(System.out::println);

        //1. Listar empleados por departamento
        //System.out.println(service.listarPorDepartamento(empleados, "Testing"));
        System.out.println("\n=========Empleados por departamento Testing=============");
        service.listarPorDepartamento(empleados, "Testing").forEach(System.out::println);
        
       //2. Calcular el salario promedio por departamento
       //System.out.println(service.calcularSalarioPromedioPorDepartamento(empleados));
        System.out.println("\n===========Promedio por departamento============");
        service.calcularSalarioPromedioPorDepartamento(empleados).forEach((depto, avg) ->
            System.out.printf("\n%s: %.2f\n", depto, avg));


        //3. Obtener el empleado con mayor salario en toda la empresa
        System.out.println("\n=========Empleado con mejor salario===========");
        service.empleadoMayorSalario(empleados).ifPresent(System.out::println);

        //4. Listar todos los empleados con más de 5 años de experiencia y salario mayor a 50,000
        System.out.println("\n==========Empleados con más de 5 años de experiencia y salario mayor a 50,000");
       service.empleadosMayorExperienciaSalario(empleados).forEach(System.out::println);
        

        //5. Obtener el top 3 empleados con mejor puntaje en la ultima evaluación (ultimo año)
        System.out.println("\n======Top 3 empleados Mejor Puntaje Ultima Evaluacion==========");
        service.top3UltimaEvaluacion(empleados).stream()
                                    .map(e -> e.getNombre() + "(Puntaje: " + service.obtenerUltimaEvaluacion(e) + ")")
                                    .forEach(System.out::println);

        //6. Contar cuantos empleados tienen al menos una evaluacion superior a 90 puntos
        System.out.println("\nEmpleados con al menos una evaluación > 90: ");
        System.out.println(service.contarEvaluacionSuperior90(empleados));
        System.out.println("\n=====Nombres de empleados que tienen al menos una puntuacion mayor a 90===");
        service.EmpleadosConEvaluacionesSuperioresA90(empleados).forEach(System.out::println);

        //7. Generar un ranking de promedio de puntajes por empleado 
        System.out.println("\n======Ranking Promedio de Puntajes por Empleado");
        service.generarRankingPromedioPuntajes(empleados).forEach((nombre, avg) ->
                System.out.printf("\n%s: %.2f", nombre, avg));
         
    }
}