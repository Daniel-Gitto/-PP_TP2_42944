package tp1;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // a. Se construya una lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("50111", "Ana Gomez"));
        estudiantes.add(new Estudiante("50222", "Lionel Messis"));
        estudiantes.add(new Estudiante("50333", "Coto Romero"));
        estudiantes.add(new Estudiante("50444", "Martha Sanchez"));


        // b. Crear Evento
        EventoUniversitario evento1 =
                new EventoUniversitario(
                        "E01",
                        "Jornada de Software",
                        10000,
                        false
                );

        EventoUniversitario evento2 =
                new EventoUniversitario(
                        "E02",
                        "Jornada de Hackathon",
                        8000,
                        true
                );


        // c. Se asigna la sala a cada evento
        Sala sala1 =
                new Sala(
                        1,
                        "Laboratorio Multimedial"
                );

        Sala sala2 =
                new Sala(
                        2,
                        "Laboratorio IA"
                );

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);


        // d. Se creen actividades propias de cada evento

        evento1.crearActividad(
                01,
                "Taller de Spring Boot",
                30,
                "Taller"
        );

        evento1.crearActividad(
                02,
                "Charla de Arquitectura Limpia",
                50,
                "Charla"
        );


        evento2.crearActividad(
                03,
                "Competencia de Programación con IA",
                60,
                "Taller"
        );

        evento2.crearActividad(
                04,
                "Creacion de prompt IA",
                20,
                "Charla"
        );


        // Obtenemos las actividades
        Actividad actividad1 =
                evento1.getActividades().get(0);

        Actividad actividad2 =
                evento1.getActividades().get(1);

        Actividad actividad3 =
                evento2.getActividades().get(0);

        Actividad actividad4 =
                evento2.getActividades().get(1);


        // e. Se inscriben estudiantes en cada actividad

        actividad1.inscribir(
                estudiantes.get(0)
        );

        actividad1.inscribir(
                estudiantes.get(1)
        );


        actividad2.inscribir(
                estudiantes.get(1)
        );

        actividad2.inscribir(
                estudiantes.get(2)
        );


        actividad3.inscribir(
                estudiantes.get(0)
        );

        actividad3.inscribir(
                estudiantes.get(2)
        );


        actividad4.inscribir(
                estudiantes.get(0)
        );

        actividad4.inscribir(
                estudiantes.get(1)
        );


        // f. Mostrar resumen de eventos creados

        evento1.mostrarDatos();

        evento2.mostrarDatos();


        // Crear copia de eventos

        EventoUniversitario copiaEvento1 =
                new EventoUniversitario(evento1);

        EventoUniversitario copiaEvento2 =
                new EventoUniversitario(evento2);


        System.out.println();
        System.out.println("EVENTO 1");

        evento1.mostrarDatos();


        System.out.println();
        System.out.println("COPIA EVENTO 1");

        copiaEvento1.mostrarDatos();


        System.out.println();
        System.out.println("EVENTO 2");

        evento2.mostrarDatos();


        System.out.println();
        System.out.println("COPIA EVENTO 2");

        copiaEvento2.mostrarDatos();


        // g. Mostrar Contador de eventos creados

        System.out.println();

        System.out.println(
                "Cantidad total de eventos creados: "
                        + EventoUniversitario.getCantidadEventos()
        );
    }
}